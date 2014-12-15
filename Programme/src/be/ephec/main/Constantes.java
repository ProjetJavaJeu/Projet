package be.ephec.main;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */

/**
 * 
 * Contient toutes les constantes nécessaires à l'éxécution du programme.
 *
 */
public class Constantes {
	
	final static int NBR_MAX_MONSTRES = 5;
	final static int NBR_MAX_ELITES = 6;
	public final static int NOUV_JEU  = 1;
	public final static int CREATION_PERSO = 2; //Valeur d'état de jeu pour passer à l'interface de création de perso.
	public final static int CONT_JEU = 3;
	public final static int OPTIONS_JEU = 4;
	public final static int CARTE_JEU = 5; //Valeur d'état de jeu pouyr passer  à la carte.
	public final static int COMBAT = 6;
	public final static int GAME_OVER = 7;
	public final static String NOM_JEU = "The Epic School Adventure";
	public final static float LARGEUR_BOUTON = 150;
	public final static float HAUTEUR_BOUTON = 35;
	public final static int MARGE_IMAGE = 80;
	public final static String NOUV_PARTIE = "Nouvelle Partie";
	public final static String CONT_PARTIE = "Continuer";
	public final static String OPTIONS = "Options";
	public final static String IMAGE_INTRO = "/ressources/map/ecranDebut.jpg";
	public final static String IMAGE_CREATION_PERSO = "/ressources/map/ecranCreationPersonnage.jpg";
	public final static String PATH_GUERRIER = "ressources/imagesCombat/warrior.jpg";
	public final static String PATH_MAGE = "ressources/imagesCombat/mage2.jpg";
	public final static String PATH_COMPTABLE = "/ressources/imagesCombat/DroiteuxOK.jpg";
	public final static String PATH_MURLOC = "ressources/imagesCombat/murloc.jpg";
	public final static String PATH_IMAGEFOND = "ressources/map/bg.png";
	public final static String CRITIQUE = " Coup Critique !!";
	public final static String FAIL = "Raté !";
	public final static String VICTOIRE = "VICTOIRE";
	public final static String DEFAITE = "DEFAITE";
}
