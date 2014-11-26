package PPersonnages;

public class Mage extends Personnage{
	private int xp;
	private int niveau;
	private int mana;

	public Mage(String nom, Caract car, char type, int pv, int xp, int niveau, int mana) { 
		//probleme avec char type? peut importe ce qu'on va lui donner il va le remplacer?
		//constructeur classe mere : String nom, Caract caracter, char type
		super(nom, car, type); // Récupération  du 1er constructeur (celui pour les guerriers ou mages !!
		this.xp = xp;
		this.niveau = niveau;
		this.mana = car.getIntelligence()*10;
	}

	public static void main(String[] args) {
		Caract car = new Caract(1,0,1);
		//Mage premier = new Mage("bonjour", car, );
	}

}
