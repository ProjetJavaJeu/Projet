package gui;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import main.Game;
import main.InitPartie;

import org.newdawn.slick.SlickException;

import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InterfaceIntro extends JFrame implements MouseListener {
	

	private static final long serialVersionUID = 1L;
	private int choix = 0;
	private WindowMap windowMap;
	private Game game;
	
	public InterfaceIntro(Game game) {
		this.game = game;
		this.windowMap = game.getWindowMap();
		this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.setBorder(new EmptyBorder(20, 200, 20, 200));

		JButton btnnouvellePartie = new JButton("Nouvelle Partie");
		btnnouvellePartie.addMouseListener(this);
		panel_1.add(btnnouvellePartie);

		JButton btnContinuerPartie = new JButton("Continuer Partie");
		panel_1.add(btnContinuerPartie);

		JButton btnOptions = new JButton("Options");
		panel_1.add(btnOptions);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		choix = e.getButton();
		System.out.println(choix);
		if (choix == 3) {
			game.getInit().options();
		} else {

			try {
				
				game.setTabMonstres(game.getInit().initMonstres(game.getTabMonstres()));	//On remplit le(s) tableau(x) de monstres.
				game.setJoueur(game.getInit().initPerso(game.getJoueur(), choix));		//On cr�e le personnage.

			} catch (ClassNotFoundException e3) {
				e3.printStackTrace();
			}
			try {
				windowMap.launchMap(game);		//On lance l'interface de d�placement.
			} catch (SlickException e1) {

				e1.printStackTrace();
			}
			System.out.println("Ca passe ici");
			this.dispose();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
