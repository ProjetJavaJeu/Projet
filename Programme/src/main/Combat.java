package main;

import gui.WindowMap;

public class Combat {
	final static double SEUIL_COMBAT = 95; // Si le résultat du random est supérieur à 95, il y a combat.
	private Player one;
	private Player monstre;
	
	public Combat(Player one, Player monstre){
		this.one = one;
		this.monstre = monstre;
	}
	
	/**
	 * A virer?
	 * @return
	 */
	public boolean randomCombat(){		//Provoque des combats aléatoires.
			if ((Math.random() * 100) > SEUIL_COMBAT){
				return true;
			}
			return false;
		}
	
	/**
	 * Gere les coups critiques 
	 *   si Math.random >= 0.85, attaque de 2 ! (== coup critique)
	 *   si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 *   si Math.random > 0.15 (== coup raté)
	 * @return int = puissance de l'attaque
	 */
	public int attaque(){
		double rand = Math.random();
		if ( rand >= 0.85)
			return 2;
		else if ((rand < 0.85) && (rand >= 0.15))
			return 1;
		else
			return 0;
	}	
}
