package JDBC;

import java.sql.*; // Use classes in java.sql package

import PPersonnages.Caract;
import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

/**
 * 
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * @version 1.0
 *
 */


public class JDBCLocalTest { // Save as JdbcSelectTest.java
	private MonstresCommuns tabMonstres[];
	private MonstresElites tabElites[];
	private Personnage perso;
	
	
	public static void JDBCPersonnage() throws ClassNotFoundException{
		
		Connection connect = null;
		Statement dec = null;
		try {

			Class.forName("com.mysql.jdbc.Driver"); // Driver
			connect = DriverManager.getConnection("jdbc:mysql://localhost:8888/jeujava","essaihome", "essai"); // Information de connection

			dec = connect.createStatement(); // Connection

			String strSelect = "SELECT  id, nom, typePersonnage, carForce, carIntel, carEndu, type, pv, xp, niveau, mana FROM personnages";
			System.out.println("The SQL query is: " + strSelect);
			System.out.println();

			// execution de la requete qui renvoie un objet de type ResultSet
			ResultSet rset = dec.executeQuery(strSelect);

			System.out.println("The records selected are:");
			int rowCount = 0;
		
			while (rset.next()) {
				    char type = rset.getString("type").charAt(0);
					int id = rset.getInt("id"); //Stock dans un int + typecast
					String nom = rset.getString("Nom");
					String typePersonnage = rset.getString("typePersonnage");
					int carForce = rset.getInt("carForce");
					int carIntel = rset.getInt("carIntel");
					int carEndu = rset.getInt("carEndu");
					int pv = rset.getInt("pv");
					int xp = rset.getInt("xp");
					int niveau = rset.getInt("niveau");
					int mana = rset.getInt("mana");

					//A supprimer !
				System.out.println(id + ", " + nom + ", " + typePersonnage
						+ ", " + carForce + ", " + carIntel + ", " + carEndu
						+ ", " + type + ", " + pv + ", " + xp + ", " + niveau
						+ ", " + mana);
				++rowCount;
			}
			
						
				
			
			System.out.println("Total number of records = " + rowCount);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (dec != null)
					dec.close();
				if (connect != null)
					connect.close(); //Ferme la connexion
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void JDBCMonstres() throws ClassNotFoundException{
		Connection connect = null;
		Statement dec = null;
		try {

			Class.forName("com.mysql.jdbc.Driver"); // Driver
			connect = DriverManager.getConnection("jdbc:mysql://localhost:8888/jeujava","essaihome", "essai"); // Information de connection
							  // A changer par ->("jdbc:mysql://169.254.123.204:8888/jeujava", "Mart_Lap", "essai");

			dec = connect.createStatement(); // Connection
			System.out.println();
			System.out.println();
			System.out.println("TIENS LES MONSTRES BEMH KEBRAHH"); // A delete ofc :D
			String strSelect = "SELECT idMonstres, nom, carForce, carIntel, carEndu, type, replique, xpDonnee FROM monstres";
			System.out.println("The SQL query is: " + strSelect);
			System.out.println();

			// execution de la requete qui renvoie un objet de type ResultSet
			ResultSet rset = dec.executeQuery(strSelect);

			System.out.println("The records selected are:");
			int rowCount = 0;
			MonstresCommuns[] ME = new MonstresCommuns[20];
			// for (rowCount = 0; rset.next()  OU rowCount < 5; rowcount++)
			while (rset.next()) {
				//int idMonstres = rset.getInt("idMonstres"); //Stock dans un int + typecast
				String nom = rset.getString("nom");
				int carForce = rset.getInt("carForce");
				int carIntel = rset.getInt("carIntel");
				int carEndu = rset.getInt("carEndu");
				char type = rset.getString("type").charAt(0);
				String replique = rset.getString("replique");
				int xpDonnee = rset.getInt("xpDonnee");
				Caract car = new Caract(carForce, carIntel, carEndu);
				MonstresCommuns i = new MonstresCommuns(nom, car, type, replique, xpDonnee);
				ME[rowCount] = i;

				/*System.out.println(idMonstres + ", " + nom + ", "
						+ carForce + ", " + carIntel + ", " + carEndu
						+ ", " + type + ", " + replique + ", " + xpDonnee); */
				System.out.println();
				System.out.println("Ici");
				System.out.println("Ici2 = " + ME[rowCount].getNom());
				System.out.println();
				++rowCount;
			}
			System.out.println("Total number of records = " + rowCount);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (dec != null)
					dec.close();
				if (connect != null)
					connect.close(); //Ferme la connexion
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		try {
			JDBCPersonnage();
			JDBCMonstres();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}