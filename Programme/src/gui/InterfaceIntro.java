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

import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InterfaceIntro extends JFrame implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int choix = 0;
	private WindowMap windowMap;
	private MonstresCommuns tabMonstres[] ;
	private MonstresElites tabElites[];
	public InterfaceIntro(WindowMap windowMap, MonstresCommuns tabMonstres[], MonstresElites tabElites[]) {
		this.windowMap = windowMap;
		this.tabMonstres = tabMonstres;
		this.tabElites = tabElites;
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
			case 1 : 
				choix =1;
				new InitPartie().initPartie(tabMonstres[], tabElites[], choix);
			try {
				
				windowMap.launchMap();
			} catch (SlickException e1) {
				
				e1.printStackTrace();
			}
			break;
				choix = 2;
			case 2 : new InitPartie().initPartie(tabMonstres[], tabElites[], choix);
			try {
				windowMap.launchMap();
			} catch (SlickException e1) {
				
				e1.printStackTrace();
			}
			break;
			
			case 3 : new InitPartie().options();
			}		
			if (choix != 0 )
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
