package PPersonnages;

public class Mage extends Personnage{
	private String nom;
	private char type; // M ou G
	private Caract caracteristiques;
	private int pv;
	private int xp;
	private int niveau;

	public Mage(String nom, int intel, int force, int endu, char type, int pv, int xp, int niveau) {
		//constructeur classe mere : String nom, int intel, int force, int endu, char type ,int pv
		super(nom, intel, force, endu, type, pv); // Récupération  du 1er constructeur (celui pour les guerriers ou mages !!)
		this.type = 'M';
		this.xp = xp;
		this.niveau = niveau;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caract car = new Caract(1,0,1);
		//Mage premier = new Mage("bonjour", car, 1);
	}

}
