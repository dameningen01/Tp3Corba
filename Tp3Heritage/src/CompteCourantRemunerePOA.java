
/**
* CompteCourantRemunerePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banque.idl
* dimanche 5 d�cembre 2021 22 h 31 GMT+01:00
*/

public abstract class CompteCourantRemunerePOA extends org.omg.PortableServer.Servant
 implements CompteCourantRemunereOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_DecouvertAutorise", new java.lang.Integer (0));
    _methods.put ("_set_DecouvertAutorise", new java.lang.Integer (1));
    _methods.put ("lire_montant", new java.lang.Integer (2));
    _methods.put ("crediter", new java.lang.Integer (3));
    _methods.put ("debiter", new java.lang.Integer (4));
    _methods.put ("_get_taux", new java.lang.Integer (5));
    _methods.put ("_set_taux", new java.lang.Integer (6));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CompteCourant/_get_DecouvertAutorise
       {
         boolean $result = false;
         $result = this.DecouvertAutorise ();
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // CompteCourant/_set_DecouvertAutorise
       {
         boolean newDecouvertAutorise = in.read_boolean ();
         this.DecouvertAutorise (newDecouvertAutorise);
         out = $rh.createReply();
         break;
       }

       case 2:  // Compte/lire_montant
       {
         float $result = (float)0;
         $result = this.lire_montant ();
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 3:  // Compte/crediter
       {
         float somme_credit = in.read_float ();
         this.crediter (somme_credit);
         out = $rh.createReply();
         break;
       }

       case 4:  // Compte/debiter
       {
         float somme_debit = in.read_float ();
         this.debiter (somme_debit);
         out = $rh.createReply();
         break;
       }

       case 5:  // CompteEpargne/_get_taux
       {
         int $result = (int)0;
         $result = this.taux ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 6:  // CompteEpargne/_set_taux
       {
         int newTaux = in.read_long ();
         this.taux (newTaux);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CompteCourantRemunere:1.0", 
    "IDL:CompteCourant:1.0", 
    "IDL:Compte:1.0", 
    "IDL:CompteEpargne:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CompteCourantRemunere _this() 
  {
    return CompteCourantRemunereHelper.narrow(
    super._this_object());
  }

  public CompteCourantRemunere _this(org.omg.CORBA.ORB orb) 
  {
    return CompteCourantRemunereHelper.narrow(
    super._this_object(orb));
  }


} // class CompteCourantRemunerePOA