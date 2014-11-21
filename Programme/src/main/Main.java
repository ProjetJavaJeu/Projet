package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	private WindowMap windowMap = new WindowMap(); 
	
	public void launchMap() throws SlickException{
	new AppGameContainer(windowMap, 1366, 768, true).start();
		
	}
	
	public static void main(String[] args) throws SlickException {
		Main main = new Main();
		main.launchMap();
	}
}
