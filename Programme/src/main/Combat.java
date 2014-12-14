package main;

import PPersonnages.MonstresCommuns;
import PPersonnages.Personnage;

public class Combat {

	private Personnage joueur;
	private MonstresCommuns monstre;
	private Game game;
	private boolean monstreKO; 	//Donne l'etat du monste : en vie ou ko.
	private boolean joueurKO;
	private char etatAttaque;	//Repr�sente l'�tat de l'attaque : Coup critique, rat� ou erreur.
	private int frappe;			//Repr�sente num�riquement la frappe � afficher en informations (voir interfaceCombat).
	
	public Combat(Game game){
		this.game = game;
		this.joueur = game.getJoueur();
		this.monstre = game.getMonstre((int)Math.random());
		frappe = 0;
		monstreKO = false;
		joueurKO = false;
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
	
	public void ajouterExperience(){
		boolean levelUp = game.getJoueur().getExperience().setXpAct(monstre.xpDonnee(), game.getJoueur().getNiveau());
		if (levelUp == true){	//V�rifier limite level max ? if level <= 10 ?
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
	 * si Math.random > 0.15 (== coup rat�)
	 * 
	 * @return int = puissance de l'attaque
	 */
	public MonstresCommuns attaqueSurMonstre(MonstresCommuns victime, Personnage attaquant) {
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
	
	public Personnage attaqueSurPersonnage(Personnage victime, MonstresCommuns attaquant) {
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
