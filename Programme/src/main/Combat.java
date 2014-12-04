package main;

import PPersonnages.MonstresCommuns;
import PPersonnages.Personnage;

public class Combat {

	private Personnage joueur;
	private MonstresCommuns monstre;
	private Game game;
	private boolean monstreKO = false;	//Donne l'etat du monste : en vie ou ko.
	private boolean joueurKO = false;
	private char etatAttaque;	//Représente l'état de l'attaque : Coup critique, raté ou erreur.
	private int frappe;			//Représente numériquement la frappe à afficher en informations (voir interfaceCombat).
	
	public Combat(Game game){
		this.game = game;
		this.joueur = game.getJoueur();
		this.monstre = game.getMonstre((int)Math.random());
	}
	
	public int getFrappe(){
		return frappe;
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
	
	public Personnage getMonstre() {
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
	
	public void ajouterExperience(){// ??? Monstre doit changer de type
		boolean levelUp = game.getJoueur().getExperience().setXpAct(monstre.xpDonnee(), game.getJoueur().getNiveau());
		if (levelUp == true){	//Vérifier limite level max ? if level <= 10 ?
			game.getJoueur().setNiveau(game.getJoueur().getNiveau() + 1);
		}
	}
	
	public void setVictimeKO(Personnage victime){
		if (victime.getPv() <= 0){
			victime.setPv(0);
			if (victime.getType() == 'M' | victime.getType() == 'G'){
				joueurKO = true;
			}
			else {
				monstreKO = true;
			}
		}
	}

	/**
	 * Gere les coups critiques si Math.random >= 0.85, attaque de 2 ! (== coup
	 * critique) si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 * si Math.random > 0.15 (== coup raté)
	 * 
	 * @return int = puissance de l'attaque
	 */
	public Personnage attaque(Personnage victime, Personnage attaquant) {
		double rand = Math.random();
			if (rand >= 0.85){
				frappe = attaquant.getCaracter().getForce() * 2;
				victime.setPvDiminution(frappe);
				setVictimeKO(victime);
				etatAttaque = 'C';
				return victime;
			}
			else if ((rand < 0.85) && (rand >= 0.15)){
				frappe = attaquant.getCaracter().getForce();
				victime.setPvDiminution(frappe);
				setVictimeKO(victime);
				etatAttaque = 'N';
				return victime;
			}
			else{
				etatAttaque = 'F';
				
			}
			etatAttaque = 'E';
			return null;
		}

}
