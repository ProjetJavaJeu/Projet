package PPersonnages;

public class MonstresCommuns {
	private int type; // Market => 1, compta => 2 , business=>3 , commerc=>4 , droit=>5
				// Necessaire pour la DB je pense !
	private String nom;
	private int xpDonnee;
	private int coordX;
	private int coordY;
	private Caract caracteristiques;
	private String replique;
	
	//Vérifie pls :) Si tu es OK je continue la dessus !
	
	public MonstresCommuns(int type, String nom,int xpDonnee, int x, int y,  Caract caracteristiques, String replique) {
		this.type = type;
		this.nom = nom;
		this.xpDonnee = xpDonnee;
		this.caracteristiques.setForce = caracteristiques.setForce;//Pas sur?
		this.caracteristiques.setIntelligence = caracteristiques.setIntelligence;//Pas sur?
		this.caracteristiques.setEndurance = caracteristiques.setEndurance; //Pas sur?
		// this.pv = caracteristiques.getEndurance() * 10;
		this.replique = replique;
	}
	
	/*
	 * TO DO :
	 * 1) return xp donnee
	 * 2) randomMonstres (void?) (int?)
	 * 3) Autres?
	 * 
	 */
	public int xpDonnee(){
		return this.xpDonnee;
	}
	
	/**
	 * Gere les coups critiques 
	 *   si Math.random >= 0.85, attaque de 2 ! (== coup critique)
	 *   si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 *   si Math.random > 0.15 (== coup raté)
	 * @return int = puissance de l'attaque
	 */
	
	public int randomAttaque(){
		double rand = Math.random();
		if ( rand >= 0.85)
			return 2;
		else if ((rand < 0.85) && (rand >= 0.15))
			return 1;
		else
			return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caract car = new Caract(1,1,1);
		MonstresCommuns Market = new MonstresCommuns(1, "Market'eux", 2, 0, 0, car, " U SHALL NOT PASS");
		int i = Market.xpDonnee();
		//System.out.println("xp donnée = " + i); // Euuh ca marche pas ????
		System.out.println("salut");

	}

}
