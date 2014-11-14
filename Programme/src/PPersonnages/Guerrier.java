package PPersonnages;

public class Guerrier {

	private String nom;
	private char type; // M ou G
	private Caract caracteristiques;
	private int pv;
	private int xp;
	private int niveau;
	
	
	public Guerrier(String nom, Caract caracteristiques,int xp, int niveau) {
		this.nom = nom;
		this.type = 'G';
		this.caracteristiques = caracteristiques.getCaract(this.type);
		this.pv = caracteristiques.getEndurance() * 10;
		this.xp = xp;
		this.niveau = niveau;
	}

	
	/*
	 * valeur de base
	 * classe combat  
	 * 
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caract car = new Caract(1,0,1);
		Guerrier premier = new Guerrier("Salut", car, 0, 1);

	}
}
