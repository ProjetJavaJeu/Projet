package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;

import main.Player;

import org.newdawn.slick.SlickException;

import PPersonnages.Personnage;

public class InterfaceCombat extends JFrame {
	
	private static final long serialVersionUID = 2L;

	public InterfaceCombat(Player one, Player monster) throws SlickException {
		
		//getContentPane().setBackground(Color.black);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//Panel Joueur
		JPanel playerPanel = new JPanel();
		getContentPane().add(playerPanel, BorderLayout.WEST);
		playerPanel.setLayout(new BorderLayout(0, 0));
		//playerPanel.setBackground(Color.black);
		JLabel playerLabel = new JLabel();
		//Chemin avec Slick mettre un slash pour commencer. Avec Swing PAS !
		if (one.getPerso().getType() == 'G'){
			playerLabel.setIcon(new ImageIcon("ressources/imagesCombat/warrior.jpg"));
		}
		else 
			playerLabel.setIcon(new ImageIcon("ressources/imagesCombat/mage2.jpg"));
		playerPanel.add(playerLabel);
		playerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				
		//Panel monstre
		JPanel enemyPanel= new JPanel();
		getContentPane().add(enemyPanel, BorderLayout.EAST);
		enemyPanel.setLayout(new BorderLayout(0, 0));
		//enemyPanel.setBackground(Color.black);
		JLabel enemyLabel = new JLabel();
		if (monster.getPerso().getType() == '1'){
			enemyLabel.setIcon(new ImageIcon("ressources/imagesCombat/orc2.jpg"));
		}
		else if (monster.getPerso().getType() == '2'){
			enemyLabel.setIcon(new ImageIcon("ressources/imagesCombat/murloc.jpg"));
		}
		enemyPanel.add(enemyLabel);
		
		//Panel avec le bouton d'attaque et le champ d'info.
		JPanel actionPanel = new JPanel();
		getContentPane().add(actionPanel, BorderLayout.SOUTH);
		JButton btnAttaque = new JButton("Attaque");
		actionPanel.add(btnAttaque);
		JLabel label = new JLabel("Zone de texte d'informations");
		actionPanel.add(label);
	}

	public static void main(String[] args) throws SlickException {
		Map map = new Map();
		Player one = new Player(map, 200, 200);
		one.getPerso().setType('M');
		Player monster = new Player(map, 200, 200);
		monster.getPerso().setType('2');
		InterfaceCombat inter = new InterfaceCombat(one, monster);
		inter.setVisible(true);
		inter.setSize(800, 600);
		inter.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inter.setLocationRelativeTo(null);
	}
}
