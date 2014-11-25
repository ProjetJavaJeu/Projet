package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import org.newdawn.slick.SlickException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;

public class InterfaceCombat extends JFrame {
	
	private static final long serialVersionUID = 2L;

	public InterfaceCombat() throws SlickException {
		//getContentPane().setBackground(Color.black);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel playerPanel = new JPanel();
		getContentPane().add(playerPanel, BorderLayout.WEST);
		playerPanel.setLayout(new BorderLayout(0, 0));
		//playerPanel.setBackground(Color.black);
		JLabel playerLabel = new JLabel();
		//Chemin avec Slick mettre un slash pour commencer. Avec Swing PAS !
		playerLabel.setIcon(new ImageIcon("src/main/ressources/imagesCombat/warrior.jpg"));
		playerPanel.add(playerLabel);
		
		JPanel enemyPanel= new JPanel();
		getContentPane().add(enemyPanel, BorderLayout.EAST);
		enemyPanel.setLayout(new BorderLayout(0, 0));
		//enemyPanel.setBackground(Color.black);
		JLabel enemyLabel = new JLabel();
		enemyLabel.setIcon(new ImageIcon("src/main/ressources/imagesCombat/orc.jpg"));
		enemyPanel.add(enemyLabel);
		
		JPanel actionPanel = new JPanel();
		getContentPane().add(actionPanel, BorderLayout.SOUTH);
		
		JButton btnAttaque = new JButton("Attaque");
		actionPanel.add(btnAttaque);
		
		JLabel label = new JLabel("                       ");
		actionPanel.add(label);
	}

	public static void main(String[] args) throws SlickException {
		
		  String path = System.getProperty("user.dir");
		  System.out.println(path);
		 
		InterfaceCombat inter = new InterfaceCombat();
		inter.setVisible(true);
		inter.setSize(800, 600);
		inter.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inter.setLocationRelativeTo(null);
	}
}
