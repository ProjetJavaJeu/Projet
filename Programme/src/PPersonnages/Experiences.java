package PPersonnages;
//////////////////////////////////////FINIII	//////////////////////////////////////////////////
public class Experiences {
	// les niveaux restent 
	// A METTRE dans la BDD !!
	static int xp[] = {2, 3, 7, 13, 29, 41, 73, 97, 150, 400};

	/*
	 * get / set lvl up
	 * si xp = 116 -> 116 - 100 (valeur pour lvl up), inc lvl, augmente caract, <== OK !
	 */
	
	/**
	 * 
	 * @param xpAct
	 * @param xp
	 * @param level
	 * @return level du perso
	 * 
	 * 
	 * Manque : que faire si le perso est level max, que faire si le perso est lvl 1 ! (va générer un hors tableau !)
	 */
	public void checkXP(int xpAct, int level){
		if (xpAct > xp[level - 1] ){
			setLeveL(xpAct, xp[level-1], level);
		}
	}
	
	/**
	 * 
	 * @param xpAct xp actuelle du personnage
	 * @param xp nécessaire pour monter de niveau
	 * @param level actuel
	 * @return return level+1, avec level max = 10
	 */
	public int setLeveL(int xpAct, int xpMoins, int level){
		if (level > 10) {
			xpAct = xpAct - xpMoins;
			return level+1;
		}
		else
			return 10; //n'ajoute plus de level !
			
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
