package gui;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import main.InitPartie;

import org.newdawn.slick.SlickException;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InterfaceIntro extends JFrame implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int choix;
	private WindowMap windowMap;
	public InterfaceIntro(WindowMap windowMap) {
		this.windowMap = windowMap;
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
			switch (e.getButton()){
			case 1 : new InitPartie().initNouv();
			try {
				windowMap.launchMap();
			} catch (SlickException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
			case 2 : new InitPartie().initContinue();
			try {
				windowMap.launchMap();
			} catch (SlickException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
			case 3 : new InitPartie().options();
			}			
			this.dispose();
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
