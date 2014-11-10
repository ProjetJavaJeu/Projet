package Martouf;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import GUI.FirstInterface;

public class NouveauJeuAction extends AbstractAction{
	private FirstInterface fenetre;
	
	public NouveauJeuAction(FirstInterface fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}

	public void actionPerformed(ActionEvent e) { 
		System.out.println("Choix new game");
	} 
	
}
