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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Box;

public class InterfaceCreationPersonnage extends JFrame implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3929685799739067735L;
	private Personnage perso;
	private JTextField textField;
	private JLabel messageErreurClasse;
	private JLabel messageErreurPseudo;
	
	public InterfaceCreationPersonnage(Personnage perso){
		this.perso = perso;
		this.setVisible(true);
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
		rdbtnGuerrier.addActionListener(this);
		verticalBox.add(rdbtnGuerrier);
		
		JRadioButton rdbtnMage = new JRadioButton("Mage");
		rdbtnMage.addActionListener(this);
		verticalBox.add(rdbtnMage);
		
		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.addActionListener(this);
		verticalBox.add(btnContinuer);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		messageErreurClasse = new JLabel("Veuillez choisir une classe avant de continuer ! ");
		messageErreurClasse.setVisible(false);
		panel_2.add(messageErreurClasse);
		
		messageErreurPseudo = new JLabel("Veuillez entrer un pseudonyme pour continuer ");
		messageErreurClasse.setVisible(false);
		panel_2.add(messageErreurPseudo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String pseudo = textField.getText();
		if (pseudo.equals("")){
			this.messageErreurPseudo.setVisible(true);
		}
		else {
			perso.setNom(pseudo);
		}
		if ((perso.getType() != 'M') | (perso.getType() != 'G')){
			this.messageErreurClasse.setVisible(true);
		}
	}

	public Personnage getNouveauPersonnage(){
		return perso;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1){
			perso.setType('G');
		}
		else
			perso.setType('M');
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
