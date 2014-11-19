package PPersonnages;

public class MonstresCommuns {
	int type; // Market => 1, compta => 2 , business=>3 , commerc=>4 , droit=>5
				// Necessaire pour la DB je pense !
	String nom;
	int xpDonnee;
	int coordX;
	int coordY;
	Caract caracteristiques;
	String replique;
	
	//Vérifie pls :) Si tu es OK je continue là dessus !
	
	public MonstresCommuns(int type, String nom,int xpDonnee, int x, int y,  Caract caracteristiques, String replique) {
		this.type = type;
		this.nom = nom;
		this.xpDonnee = xpDonnee;
		this.caracteristiques.force = caracteristiques.force;//Pas sur?
		this.caracteristiques.intelligence = caracteristiques.intelligence;//Pas sur?
		this.caracteristiques.endurance = caracteristiques.endurance; //Pas sur?
		// this.pv = caracteristiques.getEndurance() * 10;
		this.replique = replique;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caract car = new Caract(1,1,1);
		MonstresCommuns Market = new MonstresCommuns(1, "Market'eux", 2, 0, 0, car, " U SHALL NOT PASS");

	}

}
