package main;

import gui.InterfaceIntro;
import gui.InterfaceCarte;
import gui.InterfaceJeu;

import org.newdawn.slick.SlickException;

import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class Game{
	
	final static int NBR_MAX_MONSTRES = 5;
	final static int NBR_MAX_ELITES = 6;
	
	private Personnage joueur;
	private MonstresCommuns tabMonstres[] = new MonstresCommuns[NBR_MAX_MONSTRES];
	private MonstresElites tabElites[] = new MonstresElites[NBR_MAX_ELITES];
	private InterfaceCarte windowMap = new InterfaceCarte();
	private InitPartie init = new InitPartie(windowMap);
	
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
	
	public MonstresCommuns getMonstre(int index) {
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
	
	public InterfaceCarte getWindowMap() {
		return windowMap;
	}
	public void setWindowMap(InterfaceCarte windowMap) {
		this.windowMap = windowMap;
	}
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
		interfJeu.launchMap();
		
	}
}
	
