package main;

import PPersonnages.Personnage;
import gui.WindowMap;

public class Combat {

	private Player player;
	private Personnage monstre;

	public Combat(Player player, Personnage monstre) {
		this.player = player;
		this.monstre = monstre;
	}

	/**
	 * Gere les coups critiques si Math.random >= 0.85, attaque de 2 ! (== coup
	 * critique) si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 * si Math.random > 0.15 (== coup raté)
	 * 
	 * @return int = puissance de l'attaque
	 */
	public void attaque(Personnage attaquant, Personnage victime) {
		double rand = Math.random();
		if (verifType(attaquant) == 1){
			if (rand >= 0.85){
				
			}
			else if ((rand < 0.85) && (rand >= 0.15)){
				
			}
			else{
				
			}
		}
			
	}
	
	public int verifType(Personnage attaquant){
		if (attaquant.getType() == 'M'){
			return 1;
		}
		else {
			return 2;
		}
	}
	
	public char getPlayerType(){
		return player.getPerso().getType();
	}
	
	public char getMonstreType(){
		return monstre.getType();
	}
}
