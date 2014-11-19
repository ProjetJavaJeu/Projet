package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	private WindowGame windowMap = new WindowGame();
	
	public void launchMap() throws SlickException{
		new AppGameContainer(windowMap, 1360, 768, false).start();
	}
	
	public static void main(String[] args) throws SlickException {
		Main main = new Main();
		main.launchMap();
	}
}
