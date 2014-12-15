package be.ephec.main;

import be.ephec.tesa.gui.InterfaceJeu;
import be.ephec.tesa.jdbc.JDBCAcces;
import be.ephec.tesa.personnages.Caract;
import be.ephec.tesa.personnages.MonstresCommuns;

/**
 * @author Baptiste Vergote & Martin Schreinemachers
 * @Class 2TL2
 * 
 */

public class InitPartie {

	public InitPartie(InterfaceJeu interfJeu) {

	}

	/**
	 * 
	 * @param game la variable contenant les structures à remplir, ici le Personnage joueur.
	 * @param choix une variable entière qui contient le choix de l'utilisateur quand à faire une nouvelle partie ou continuer.
	 * @throws ClassNotFoundException 
	 */
	public void initPerso(Game game, int choix) throws ClassNotFoundException {
		//JDBCAcces acc = new JDBCAcces();
		if (choix == Constantes.CREATION_PERSO) {
			//game.setJoueur(acc.JDBCPersonnage(choix));
			//Creation perso hardcode pour test
			game.getJoueur().setCaracter(new Caract(5, 5, 1));
			game.getJoueur().setNiveau(1);
			game.getJoueur().setPvIntial();
			game.getJoueur().setType('G');
		}
	}

	/**
	 * 
	 * @param tabMonstres la variable destinée à contenir les monstres du jeu.
	 * @return la variable tabMonstres qui contient cinq monstres.
	 * @throws ClassNotFoundException
	 */
	public MonstresCommuns[] initMonstres(MonstresCommuns tabMonstres[])
			throws ClassNotFoundException {
		//JDBCAcces acc = new JDBCAcces();
		//tabMonstres = acc.JDBCMonstres(tabMonstres);
		Caract caract = new Caract(1, 2, 5);
		MonstresCommuns monstre = new MonstresCommuns("Droit'eux", caract, '1', "Spam, spam, spam, spam, baked beans !", 2);
		for (int i = 0; i < 5; i++){
			tabMonstres[i] = monstre;
		}
		return tabMonstres;
	}
}
