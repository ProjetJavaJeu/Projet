package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class Game implements WindowListener{
	final static int NBR_MAX_MONSTRES = 40;
	final static int NBR_MAX_ELITES = 10;
	
	private Personnage player;
	private MonstresCommuns tabMonstres[] = new MonstresCommuns[NBR_MAX_MONSTRES];
	private MonstresElites tabElites[] = new MonstresElites[NBR_MAX_ELITES];
	
	
	public static void main(String[] args) throws SlickException {
		WindowMap windowMap = new WindowMap();
		InterfaceIntro interDebut = new InterfaceIntro(windowMap);
		//interDebut.addWindowListener(this);
		//windowMap.launchMap();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
