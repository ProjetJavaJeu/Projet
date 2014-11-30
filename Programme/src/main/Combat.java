package main;

import gui.WindowMap;

public class Combat {

	private Player one;
	private Player monstre;

	public Combat(Player one, Player monstre) {
		this.one = one;
		this.monstre = monstre;
	}

	/**
	 * Gere les coups critiques si Math.random >= 0.85, attaque de 2 ! (== coup
	 * critique) si Math.random < 0.85 ET Math.random >= 0.15 (== coup normal)
	 * si Math.random > 0.15 (== coup raté)
	 * 
	 * @return int = puissance de l'attaque
	 */
	public int attaque() {
		double rand = Math.random();
		if (rand >= 0.85)
			return 2;
		else if ((rand < 0.85) && (rand >= 0.15))
			return 1;
		else
			return 0;
	}
}
