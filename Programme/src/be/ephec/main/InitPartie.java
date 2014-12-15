package be.ephec.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import be.ephec.tesa.gui.InterfaceCarte;
import be.ephec.tesa.gui.InterfaceCreationPersonnage;
import be.ephec.tesa.gui.InterfaceJeu;
import be.ephec.tesa.jdbc.JDBCAcces;
import be.ephec.tesa.personnages.Caract;
import be.ephec.tesa.personnages.MonstresCommuns;
import be.ephec.tesa.personnages.MonstresElites;
import be.ephec.tesa.personnages.Personnage;

public class InitPartie {
	
	private InterfaceJeu interfJeu;
	
	public InitPartie(InterfaceJeu interfJeu) {
		this.interfJeu = interfJeu;
	}

	// Passer en paramètre Game.
	public void initPerso(Game game, int choix) throws ClassNotFoundException{
		//JDBCAcces acc = new JDBCAcces();
		if (choix == Constantes.CREATION_PERSO){
			//game.setJoueur(acc.JDBCPersonnage(choix));
			//Creation perso hardcode pour test
			game.getJoueur().setCaracter(new Caract(1, 0, 1));
			game.getJoueur().setNiveau(1);
			game.getJoueur().setPvIntial();
			game.getJoueur().setType('G');
		}
				
		
		
	}
	
	public MonstresCommuns[] initMonstres(MonstresCommuns tabMonstres[]) throws ClassNotFoundException{
		//JDBCAcces acc = new JDBCAcces();
		//tabMonstres = acc.JDBCMonstres(tabMonstres);
		
		Caract caract = new Caract(1, 2, 5);
		MonstresCommuns monstre = new MonstresCommuns("Orc", caract, '1', "C'est moi l'orc, grrr !", 2);
		for (int i = 0; i < 5; i++){
			tabMonstres[i] = monstre;
		}
		return tabMonstres;
	}
	
	public void options() {
		System.out.println("Options");
	}

	
	
}
