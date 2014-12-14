package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.InterfaceCreationPersonnage;
import gui.InterfaceCarte;
import gui.InterfaceJeu;
import JDBC.JDBCAcces;
import PPersonnages.Caract;
import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class InitPartie {
	
	private InterfaceJeu interfJeu;
	
	public InitPartie(InterfaceJeu interfJeu) {
		this.interfJeu = interfJeu;
	}

	// Passer en paramètre Game.
	public void initPerso(Game game, int choix) throws ClassNotFoundException{
		JDBCAcces acc = new JDBCAcces();
		if (choix == 1){
			game.setJoueur(acc.JDBCPersonnage(choix));
			interfJeu.enterState(Constantes.CREATION_PERSO);
		}
				
		//Creation perso hardcode pour test
		/*game.getJoueur().setCaracter(new Caract(1, 0, 1));
		game.getJoueur().setNiveau(1);
		game.getJoueur().setPvIntial();
		game.getJoueur().setType('G');*/
	}
	
	public MonstresCommuns[] initMonstres(MonstresCommuns tabMonstres[]) throws ClassNotFoundException{
		JDBCAcces acc = new JDBCAcces();
		tabMonstres = acc.JDBCMonstres(tabMonstres);
		
		/*Caract caract = new Caract(1, 2, 5);
		MonstresCommuns monstre = new MonstresCommuns("Orc", caract, '1', "", 2);
		for (int i = 0; i < 5; i++){
			tabMonstres[i] = monstre;
		}*/
		return tabMonstres;
	}
	
	public void options() {
		System.out.println("Options");
	}

	
	
}
