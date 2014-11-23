package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.SlickException;

public class InterfaceCombat extends JFrame {
	
	
	public InterfaceCombat() throws SlickException {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel playerPanel = new JPanel();
		getContentPane().add(playerPanel, BorderLayout.WEST);
		playerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		ImageIcon warrior = new ImageIcon("/src/main/ressources/imagesCombat/warrior.jpeg");
		JLabel playerImage = new JLabel(warrior);
		playerPanel.add(playerImage);

		JPanel enemyPanel = new JPanel();
		getContentPane().add(enemyPanel, BorderLayout.EAST);
		enemyPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel EnemyImage = new JLabel("EnemyImage");
		enemyPanel.add(EnemyImage);

		JPanel actionPanel = new JPanel();
		getContentPane().add(actionPanel, BorderLayout.SOUTH);
		actionPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnAttaque = new JButton("Attaque");

		actionPanel.add(btnAttaque);

		JLabel label = new JLabel("");
		actionPanel.add(label);
	}

	public static void main(String[] args) throws SlickException {
		InterfaceCombat inter = new InterfaceCombat();
		inter.setVisible(true);
		inter.setSize(800, 600);
		inter.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inter.setLocationRelativeTo(null);
	}
}
