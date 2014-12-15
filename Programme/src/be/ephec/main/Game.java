package be.ephec.main;

import org.newdawn.slick.SlickException;

import be.ephec.tesa.gui.InterfaceCarte;
import be.ephec.tesa.gui.InterfaceJeu;
import be.ephec.tesa.personnages.MonstresCommuns;
import be.ephec.tesa.personnages.MonstresElites;
import be.ephec.tesa.personnages.Personnage;

public class Game{
		
	private Personnage joueur;
	private MonstresCommuns tabMonstres[] = new MonstresCommuns[Constantes.NBR_MAX_MONSTRES];
	private MonstresElites tabElites[] = new MonstresElites[Constantes.NBR_MAX_ELITES];
	//private InterfaceCarte windowMap = new InterfaceCarte();
	private InitPartie init;
	
	public Game() {
		
	}
	public Personnage getJoueur() {
		return joueur;
	}
	public void setJoueur(Personnage joueur) {
		this.joueur = joueur;
	}
	public MonstresCommuns[] getTabMonstres() {
		return tabMonstres;
	}
	
	public MonstresCommuns getMonstreRandom(int index) {
		return tabMonstres[index];
	}
	
	public void setTabMonstres(MonstresCommuns[] tabMonstres) {
		this.tabMonstres = tabMonstres;
	}
	public MonstresElites[] getTabElites() {
		return tabElites;
	}
	public void setTabElites(MonstresElites[] tabElites) {
		this.tabElites = tabElites;
	}
	
	/*public InterfaceCarte getWindowMap() {
		return windowMap;
	}
	public void setWindowMap(InterfaceCarte windowMap) {
		this.windowMap = windowMap;
	}*/
	public InitPartie getInit() {
		return init;
	}
	public void setInit(InitPartie init) {
		this.init = init;
	}	
	
	public static void main(String[] args) throws SlickException, InterruptedException {
		Game game = new Game();
		game.joueur = new Personnage();
		InterfaceJeu interfJeu = new InterfaceJeu(Constantes.NOM_JEU, game);
		game.setInit(new InitPartie(interfJeu));
		interfJeu.demarrerJeu();
		
	}
}
	
