import org.omg.CORBA.FloatHolder;

public class CompteCourantRemunereImp extends CompteCourantImp implements CompteCourantRemunereOperations{
	
	float taux;

	public CompteCourantRemunereImp(float solde, boolean DecouvertAutorise,float taux) {
		super(solde, DecouvertAutorise);
		this.taux = taux;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int taux() {
		// TODO Auto-generated method stub
		return (int) this.taux;
	}

	@Override
	public void taux(int newTaux) {
		// TODO Auto-generated method stub
		this.taux = newTaux;
	}
	
	@Override
	public void debiter(float montant, FloatHolder solde) {
		if(montant < this.getSolde() && this.DecouvertAutorise() == false) {
			System.out.println("Operation non autorise");
		return;
		}
		super.debiter(montant, solde);
	}

}
