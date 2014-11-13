package PPersonnages;

public class Caract {
	int force; // Propres aux guerriers
	int intelligence; // Propres aux mages
	int endurance; // Pour les 2
	//int defense; 
	
	public Caract(int force, int intelligence, int endurance) {
		this.force = force;
		this.intelligence = intelligence;
		this.endurance = endurance;
	}

	// Faire les validations ! (Empêcher valeurs négatives, valeurs nulles, valeurs trop grande).
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
