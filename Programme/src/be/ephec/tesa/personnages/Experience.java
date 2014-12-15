package be.ephec.tesa.personnages;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */
public class Experience {
		
	static int xp[] = {2, 3, 7, 13, 29, 41, 73, 97, 150, 400};
	private int xpAct;
	
	public Experience(int xp){
		this.xpAct = xp;	
	}
	
	public Experience(){
		
	}
	public int getXpAct() {
		return xpAct;
	}
	
	/*
	 * get / set lvl up
	 * si xp = 116 -> 116 - 100 (valeur pour lvl up), inc lvl, augmente caract, <== OK !
	 */
	public boolean setXpAct(int xpAct, int level) {
		if (level == 10){
			System.out.println("Level max atteint");
			return false;
		}
		else if (checkXP(xpAct, level) == 0){
			this.xpAct = xpAct;
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * 
	 * @param xpAct
	 * @param xp
	 * @param level
	 * @return level du perso
	 * 
	 */
	public int checkXP(int xpAct, int level){
		if (xpAct > xp[level - 1] ){
			return 1;
		}
		return 0;
	}
	
}
