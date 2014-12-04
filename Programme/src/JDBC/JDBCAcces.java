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

public class JDBCAcces {

	public Statement initiationBDD(Connection connect, Statement dec)
			throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // IP : 169.254.123.204
			connect = DriverManager.getConnection(
					"jdbc:mysql://169.254.123.204:8888/jeujava", "myUser",
					"essai");
			dec = connect.createStatement();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return dec;
	}

	public Personnage JDBCPersonnage(Personnage perso, int choix)
			throws ClassNotFoundException {
		Connection connect = null;
		Statement dec = null;
		Caract caracter = new Caract();
		try {
			dec = initiationBDD(connect, dec);
			String selection = "SELECT idmonstres, nom, carForce, carIntel, carEndu, type, replique, xpDonnee FROM monstres";

			// A ENLEVER :
			System.out.println("The SQL query is: " + selection);
			System.out.println();
			ResultSet rset = dec.executeQuery(selection);

			System.out.println("The records selected are:");
			// execution de la requete qui renvoie un objet de type ResultSet
			int rowCount = 0;

			while (rset.next()) {
				perso.setType(rset.getString("type").charAt(0));
				int id = rset.getInt("id"); // Stock dans un int + typecast(getInt)
				String nom = rset.getString("Nom");
				if (choix == 2){
					perso.setNom(nom);
				}
				String typePersonnage = rset.getString("typePersonnage");
				caracter.setForce(rset.getInt("carForce"));
				caracter.setIntelligence(rset.getInt("carIntel"));
				caracter.setEndurance(rset.getInt("carEndu"));
				perso.setCaracter(caracter);
				int pv = rset.getInt("pv");
				int xp = rset.getInt("xp");
				perso.setPvIntial();
				int niveau = rset.getInt("niveau");
				perso.getExperience().setXpAct(xp, niveau);
				perso.setNiveau(niveau);
				int mana = rset.getInt("mana");

				rowCount++;
			}

			System.out.println("Total number of records = " + rowCount);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (dec != null)
					dec.close();
				if (connect != null)
					connect.close(); // Ferme la connexion
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return perso;
	}

	/**
	 * 
	 * @throws ClassNotFoundException
	 */
	public MonstresCommuns[] JDBCMonstres(MonstresCommuns tabMonstres[])
			throws ClassNotFoundException {
		Connection connect = null;
		Statement dec = null;
		MonstresCommuns monstre = new MonstresCommuns();
		Caract caracteristique = new Caract();
		try {

			dec = initiationBDD(connect, dec);
			String selection = "SELECT idmonstres, nom, carForce, carIntel, carEndu, type, replique, xpDonnee FROM monstres";

			// A ENLEVER :
			System.out.println("The SQL query is: " + selection);
			System.out.println();
			ResultSet rset = dec.executeQuery(selection);

			System.out.println("The records selected are:");
			int rowCount = 0;
			while (rset.next()) {
				monstre.setNom(rset.getString("nom"));
				caracteristique.setForce(rset.getInt("carForce"));
				caracteristique.setIntelligence(rset.getInt("carIntel"));
				caracteristique.setEndurance(rset.getInt("carEndu"));
				monstre.setType(rset.getString("type").charAt(0));

				monstre.setRepliqueMonstres(rset.getString("replique"));
				monstre.setXpDonnee(rset.getInt("xpDonnee"));

				tabMonstres[rowCount] = monstre;
				System.out.println("nom = " + tabMonstres[rowCount].getNom());

				/*
				 * System.out.println(id + ", " + nom + ", " + typePersonnage +
				 * ", " + carForce + ", " + carIntel + ", " + carEndu + ", " +
				 * type + ", " + pv + ", " + xp + ", " + niveau + ", " + mana);
				 */
				rowCount++;
			}
			System.out.println("Total number of records = " + rowCount);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (dec != null)
					dec.close();
				if (connect != null)
					connect.close(); // Ferme la connexion
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return tabMonstres;
	}
}