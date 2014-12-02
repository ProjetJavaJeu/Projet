package gui;

import javax.swing.JFrame;

import PPersonnages.Personnage;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

public class InterfaceCreationPersonnage extends JFrame{
	
	private Personnage perso;
	private JTextField textField;
	
	public InterfaceCreationPersonnage(){
		this.perso = perso;
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblPseudo = new JLabel("Pseudo : ");
		panel.add(lblPseudo);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnGuerrier = new JRadioButton("Guerrier");
		panel_1.add(rdbtnGuerrier);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mage");
		panel_1.add(rdbtnNewRadioButton);
	}

	
}
