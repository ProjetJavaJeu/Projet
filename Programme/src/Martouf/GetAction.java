package Martouf;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import GUI.FirstInterface;

public class GetAction extends AbstractAction {
	private FirstInterface fenetre;
 
	public GetAction(FirstInterface fenetre, String texte){
		super(texte);
 
		this.fenetre = fenetre;
	}
 
	public void actionPerformed(ActionEvent e) { 
		String texteUtilisateur = fenetre.getTextField().getText();
		fenetre.getLabel().setText(texteUtilisateur);
	} 
}