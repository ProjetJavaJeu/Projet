package PPersonnages;

public class Guerrier {

	private String nom;
	private Caract caracteristiques;
	private int pv;
	private int xp;
	
	public Guerrier(String nom, Caract caracteristiques) {
		this.nom = nom;
		this.caracteristiques = caracteristiques;
		this.pv = caracteristiques.getEndurance() * 10;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
