package PPersonnages;

public class Experience {
		
	static int xp[] = {2, 3, 7, 13, 29, 41, 73, 97, 150, 400};
	private int xpAct;
	private int niveau;
	
	public Experience(int xp, int niveau){
		this.xpAct = xpAct;
		this.niveau = niveau;
	}
	
	/*
	 * get / set lvl up
	 * si xp = 116 -> 116 - 100 (valeur pour lvl up), inc lvl, augmente caract, <== OK !
	 */
	
	public int getXpAct() {
		return xpAct;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setXpAct(int xpAct, int level) {
		if (checkXP(xpAct, level) == 0){
			this.xpAct = xpAct;
		}
	}

	/**
	 * 
	 * @param xpAct
	 * @param xp
	 * @param level
	 * @return level du perso
	 * 
	 * Manque : que faire si le perso est level max, que faire si le perso est lvl 1 ! (va générer un hors tableau !)
	 */
	public int checkXP(int xpAct, int level){
		if (xpAct > xp[level - 1] ){
			setLeveL(xpAct, level);
			return 1;
		}
		return 0;
	}
	
	/**
	 * 
	 * @param xpAct xp actuelle du personnage
	 * @param xp nécessaire pour monter de niveau
	 * @param level actuel
	 * @return return level+1, avec level max = 10
	 */
	public int setLeveL(int xpAct, int level){
		if (level > 10) {
			xpAct = xpAct - xp[level - 1];
			return level+1;
		}
		else
			return 10; //n'ajoute plus de level !
			
	}
}
