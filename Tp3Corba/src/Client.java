import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.omg.CORBA.FloatHolder;
import org.omg.CORBA.SystemException;

public class Client
{ 
	public static void main (String args[]){
		java.util.Properties props = System.getProperties();

		 int status = 0;
		 org.omg.CORBA.ORB orb = null;

		 try
		 {
		 orb = org.omg.CORBA.ORB.init(args, props);
		 status = run(orb);
		 }
		 catch(Exception ex)
		 {
		 ex.printStackTrace();
		 status = 1;
		 }

		 if(orb != null)
		 {
		 try
		 {
		 orb.destroy();
		 }
		 catch(Exception ex)
		 {
		 ex.printStackTrace();
		 status = 1;
		 }
		 }

		 System.exit(status);
	}
	 static int run(org.omg.CORBA.ORB orb) throws NamingException
	 {
	 org.omg.CORBA.Object obj = null;
	 
	 try {
		 
		 Context ctx = new InitialContext();
		 Object ref = ctx.lookup("BANQUE");
		 System.out.println(ref);
		 float motant;
		 Compte stub =  CompteHelper.narrow((org.omg.CORBA.Object)ref);
		 FloatHolder solde = new FloatHolder();
		// Liaison à un compte
		// Déclaration de l’objet compte et des variables
		// Boucle de saisie du choix du client
		char ch = lire_choix() ;
		while (ch != '0') {
		  switch(ch) {
		            case '1':
		              // Lecture du montant du compte
		              	stub.lire_montant(solde);
		              	System.out.println("votre solde est "+solde.value + "\n");
		              	break;
		            case '2':
		              // Crediter le compte
		            	System.out.print("Montant a crediter: ");
		            	motant = lire_float();
		            	stub.crediter(motant,solde);
		            	System.out.println("Compte s'est credite! votre nouveau solde est "+solde.value + "\n");
		            	break;
		            case '3':
		              // Debiter le compte
		            	System.out.print("Montant a debite: ");
		            	motant = lire_float();
		            	stub.debiter(motant,solde);
		            	System.out.println("Compte s'est debite! votre nouveau solde est "+solde.value + "\n");
		            	break;
		            default:
		              // Erreur de saisie
		            	System.out.println("Erreur de saisie, veuillez entrer un choix valide");
		          }
		          ch=lire_choix();
		}
		        
		      }
		      catch(SystemException ex) {
		    	  System.out.print(ex);
		      }
	return 0;
	 }


  static char lire_choix() {
      System.out.println( "+------------------+");
      System.out.println( "| Service bancaire |");
      System.out.println( "+------------------+\n");
      System.out.println( "1 : Lecture du montant du compte");
      System.out.println( "2 : Credit du compte" );
      System.out.println( "3 : Debit du compte\n" );
      System.out.println( "0 : Quitter\n");
      System.out.println( "Taper le code de l'operation a effectuer : ");
      return(lire_char());
  }
 
  static char lire_char() {
    String chaine;
    try {
      java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
      BufferedReader in =  new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(' ');
    }
    return((chaine.length()==1)?chaine.charAt(0):'o');
  }
   static float lire_float() {
    String chaine;
    try {
      java.io.DataInputStream dataIn =  new java.io.DataInputStream(System.in);
      BufferedReader in =  new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(0);
    }
    return(Float.parseFloat(chaine));
  }
 }
