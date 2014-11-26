package PPersonnages;

public class MonstresCommuns extends Personnage{
	private int xpDonnee;
	

	public MonstresCommuns(String nom, Caract caracter, char type, String repliqueMonstres,int xpDonnee) {
		//String nom, Caract caracter, char type, String repliqueMonstres == Contructeur de mosntres
		super(nom, caracter, type, repliqueMonstres);
		this.xpDonnee = xpDonnee;
	}
	

	public int xpDonnee(){
		return this.xpDonnee;
	}
	
	/**
	 * Gere les coups critiques 
	 *   si Math.random >= 0.85, attaque de 2 ! (== coup critique)
	 *   si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 *   si Math.random > 0.15 (== coup raté)
	 * @return int = puissance de l'attaque
	 */
	
	public int randomAttaque(){
		double rand = Math.random();
		if ( rand >= 0.85)
			return 2;
		else if ((rand < 0.85) && (rand >= 0.15))
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		Caract car = new Caract(1,2,5);
		//MonstresCommuns(String nom, Caract caracter, char type, String repliqueMonstres,int xpDonnee)
		MonstresCommuns market = new MonstresCommuns("Market'eux", car, '1', "MOAR PUB IN YOUR FACES", 20);
		int i = market.xpDonnee();
		System.out.println("-----------------");
		System.out.println("nom = " + market.getNom());
		System.out.println("xp donnée = " + i);
		System.out.println("FORCE = " + car.getForce());
		System.out.println("INTEL = " + car.getIntelligence());
		System.out.println("ENDU = "+ car.getEndurance());
		}
}
