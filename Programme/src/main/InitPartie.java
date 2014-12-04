package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.InterfaceCreationPersonnage;
import gui.WindowMap;
import JDBC.JDBCAcces;
import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class InitPartie {
	private WindowMap windowMap;

	public InitPartie(WindowMap windowMap) {
		super();
		this.windowMap = windowMap;
	}

	// Passer en paramètre Game.
	public Personnage initPerso(Personnage perso, int choix) throws ClassNotFoundException{
		JDBCAcces acc = new JDBCAcces();
		if (choix == 1){
			InterfaceCreationPersonnage interCreation = new InterfaceCreationPersonnage(perso);
			perso = interCreation.getNouveauPersonnage();
			interCreation.dispose();
		}
		perso = acc.JDBCPersonnage(perso, choix);		
		return perso;
	}
	
	public MonstresCommuns[] initMonstres(MonstresCommuns tabMonstres[]) throws ClassNotFoundException{
		JDBCAcces acc = new JDBCAcces();
		tabMonstres = acc.JDBCMonstres(tabMonstres);
		return tabMonstres;
	}
	
	public void options() {
		System.out.println("Options");
	}

	
	
}
