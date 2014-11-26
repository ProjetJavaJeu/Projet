package main;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;

public class InterfaceIntro extends JFrame{
	public InterfaceIntro() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	}
	
}
