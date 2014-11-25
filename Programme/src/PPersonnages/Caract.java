package PPersonnages;

public class Caract {
	private int force; // Propres aux guerriers
	private int intelligence; // Propres aux mages
	private int endurance; // Pour les 2
	private int caractSecondaire[] = {0,0,0,0,1,1,1,1,2,2};
	//m�thode pour intel pour le mage (+1 chaque level)
	
	// m�thode pour force pour le war (+1 chaque level)
	// m�thode void EnduLeveLup() pour ajouter l'endurance chaque level (+1)
	
	public Caract(int force, int intelligence, int endurance) {
		this.force = force;
		this.intelligence = intelligence;
		this.endurance = endurance;
	}

	// Faire les validations ! (Emp�cher valeurs n�gatives, valeurs nulles, valeurs trop grande).	
	
	// m�thode generate caract pour war et mage
	public int getForce() {
		return force;
	}
	
	/**
	 * @param force - int
	 * Que faire si force > 100?
	 */
	public void setForce(int force) {
		if(force < 100 && force > 0) 
			this.force = force;
		else
			System.err.println("force trop �lev�e !");
	}


	public int getIntelligence() {
		return intelligence;
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getEndurance() {
		return this.endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	/**
	 * augmentation les carac du mage lors du level up !! 
	 */
	public void enduLeveLUp() {
		this.endurance = this.endurance + 1;
	}
	
	public void mageGetIntel() {
		this.intelligence = this.intelligence +1;
	}
	
	public void mageGetForce(int level) {
		this.force = caractSecondaire[level - 1];
	}
	
	public void guerrierGetIntel(int level){
		this.intelligence = caractSecondaire[level - 1];		
	}
	
	public void guerrierGetForce() {
		this.force = this.force + 1;
	}
	
	/**
	 * affecte la force du guerrier a 1, l'intelligence  0 et son endurance � 2
	 * @return objet type Caract(force, intel, endu)
	 */
	public Caract getCaract(char type){
		Caract vGuerrier = new Caract(1, 0, 2);
		Caract vMage = new Caract(0, 1 , 2);
		if(type == 'M') 
			return vMage;
		else 
			return vGuerrier;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
