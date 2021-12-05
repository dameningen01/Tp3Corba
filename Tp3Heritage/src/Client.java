import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
	public static void main(String args[]) {

		java.util.Properties props = System.getProperties();

		int status = 0;
		org.omg.CORBA.ORB orb = null;

		try {
			orb = org.omg.CORBA.ORB.init(args, props);
			status = run(orb);
		} catch (Exception ex) {
			ex.printStackTrace();
			status = 1;
		}

		if (orb != null) {
			try {
				orb.destroy();
			} catch (Exception ex) {
				ex.printStackTrace();
				status = 1;
			}
		}

		System.exit(status);
	}

	static int run(org.omg.CORBA.ORB orb) {

		org.omg.CORBA.Object obj = null;
		try {
			String reffile = "CompteCourantRemunere.ref";
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(reffile));
			String ref = in.readLine();
			obj = orb.string_to_object(ref);
		} catch (java.io.IOException ex) {
			ex.printStackTrace();
		}
		CompteCourantRemunere ccr = CompteCourantRemunereHelper.narrow(obj);

		char ch = lire_choix();
		while (ch != '0') {
			switch (ch) {
			case '1':
				System.out.println(ccr.lire_montant());
				break;
			case '2':
				ccr.crediter(300);
				break;
			case '3':
				ccr.debiter(200);
				break;
			case '4':
				System.out.println(ccr.taux()); 
				break;
			case '5':
				int nouveauTaux = (int) lire_float();
				ccr.taux(nouveauTaux);
				break;
			case '6':
				System.out.println(ccr.DecouvertAutorise()); 
				break;
			case '7':
				boolean nouvelleDecouvert = false;
				float temp = lire_float();
				if (temp == 1)
					nouvelleDecouvert = true;
				else
					nouvelleDecouvert = false;
				ccr.DecouvertAutorise(nouvelleDecouvert);
				break;
			default:
				System.out.println("Veuillez entrer un choix entre 1 et 7");
			}
			ch = lire_choix();
		}

		return 0;
	}

	static char lire_choix() {
		System.out.println("+------------------+");
		System.out.println("| Service bancaire |");
		System.out.println("+------------------+\n");
		System.out.println("1 : Lecture du montant du compte");
		System.out.println("2 : Credit du compte");
		System.out.println("3 : Debit du compte\n");
		System.out.println("4 : Lecture du taux de r�mun�ration\n");
		System.out.println("5 : Mise a jour du taux de remuneration");
		System.out.println("6 : Lecture de l'autorisation de decouvert");
		System.out.println("7 : Mise a jour de l'autorisation de decouvert\n");
		System.out.println("0 : Quitter\n");
		System.out.println("Taper le code de l'operation a effectuer : ");
		return (lire_char());
	}

	static char lire_char() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (' ');
		}
		return (chaine.charAt(0));
	}

	static float lire_float() {
		String chaine;
		try {
			java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
			BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
			chaine = in.readLine();
		} catch (java.io.IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			return (0);
		}
		return (Float.parseFloat(chaine));
	}
}