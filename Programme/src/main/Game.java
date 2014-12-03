package main;

import gui.InterfaceCombat;
import gui.InterfaceIntro;
import gui.WindowMap;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
	private WindowMap windowMap = new WindowMap();
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
	
	public WindowMap getWindowMap() {
		return windowMap;
	}
	public void setWindowMap(WindowMap windowMap) {
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
		InterfaceIntro interDebut = new InterfaceIntro(game);	
	}
}
	
