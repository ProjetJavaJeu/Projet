package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.WindowMap;
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
		initBDDPersonnage();
	}
	public void options() {
		System.out.println("Options");
	}

	public void initiationBDD(Connection connect, Statement dec) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // IP : 169.254.123.204
			connect = DriverManager.getConnection("jdbc:mysql://localhost:8888/jeujava", "myUser", "essai");
			dec = connect.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	

	public void initBDDPersonnage() throws ClassNotFoundException {
		Connection connect = null;
		Statement dec = null;
		try {
			dec = null;
			initiationBDD(connect, dec);
			String selection = "SELECT idmonstres, nom, carForce, carIntel, carEndu, type, replique, xpDonnee FROM monstres";

			// A ENLEVER :
			System.out.println("The SQL query is: " + selection); 
			System.out.println();
			ResultSet rset = dec.executeQuery(selection);

			System.out.println("The records selected are:");
			int rowCount = 0;
			while (rset.next()) { // Move the cursor to the next row
				int idMonstres = rset.getInt("idmonstres");
				String nom = rset.getString("nom");
				int carForce = rset.getInt("carForce");
				int carIntel = rset.getInt("carIntel");
				int carEndu = rset.getInt("carEndu");
				char type = rset.getString("type").charAt(0);
				String replique = rset.getString("replique");
				int xpDonnee = rset.getInt("xpDonnee");

				System.out.println(idMonstres + ", " + nom 
						+ ", " + carForce + ", " + carIntel + ", " + carEndu
						+ ", " + type + ", " + replique + ", " + xpDonnee);
				++rowCount;
			}
			
			System.out.println("Total number of records = " + rowCount);
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (dec != null)
					dec.close(); // This closes ResultSet too
				if (connect != null)
					connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
}
