/**
 * 
 */
package PPersonnages;


public class MonstresElites {
	private int type; // Market => 1, compta => 2 , business=>3 , commerc=>4 , droit=>5
				// Necessaire pour la DB je pense !
	private String nom;
	private int xpDonnee;
	private int coordX;
	private int coordY;
	private Caract caracteristiques;
	private String replique;

	
	/**
	 * TO DO :
	 *  1) implémentation d'une randomAttaque (identique ??)
	 */
	
	public int randomAttaque(){
		if (Math.random() >= 0.85)
			return 2;
		else if ((Math.random() < 0.85) && (Math.random() >= 0.15))
			return 1;
		else
			return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
