package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.WindowMap;
import JDBC.JDBCAcces;
import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class InitPartie {
	private WindowMap windowMap;
	private MonstresCommuns tabMonstres[];
	private MonstresElites tabElites[];
	private Personnage perso;
	
	public InitPartie(MonstresCommuns tM[], MonstresElites tE[], Personnage perso){
		//this.windowMap = W;
		this.tabMonstres = tM;
		this.tabElites = tE;
		this.perso = perso;
	}

	public InitPartie(WindowMap windowMap) {
		super();
		this.windowMap = windowMap;
	}


	public void initPartie(int choix) throws ClassNotFoundException{
		JDBCAcces acc = new JDBCAcces();
		acc.JDBCMonstres();
		acc.JDBCPersonnage();		
	}
	
	public void options() {
		System.out.println("Options");
	}

	
	
}
