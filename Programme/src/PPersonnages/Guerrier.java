package PPersonnages;

public class Guerrier extends Personnage{
	private int xp;
	private int niveau;
	
	
	public Guerrier(String nom, Caract caracteristiques, char type, int xp, int niveau) {
		//constructeur classe mere : String nom, int intel, int force, int endu, char type ,int pv
		super(nom, caracteristiques, type); // Récupération  du 1er constructeur (celui pour les guerriers ou mages !!)
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
		//Caract car = new Caract(1,0,1);
		//Guerrier premier = new Guerrier("Salut", car, 0, 1);

	}
}
