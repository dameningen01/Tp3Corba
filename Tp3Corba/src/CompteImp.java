import org.omg.CORBA.FloatHolder;

public class CompteImp implements CompteOperations {

	private float solde = 1000F;
	
	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public CompteImp(float solde) {
		this.solde = solde;
	}

	@Override
	public void crediter(float montant, FloatHolder solde) {
		// TODO Auto-generated method stub
		this.solde-=montant;
		solde.value = this.solde;
		System.out.println("Compte s'est credite! votre nouveau solde est "+this.solde + "\n");
		
	}

	@Override
	public void debiter(float montant, FloatHolder solde) {
		// TODO Auto-generated method stub
		this.solde +=montant;
		solde.value = this.solde;
		System.out.println("Compte s'est debite! votre nouveau solde est "+this.solde+ "\n");
		
	}

	@Override
	public float lire_montant(FloatHolder solde) {
		// TODO Auto-generated method stub
		solde.value = this.solde;
		System.out.println("Votre solde est : "+this.solde+ "\n");
		return solde.value;
	}
	


	

}
