package PPersonnages;

public class Personnage {
	private String nom;
	private Caract caracter;
	private int pv;
	private char type;
	private int typeMonstres;
	private String repliqueMonstres;
	
	
	/**
	 * Contructeur pour Guerrier ou Mage
	 * @param nom 
	 * @param intel
	 * @param force
	 * @param endu
	 * @param pv
	 */
	public Personnage(String nom, int intel, int force, int endu, char type ,int pv) { //PAs correct pour PV?? vois pas comment faire?
		this.nom = nom;
		this.caracter.setForce(force);
		this.caracter.setIntelligence(intel);
		this.caracter.setEndurance(endu);
		this.type = type;
		this.pv = setPV(endu, type); // Ca c'est correct, mais alors on doit pas demander de int pv en argument !??? 
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
		this.typeMonstres = typeMonstres;
		this.repliqueMonstres = repliqueMonstres;
	}
	
	
	/**
	 * Créer les PV pour un mage ou un guerrier
	 * @param endu*7 = mage, 
	 * @param type
	 * @return
	 */
	public int setPV(int endu, char type){
		if (type == 'M')
			return endu*7;
		else if (type == 'G')
			return endu*10;
		else
			return -1;
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
		
		Personnage un = new Personnage("bonjour", 1, 2, 3, 'M',5); //String nom, int intel, int force, int endu, char type ,int pv
		System.out.println("Endu =" + un.caracter.getEndurance() + " PV =  " + un.pv);
	}

}
