package PPersonnages;

public class Personnage {
	private String nom;
	private Caract caracter;
	private int pv;
	private char type;
	private String repliqueMonstres;
	private Experience experience;
	
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
	public Personnage(String nom, Caract caracter, char type, String repliqueMonstres) {
		this.nom = nom;
		this.caracter = caracter;
		this.repliqueMonstres = repliqueMonstres;
		this.type = type; // Vérification type?
		if ((type == '1') | (type =='2') | (type == '3') | (type == '4') | (type == '5')){
			// Pour les Communs
			this.pv = caracter.getEndurance()*5;}
		else if ((type == '6') | (type == '7') | (type == '8') | (type == '9'))
			// Pour les bosses
			this.pv = caracter.getEndurance()*7;
	}

	/**
	 * Contructeur pour Guerrier ou Mage
	 * @param nom 
	 * @param intel
	 * @param force
	 * @param endu
	 * @param pv
	 
	public Personnage(String nom, Caract caracter, char type) { 
		this.nom = nom;
		this.caracter = caracter;
		this.type = type;
		if (type == 'M')
			this.pv = caracter.getEndurance()*7;
		else
			this.pv = caracter.getEndurance()*10; 
	}*/
	
	//Constructeur vide
	public Personnage(){
		
	}
	
	public void setPvIntial(){
		if (type == 'M')
			this.pv = caracter.getEndurance()*7;
		else
			this.pv = caracter.getEndurance()*10;
	}
	
	public Experience getExperience() {
		return experience;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public Caract getCaracter() {
		return caracter;
	}

	public void setCaracter(Caract caracter) {
		this.caracter = caracter;
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
/*
	/**
	 * Créer les PV pour les monstres communs et pour les élites
	 * @param endu*5 si monstres communs, endu*7 si montres Elite/boss
	 * @param type 1,2,3,4,5 = monstres communs et 7,8 si monstres Elites
	 * @return
	 */
/*
	public int setPVMonstres(int endu, int type){
		if ((type < 5 ) && (type > 0)) // type Monstres Communs
			return endu*5;
		else if ((type >= 5 ) && (type < 8)) // type Monstres boss -> type MAX A CHANGER !! 
			return endu*7;
		else 
			return -1;
	}
*/
	public static void main(String[] args) {
		Caract car = new Caract(1,2,3);
		//Personnage un = new Personnage("bonjour", car, 'M'); //String nom, int intel, int force, int endu, char type ,int pv
		//System.out.println("Endu = " + un.caracter.getEndurance() + " PV =  " + un.pv); // Pour vérifier que PV=7*endu mais plante !!	
		//String nom, Caract caracter, char typeMonstres, String repliqueMonstres
		Personnage monst = new Personnage("Hihi", car, '1', "U SHALL NOT PASS");
		System.out.println("Monstres = " + monst.pv);
	}
}
