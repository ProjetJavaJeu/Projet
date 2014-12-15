package be.ephec.main;

import be.ephec.tesa.personnages.MonstresCommuns;
import be.ephec.tesa.personnages.Personnage;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */

public class Combat {
	/**
	 * Personnage joueur, monstre : sont les objets qui représentent les deux adversaires dans un combat.
	 * boolean monstreKO, joueurKO : sont des variables booléennes qui représentent l'état de combattre des deux opposants.
	 * char etatAttaque : contient un caractère représentant le type d'attaque effectué (Coup critique, coup normal, coup manqué). 
	 * int frappePersonnage, frappeMonstre : contiennent la valeur entière de la dernière frappe effectuée par le monstre et le joueur.
	 */
	
	private Personnage joueur;
	private MonstresCommuns monstre;
	private Game game;
	private boolean monstreKO;
	private boolean joueurKO;
	private char etatAttaque;
	private int frappePersonnage;
	private int frappeMonstre;
	
	/**
	 * 
	 * @param game est la variable qui contient le joueur et un tableau de monstres, nécessaires à l'initialisation du combat.
	 */
	public Combat(Game game){
		this.game = game;
		this.joueur = game.getJoueur();
		this.monstre = game.getMonstreRandom((int)Math.random());
		frappePersonnage = 0;
		frappeMonstre = 0;
		monstreKO = false;
		joueurKO = false;
	}
	
	public int getFrappePersonnage() {
		return frappePersonnage;
	}

	public void setFrappePersonnage(int frappePersonnage) {
		this.frappePersonnage = frappePersonnage;
	}

	public int getFrappeMonstre() {
		return frappeMonstre;
	}

	public void setFrappeMonstre(int frappeMonstre) {
		this.frappeMonstre = frappeMonstre;
	}
	
	public Personnage getJoueur() {
		return joueur;
	}

	public void setJoueur(Personnage joueur){
		this.joueur = joueur;
	}
	
	public void setMonstre(MonstresCommuns monstre){
		this.monstre = monstre;
	}
	
	public MonstresCommuns getMonstre() {
		return monstre;
	}

	public boolean getMonstreKO(){
		return monstreKO;
	}
	
	public boolean getJoueurKO(){
		return joueurKO;
	}
	
	public char getEtatAttaque() {
		return etatAttaque;
	}	
	
	/**
	 * @post Modifie l'expérience du joueur et son niveau, si celui-ci a atteint le cap d'expérience nécessaire.
	 */
	public void ajouterExperience(){
		boolean levelUp = game.getJoueur().getExperience().setXpAct(monstre.xpDonnee(), game.getJoueur().getNiveau());
		if (levelUp == true){						//Vérifier limite level max ? if level <= 10 ?
			game.getJoueur().setNiveau(game.getJoueur().getNiveau() + 1);
		}
	}
	
	/**
	 * 
	 * @param victime est une variable de type personne contenant la victime de l'attaque en cours d'execution.
	 * @post Met la valeur true pour la variable joueurKO / monstreKO si la vie de la victime est égale à zéro.
	 */
	public void setVictimeKO(Personnage victime){
		if (victime.getPv() == 0){
			if (victime.getType() == 'M' | victime.getType() == 'G'){
				joueurKO = true;
			}
			else {
				monstreKO = true;
			}
		}
	}

	/**
	 * 
	 * @return la force de frappe de l'attaquant pour la prochaine attaque.
	 */
	public int typeAttaque(){
		if (joueur.getType() == 'G'){
			return joueur.getCaracter().getForce();
			}
		else 
			return joueur.getCaracter().getIntelligence();
	}
	
	/**
	 * Effectue l'attaque du joueur sur le monstre.
	 * Gere les coups critiques si Math.random >= 0.85, attaque de 2 ! (== coup
	 * critique) si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 * si Math.random > 0.15 (== coup raté)
	 * 
	 * @return la variable contenant le monstre.
	 */
	public MonstresCommuns attaqueSurMonstre() {
		double rand = Math.random();
			if (rand >= 0.85){
				frappeMonstre = typeAttaque() * 2;
				monstre.setDiminutionPV(frappePersonnage);
				setVictimeKO(monstre);
				etatAttaque = 'C';
				return monstre;
			}
			else if ((rand < 0.85) & (rand >= 0.15)){
				frappePersonnage = typeAttaque() * 2;
				monstre.setDiminutionPV(frappePersonnage);
				setVictimeKO(monstre);
				etatAttaque = 'N';
				return monstre;
			}
			else{
				etatAttaque = 'F';
				frappePersonnage = 0;
				return monstre;
			}
		}
	
	/**
	 * 
	 * Idem que attaqueSurMonstre() mais pour l'attaque du monstre sur le joueur.
	 * @return la variable contenant le joueur.
	 */
	public Personnage attaqueSurPersonnage() {
		double rand = Math.random();
			if (rand >= 0.85){
				frappeMonstre = monstre.getCaracter().getForce() * 2;
				joueur.setDiminutionPV(frappeMonstre);
				setVictimeKO(joueur);
				etatAttaque = 'C';
				return joueur;
			}
			else if ((rand < 0.85) && (rand >= 0.15)){
				frappeMonstre = monstre.getCaracter().getForce();
				joueur.setDiminutionPV(frappeMonstre);
				setVictimeKO(joueur);
				etatAttaque = 'N';
				return joueur;
			}
			else{
				etatAttaque = 'F';
				frappeMonstre = 0;
				return joueur;
			}
		}

}
