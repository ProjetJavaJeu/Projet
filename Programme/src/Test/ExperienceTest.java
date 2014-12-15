package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import be.ephec.tesa.personnages.Experience;

public class ExperienceTest {
	Experience exp = new Experience();
	static int xp[] = {2, 3, 7, 13, 29, 41, 73, 97, 150, 400};

	@Test
	public void testSetXpAct() {
		assertEquals(exp.setXpAct(1000,10),false );
		// Si lvl = 10, ajouter de l'xp ne fait rien !
		assertEquals(exp.setXpAct(4,1), true);
		// Si lvl 1, 4 xp le fera monter de level
		assertEquals(exp.setXpAct(2, 3), false);
		// Si lvl 3, ajouter 2 xp ne le fera pas lvl up
	}

	@Test
	public void testCheckXP() {
		//public int checkXP(int xpAct, int level)
		assertEquals(exp.checkXP(15, 4),1);
		assertEquals(exp.checkXP(1, 1), 0);
	}

}
