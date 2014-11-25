package PPersonnages;

public class Guerrier extends Personnage{
	/*
	 * Ce qu'a le guerrier, TOUT ce qu'il a (même ce que contient la classe mère !
	 */
	private String nom;
	private char type; // M ou G
	private Caract caracteristiques;
	private int xp;
	private int niveau;
	
	
	public Guerrier(String nom, int intel, int force, int endu, char type, int pv, int xp, int niveau) {
		//constructeur classe mere : String nom, int intel, int force, int endu, char type ,int pv
		super(nom, intel, force, endu, type, pv); // Récupération  du 1er constructeur (celui pour les guerriers ou mages !!)
		this.type = 'G'; // G pour Guerrier
		this.xp = xp;
		this.niveau = niveau;
	}

	
	/*
	 * valeur de base
	 * classe combat  
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Caract car = new Caract(1,0,1);
		//Guerrier premier = new Guerrier("Salut", car, 0, 1);

	}
}
