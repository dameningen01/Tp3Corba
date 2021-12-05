
/**
* CompteCourantPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banque.idl
* mercredi 24 novembre 2021 11 h 10 GMT+01:00
*/

public class CompteCourantPOATie extends CompteCourantPOA
{

  // Constructors

  public CompteCourantPOATie ( CompteCourantOperations delegate ) {
      this._impl = delegate;
  }
  public CompteCourantPOATie ( CompteCourantOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public CompteCourantOperations _delegate() {
      return this._impl;
  }
  public void _delegate (CompteCourantOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public boolean DecouvertAutorise ()
  {
    return _impl.DecouvertAutorise();
  } // DecouvertAutorise
  public void DecouvertAutorise (boolean newDecouvertAutorise)
  {
    _impl.DecouvertAutorise(newDecouvertAutorise);
  } // DecouvertAutorise

  public float lire_montant (org.omg.CORBA.FloatHolder solde)
  {
    return _impl.lire_montant(solde);
  } // lire_montant

  public void crediter (float somme_credit, org.omg.CORBA.FloatHolder solde)
  {
    _impl.crediter(somme_credit, solde);
  } // crediter

  public void debiter (float somme_debit, org.omg.CORBA.FloatHolder solde)
  {
    _impl.debiter(somme_debit, solde);
  } // debiter

  private CompteCourantOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class CompteCourantPOATie
