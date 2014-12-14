package PPersonnages;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */

public class Caract {
	private int force; // Propres aux guerriers
	private int intelligence; // Propres aux mages
	private int endurance; // Pour les 2
	private int caractSecondaire[] = {0,0,0,0,1,1,1,1,2,2};
	//m�thode pour intel pour le mage (+1 chaque niveau)
	
	// m�thode pour force pour le war (+1 chaque niveau)
	// m�thode void EnduLeveLup() pour ajouter l'endurance chaque niveau (+1)
	
	public Caract(int force, int intelligence, int endurance) {
		this.force = force;
		this.intelligence = intelligence;
		this.endurance = endurance;
	}

	public Caract(){
		
	}
	public int getForce() {
		return force;
	}
	
	/**
	 * @param force - int
	 * 
	 */
	public void setForce(int force) {
		if(force < 100 | force > 0) 
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
	 * Augmentation l'endurance lors du niveau up de 1
	 */
	public void enduLeveLUp() {
		this.endurance = this.endurance + 1;
	}
	
	/**
	 * Le mage ayant l'intelligence comme caract�ristique primaire, elle augmente de 1 � chaque niveau
	 */
	public void mageGetIntel() {
		this.intelligence = this.intelligence +1;
	}
	
	/**
	 * En fonctionn de son lvl et du tab des caract�ristiques secondaires, le mage voit sa force (=caract secondaire) augment�e 
	 * @param niveau actuel
	 */
	public void mageGetForce(int niveau) {
		this.force = caractSecondaire[niveau - 1];
	}
	
	/**
	 * En fonctionn de son lvl et du tab des caract�ristiques secondaires, le guerrier voit son intelligence (=caract secondaire) augment�e 
	 * @param niveau actuel
	 */
	public void guerrierGetIntel(int niveau){
		this.intelligence = caractSecondaire[niveau - 1];		
	}
	
	/**
	 * Le guerrier ayant la force comme caract�ristique primaire, elle augmente de 1 � chaque niveau
	 */
	public void guerrierGetForce() {
		this.force = this.force + 1;
	}
	
}
