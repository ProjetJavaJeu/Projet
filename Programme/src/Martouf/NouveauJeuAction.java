package Martouf;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import GUI.FirstInterface;
import GUI.MapInterface;
/*
*Auteur : Martin Schreinemachers & Baptiste Vergote.
*
* La classe NouveauJeuAction contient les m�thodes n�cessaires au lancement d'une nouvelle partie.
*/
public class NouveauJeuAction extends AbstractAction{
	private FirstInterface fenetre;
	
	public NouveauJeuAction(FirstInterface fenetre, String texte){
		super(texte);
		this.fenetre = fenetre; //Avec cette ligne, on cr��e l'objet de type NouveauJeuAction avec pour champ, 
								//l'interface graphique de d�but. Cela permet de pouvoir la fermer ci-dessous avec dispose();
	}							//

	public void actionPerformed(ActionEvent e) { 
		System.out.println("Choix new game");
		fenetre.dispose(); //Ferme la fen�tre d'accueil.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MapInterface Map = new MapInterface();
			}
		});
	} 
	
}
