package main;

import gui.WindowMap;

public class Combat {
	final static double SEUIL_COMBAT = 95; // Si le r�sultat du random est sup�rieur � 95, il y a combat.
	private Player one;
	private Player monstre;
	
	public Combat(Player one, Player monstre){
		this.one = one;
		this.monstre = monstre;
	}
	
	public boolean randomCombat(){		//Provoque des combats al�atoires.
			if ((Math.random() * 100) > SEUIL_COMBAT){
				return true;
			}
			return false;
		}
	
}
