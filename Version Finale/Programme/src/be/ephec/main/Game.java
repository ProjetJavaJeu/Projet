package be.ephec.main;

import org.newdawn.slick.SlickException;

import be.ephec.tesa.gui.InterfaceCarte;
import be.ephec.tesa.gui.InterfaceJeu;
import be.ephec.tesa.personnages.MonstresCommuns;
import be.ephec.tesa.personnages.MonstresElites;
import be.ephec.tesa.personnages.Personnage;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 * Game est la classe principale de notre programme. C'est elle qui contient les tableaux de monstres, le joueur et l'InitPartie qui permettra 
 * de remplir les variables cit�es pr�c�demment.
 */

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
	
	/**
	 * Cette classe permet de sl��ctionner un monstre parmi tout ceux stock�s dans le tableau.
	 * @param index un entier qui repr�sente l'index utilis� pour s�l�ctionner un �l�ment dans le tableau tabMonstres.
	 * @return la valeur du monstre de type MonstresCommuns compris � l'indice "index" de tabMonstres.
	 */
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
	
	public InitPartie getInit() {
		return init;
	}
	public void setInit(InitPartie init) {
		this.init = init;
	}	
	
	/**
	 * 
	 * @throws SlickException g�re les potentielles exceptions d�es aux classes des librairies Slick2D.
	 * @throws InterruptedException permet de g�rer les interruptions.
	 * 
	 * interfJeu est un objet de type StateBasedGame, qui contient tout les "�tats" (interfaces ) du jeu. L'introduction, la
	 * cr�ation de personnage, le d�placement sur la carte,...
	 * 
	 * La m�thode demarrerJeu() permet v�ritablement d'ouvrir une fen�tre et de lancer le jeu.
	 */
	public static void main(String[] args) throws SlickException, InterruptedException {
		Game game = new Game();
		game.joueur = new Personnage();
		InterfaceJeu interfJeu = new InterfaceJeu(Constantes.NOM_JEU, game);
		game.setInit(new InitPartie(interfJeu));
		interfJeu.demarrerJeu();
		
	}
}
	
