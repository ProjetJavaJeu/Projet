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
		MonstresCommuns monstre = new MonstresCommuns("Market'eux", new Caract(1, 1, 4), '1', "Spam, spam, spam, spam, baked beans !", 2);
		MonstresCommuns monstreb = new MonstresCommuns("Compta'eux", new Caract(1, 1, 4), '2', "Victoire ! Je viens d'apercevoir une augmentation !", 2);
		MonstresCommuns monstrec = new MonstresCommuns("E-Business'eux", new Caract(1, 2, 4), '3', "Faut-il dire la vérité aux imbéciles ?", 3);
		MonstresCommuns monstred = new MonstresCommuns("Commercial'eux", new Caract(3, 1, 4), '4', "Je créerais la nécessité là où il n'y en a aucune !", 4);
		MonstresCommuns monstree = new MonstresCommuns("Droiteux", new Caract(3, 1, 4), '5', "Ca reste complexe mais en beaucoup plus simple !", 4);
		tabMonstres[0] = monstre;
		tabMonstres[1] = monstreb;
		tabMonstres[2] = monstrec;
		tabMonstres[3] = monstred;
		tabMonstres[4] = monstree;
		return tabMonstres;
	}
}
