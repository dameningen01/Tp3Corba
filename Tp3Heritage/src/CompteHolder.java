
/**
* CompteHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from banque.idl
* dimanche 5 d?cembre 2021 22 h 31 GMT+01:00
*/

public final class CompteHolder implements org.omg.CORBA.portable.Streamable
{
  public Compte value = null;

  public CompteHolder ()
  {
  }

  public CompteHolder (Compte initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CompteHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CompteHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CompteHelper.type ();
  }

}
