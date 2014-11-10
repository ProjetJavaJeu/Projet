package Martouf;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import GUI.FirstInterface;

public class ContinueAction extends AbstractAction {

private FirstInterface fenetre;
	
	public ContinueAction(FirstInterface fenetre, String texte){
		super(texte);
		this.fenetre = fenetre;
	}

	public void actionPerformed(ActionEvent e) { 
		System.out.println("Continue");
	} 
	
}
