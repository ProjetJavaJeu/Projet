package main;

import gui.InterfaceIntro;
import gui.WindowMap;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.newdawn.slick.SlickException;

import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class Game{
	final static int NBR_MAX_MONSTRES = 40;
	final static int NBR_MAX_ELITES = 10;
	
	private Personnage player;
	private MonstresCommuns tabMonstres[] = new MonstresCommuns[NBR_MAX_MONSTRES];
	private MonstresElites tabElites[] = new MonstresElites[NBR_MAX_ELITES];
	
	public static void main(String[] args) throws SlickException, InterruptedException {
		WindowMap windowMap = new WindowMap();
		InterfaceIntro interDebut = new InterfaceIntro(windowMap, tabMonstres, tabElites);
	}	
		
}
	
