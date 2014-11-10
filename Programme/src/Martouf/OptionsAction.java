package Martouf;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import GUI.FirstInterface;

public class OptionsAction extends AbstractAction {

private FirstInterface fenetre;
	
	public OptionsAction(FirstInterface fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}

	public void actionPerformed(ActionEvent e) { 
		System.out.println("Options");
	} 
	
}
