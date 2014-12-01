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


	public static void main(String[] args) {
		Caract car = new Caract(1,2,5);
		//MonstresCommuns(String nom, Caract caracter, char type, String repliqueMonstres,int xpDonnee)
		MonstresCommuns market = new MonstresCommuns("Market'eux", car, '1', "MOAR PUB IN YOUR FACES", 20);
		int i = market.xpDonnee();
		System.out.println("-----------------");
		System.out.println("nom = " + market.getNom());
		//ystem.out.println("xp donnée = " + i);
		System.out.println("FORCE = " + car.getForce());
		System.out.println("INTEL = " + car.getIntelligence());
		System.out.println("ENDU = "+ car.getEndurance());
	}
}
