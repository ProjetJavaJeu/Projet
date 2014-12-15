package be.ephec.tesa.personnages;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */
public class Personnage {
	private String nom;
	private Caract caracter;
	private int pv;
	private char type;
	private String repliqueMonstres;
	private Experience experience;
	private int niveau;

	/**
	 * Constructeur pour Monstres communs et elites/bosses
	 * @param nom du boss
	 * @param intel du boss
	 * @param force du boss
	 * @param endurance du boss
	 * @param typeMonstres si 1 <= typeMonstres <= 5 alors il s'agit d'un monstre commun
	 * 						si 6 <= typeMonstres <=9 alors il s'agit d'un monstre Elite
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

		//Constructeur vide
	public Personnage(){
	
	}
	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getNiveau() {
		return niveau;
	}
	
	/**
	 * Affecte l'endurance à la création du personnage, 2 cas possible :
	 * 1) si c'est un mage : endurance = 7
	 * 2) si c'est un guerrier : endurance = 10
	 */
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
		if ((this.pv - pv) <= 0){
			this.pv = 0;
		}
		else {
			this.pv = pv;
		}
		
	}
	
	public void setDiminutionPV(int pv){
		if ((this.pv - pv)<= 0){
			this.pv = 0;
		}
		else {
			this.pv = this.pv - pv;
		}
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
}
