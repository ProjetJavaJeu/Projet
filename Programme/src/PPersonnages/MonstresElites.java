/**
 * 
 */
package PPersonnages;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */
public class MonstresElites extends Personnage{
	private int xpDonnee;
	
	public MonstresElites(String nom, Caract caracter, char type, String repliqueMonstres,int xpDonnee) {
		//String nom, Caract caracter, char type, String repliqueMonstres == Contructeur de mosntres
		super(nom, caracter, type, repliqueMonstres);
		this.xpDonnee = xpDonnee;
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
