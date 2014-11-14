package PPersonnages;

public class Mage{
	private String nom;
	private char type; // M ou G
	private Caract caracteristiques;
	private int pv;
	private int xp;
	private int niveau;

	public Mage(String nom, Caract caracteristiques, int niveau) {
		this.nom = nom;
		this.type = 'M';
		this.caracteristiques = caracteristiques.getCaract(this.type);
		this.pv = caracteristiques.getEndurance() * 7;
		this.niveau = niveau;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caract car = new Caract(1,0,1);
		Mage premier = new Mage("bonjour", car, 1);
	}

}
