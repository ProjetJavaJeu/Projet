package PPersonnages;

import main.Map;

import org.newdawn.slick.Animation;

public class Personnage {
	private String nom;
	private Caract caracter;
	private int pv;
	private char type;
	private String repliqueMonstres;
	/**
	 * Contructeur pour Guerrier ou Mage
	 * @param nom 
	 * @param intel
	 * @param force
	 * @param endu
	 * @param pv
	 */
	public Personnage(String nom, Caract caracter, char type) { //Pas correct pour PV?? vois pas comment faire?
		this.nom = nom;
		this.caracter = caracter;
		this.type = type;
		if (type == 'M')
			this.pv = caracter.getEndurance()*7;
		else if (type == 'G')
			this.pv = caracter.getEndurance()*10; // Ca c'est correct, mais alors on doit pas demander de int pv en argument !??? 
			//Ou bien ca va changer peut importe la valeur de pv qu'on mettra en argmument?
	}
	
	/**
	 * Constructeur pour Monstres communs et elites/bosses
	 * @param nom
	 * @param intel
	 * @param force
	 * @param endu
	 * @param typeMonstres
	 * @param pv
	 * @param repliqueMonstres
	 */
	public Personnage(String nom, int intel, int force, int endu, int typeMonstres ,int pv, String repliqueMonstres) {
		this.nom = nom;
		this.caracter.setForce(force);
		this.caracter.setIntelligence(intel);
		this.caracter.setEndurance(endu);
		this.repliqueMonstres = repliqueMonstres;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getRepliqueMonstres() {
		return repliqueMonstres;
	}

	public void setRepliqueMonstres(String repliqueMonstres) {
		this.repliqueMonstres = repliqueMonstres;
	}

	/**
	 * Créer les PV pour les monstres communs et pour les élites
	 * @param endu*5 si monstres communs, endu*7 si montres Elite/boss
	 * @param type 1,2,3,4,5 = monstres communs et 7,8 si monstres Elites
	 * @return
	 */

	public int setPVMonstres(int endu, int type){
		if ((type < 5 ) && (type > 0)) // type Monstres Communs
			return endu*5;
		else if ((type >= 5 ) && (type < 8)) // type Monstres boss -> type MAX A CHANGER !! 
			return endu*7;
		else 
			return -1;
	}

	public static void main(String[] args) {
		Caract car = new Caract(1,2,3);
		Personnage un = new Personnage("bonjour", car, 'M'); //String nom, int intel, int force, int endu, char type ,int pv
		System.out.println("Endu = " + un.caracter.getEndurance() + " PV =  " + un.pv); // Pour vérifier que PV=7*endu mais plante !!
	}

}
