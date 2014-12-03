package main;

import javax.swing.text.StyledEditorKit.StyledTextAction;

import PPersonnages.Personnage;
import gui.WindowMap;

public class Combat {

	private Personnage joueur;
	private Personnage monstre;
	private Game game;
	private boolean monstreKO = false;	//Donne l'etat du monste : en vie ou ko.
	private boolean joueurKO = false;
	private char etatAttaque;	//Représente l'état de l'attaque : Coup critique, raté ou erreur.
	
	public Combat(Game game){
		this.game = game;
		this.joueur = game.getJoueur();
		this.monstre = game.getMonstre((int)Math.random());
	}
	
	public Personnage getJoueur() {
		return joueur;
	}

	public void setJoueur(Personnage joueur){
		this.joueur = joueur;
	}
	
	public void setMonstre(Personnage monstre){
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
		game.getJoueur().getExperience().setXpAct(monstre.), game.getJoueur().get);
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
				victime.setPvDiminution(attaquant.getCaracter().getForce() * 2);
				setVictimeKO(victime);
				etatAttaque = 'C';
				return victime;
			}
			else if ((rand < 0.85) && (rand >= 0.15)){
				victime.setPvDiminution(attaquant.getCaracter().getForce() * 2);
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
