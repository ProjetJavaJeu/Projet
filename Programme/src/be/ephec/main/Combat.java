package be.ephec.main;

import be.ephec.tesa.personnages.MonstresCommuns;
import be.ephec.tesa.personnages.Personnage;

public class Combat {

	private Personnage joueur;
	private MonstresCommuns monstre;
	private Game game;
	private boolean monstreKO; 	//Donne l'etat du monste : en vie ou ko.
	private boolean joueurKO;
	private char etatAttaque;	//Repr�sente l'�tat de l'attaque : Coup critique, rat� ou erreur.
	private int frappePersonnage;	//Repr�sente num�riquement la frappe � afficher en informations (voir interfaceCombat).
	private int frappeMonstre;
	
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
	
	public void ajouterExperience(){
		boolean levelUp = game.getJoueur().getExperience().setXpAct(monstre.xpDonnee(), game.getJoueur().getNiveau());
		if (levelUp == true){						//V�rifier limite level max ? if level <= 10 ?
			game.getJoueur().setNiveau(game.getJoueur().getNiveau() + 1);
		}
	}
	
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
	 * Gere les coups critiques si Math.random >= 0.85, attaque de 2 ! (== coup
	 * critique) si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 * si Math.random > 0.15 (== coup rat�)
	 * 
	 * @return int = puissance de l'attaque
	 */
	public MonstresCommuns attaqueSurMonstre() {
		double rand = Math.random();
			if (rand >= 0.85){
				frappePersonnage = joueur.getCaracter().getForce() * 2;
				monstre.setDiminutionPV(frappePersonnage);
				setVictimeKO(monstre);
				etatAttaque = 'C';
				return monstre;
			}
			else if ((rand < 0.85) & (rand >= 0.15)){
				frappePersonnage = joueur.getCaracter().getForce();
				monstre.setDiminutionPV(frappePersonnage);
				setVictimeKO(monstre);
				etatAttaque = 'N';
				return monstre;
			}
			else{
				etatAttaque = 'F';
				return monstre;
			}
		}
	
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
				return joueur;
			}
		}

}
