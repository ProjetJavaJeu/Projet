package gui;

import javax.swing.JFrame;

import PPersonnages.Personnage;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.Box;

import org.newdawn.slick.SlickException;

import main.Game;

public class InterfaceCreationPersonnage extends JFrame implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3929685799739067735L;
	private Game game;
	private JTextField textField;
	private JLabel messageErreurClasse;
	private JLabel messageErreurPseudo;
	
	public InterfaceCreationPersonnage(Game game){
		this.game = game;
		this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//A retirer ? A voir.
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
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER, 5, 10);
		panel_1.setLayout(fl_panel_1);
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		JRadioButton rdbtnGuerrier = new JRadioButton("Guerrier");
		rdbtnGuerrier.addMouseListener(this);
		verticalBox.add(rdbtnGuerrier);
		
		JRadioButton rdbtnMage = new JRadioButton("Mage");
		rdbtnMage.addMouseListener(this);
		verticalBox.add(rdbtnMage);
		
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.addMouseListener(this);
		verticalBox.add(btnContinuer);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		messageErreurClasse = new JLabel("Veuillez choisir une classe avant de continuer ! ");
		messageErreurClasse.setVisible(false);
		panel_2.add(messageErreurClasse);
		
		messageErreurPseudo = new JLabel("Veuillez entrer un pseudonyme pour continuer ");
		messageErreurPseudo.setVisible(false);
		panel_2.add(messageErreurPseudo);
		
	}

	public void actionValider() throws SlickException {
		String pseudo = textField.getText();
		System.out.println("pseudo = "+ pseudo);
		if (pseudo.equals("")){
			this.messageErreurPseudo.setVisible(true);
		}
		else {
			game.getJoueur().setNom(pseudo);
			this.messageErreurPseudo.setVisible(false);
			
			if ((game.getJoueur().getType() != 'M') | (game.getJoueur().getType() != 'G')){
				this.messageErreurClasse.setVisible(true);
			}
			else {
				this.messageErreurClasse.setVisible(false);
				game.getWindowMap().launchMap(game);
				this.dispose();
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1){
			game.getJoueur().setType('G');
		}
		else if (e.getButton()== 2){
			game.getJoueur().setType('M');
		}
		else if (e.getButton() == 3){
			try {
				actionValider();
			} catch (SlickException e1) {
				e1.printStackTrace();
			}
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
