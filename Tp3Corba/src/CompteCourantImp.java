import org.omg.CORBA.FloatHolder;

public class CompteCourantImp extends CompteImp implements CompteCourantOperations {

	private boolean DecouvertAutorise = true;
	
	public CompteCourantImp(float solde,boolean DecouvertAutorise) {
		super(solde);
		this.DecouvertAutorise = DecouvertAutorise;
	}

	@Override
	public float lire_montant(FloatHolder solde) {
		// TODO Auto-generated method stub
		if (this.DecouvertAutorise()==true) {
			super.lire_montant(solde);
			return solde.value;
		}
		else {System.out.println("decouvert non autorisee");return 0;}
		
	}

	@Override
	public void crediter(float somme_credit, FloatHolder solde) {
		// TODO Auto-generated method stub
		if (this.DecouvertAutorise()==true) {super.crediter(somme_credit,solde);}
		else {System.out.println("decouvert non autorisee");}
	}

	@Override
	public void debiter(float somme_debit, FloatHolder solde) {
		// TODO Auto-generated method stub
		if (this.DecouvertAutorise()==true) {super.debiter(somme_debit,solde);}
		else {System.out.println("decouvert non autorisee");}
	}

	@Override
	public boolean DecouvertAutorise() {
		// TODO Auto-generated method stub
		return this.DecouvertAutorise;
	}

	@Override
	public void DecouvertAutorise(boolean newDecouvertAutorise) {
		// TODO Auto-generated method stub
		this.DecouvertAutorise = newDecouvertAutorise;
		
	} }
