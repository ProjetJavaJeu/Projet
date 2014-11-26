/**
 * 
 */
package PPersonnages;


public class MonstresElites extends Personnage{
	private int xpDonnee;
	
	public MonstresElites(String nom, Caract caracter, char type, String repliqueMonstres,int xpDonnee) {
		//String nom, Caract caracter, char type, String repliqueMonstres == Contructeur de mosntres
		super(nom, caracter, type, repliqueMonstres);
		this.xpDonnee = xpDonnee;
	}
	
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
