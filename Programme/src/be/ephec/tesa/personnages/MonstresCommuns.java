package be.ephec.tesa.personnages;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */
public class MonstresCommuns extends Personnage{
	private int xpDonnee;

	public MonstresCommuns(String nom, Caract caracter, char type, String repliqueMonstres,int xpDonnee) {
		//String nom, Caract caracter, char type, String repliqueMonstres == Contructeur de mosntres
		super(nom, caracter, type, repliqueMonstres);
		this.xpDonnee = xpDonnee;
	}
	
	public MonstresCommuns(){
		
	}

	public int getXpDonnee() {
		return xpDonnee;
	}

	public void setXpDonnee(int xpDonnee) {
		this.xpDonnee = xpDonnee;
	}

	public int xpDonnee(){
		return this.xpDonnee;
	}

}
