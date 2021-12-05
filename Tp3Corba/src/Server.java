import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Server
{
  public static void main(String args[])
   {
 java.util.Properties props = System.getProperties();
      
      int status = 0 ;
      org.omg.CORBA.ORB orb = null ;

      try
       {
         orb = org.omg.CORBA.ORB.init ( args, props) ;
         status = run (orb) ;
       }
      catch (Exception ex)
       {
         ex.printStackTrace ();
         status = 1;
       } 

      if (orb != null)
       {
         try
         {
           orb.destroy() ;
         }
         catch (Exception ex)
          {
            ex.printStackTrace ();
            status = 1;
          } 
   }
  System.exit(status) ;
   }

// Création de l’objet d’implantation
    static int run(org.omg.CORBA.ORB orb) throws org.omg.CORBA.UserException, NamingException
    		 {
    	
    		 org.omg.PortableServer.POA rootPOA =
    		     org.omg.PortableServer.POAHelper.narrow(
    		        orb.resolve_initial_references("RootPOA"));

    		 org.omg.PortableServer.POAManager manager =
    		 rootPOA.the_POAManager();
    		 CompteCourantRemunereImp uncompte_delegue = new CompteCourantRemunereImp(10001F,true,100);
    		 ComptePOATie unCompteImpl = new ComptePOATie(uncompte_delegue);
    		 //Banque compte = banque._this(orb);    
			// Copie de la référence dans un fichier
			 try
			 {
				 Context ctx = new InitialContext();
				 ctx.rebind("BANQUE",rootPOA.servant_to_reference(unCompteImpl));
				 
				 manager.activate();
				 orb.run();
				 System.out.println( "+------------------+");
				 System.out.println( "| Service bancaire |");
				 System.out.println( "+------------------+\n");
			 /*String ref = orb.object_to_string(unCompte);
			 String refFile = "Compte.ref";
			 FileOutputStream file = new FileOutputStream(refFile);
			 PrintWriter out = new PrintWriter(file);
			 out.println(ref);
			 out.flush() ;
			 file.close();*/
			 }
			 catch(NamingException ex) {
				ex.printStackTrace();
			}
return 0;
 }
}
