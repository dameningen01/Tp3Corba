
public class CompteCourantRemunereImpl extends CompteCourantRemunerePOA{
	
	boolean decouvertAutorise = false;
	float solde = 2000;
	int taux = 5;
	

	public CompteCourantRemunereImpl(float solde, int taux, boolean decouvertAutorise) {
		this.solde = solde;
		this.taux = taux;
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public boolean DecouvertAutorise() {
		
		return this.decouvertAutorise;
	}

	@Override
	public void DecouvertAutorise(boolean newDecouvertAutorise) {
		this.decouvertAutorise = newDecouvertAutorise;
		
	}

	@Override
	public float lire_montant() {
		return solde;
	}

	@Override
	public void crediter(float somme_credit) {
		solde += somme_credit;
		
	}

	@Override
	public void debiter(float somme_debit) {
		if (solde < 0) {
			if (decouvertAutorise)
				solde -= somme_debit;
			else
				System.out.println("Vous n'avez pas la decouverte activ�e !");
		}
		else
			solde -= somme_debit;
	}

	@Override
	public int taux() {
		return taux;
	}

	@Override
	public void taux(int newTaux) {
		this.taux = newTaux;
	}

}
