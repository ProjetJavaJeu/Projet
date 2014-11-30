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
	public static void main(String[] args) throws SlickException, InterruptedException {
		WindowMap windowMap = new WindowMap();
		
		InterfaceIntro interDebut = new InterfaceIntro(windowMap);
	}	
		
}
	
