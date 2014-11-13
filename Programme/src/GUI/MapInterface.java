package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MapInterface extends JFrame {
	public MapInterface(){
		super();
		buildInterfaceMap();
	}
		
	private void buildInterfaceMap(){
		setTitle("The Epic School Adventure"); // Titre de l'app
		setResizable(false); // On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);// On la rend visible
		setBackground(new Color(255, 140, 0)); //Donne la couleur de l'arrière plan : suffit de spécifier les trois variables RGB (Voir fichier inspirations_java)
		
		setContentPane(buildContentPane()); //Ajoute du contenu dans le "contentPane". Je vais taper un schéma sur le git, ce sera plus clair.
		}
		
	private JPanel buildContentPane(){
		JPanel tabPanel = new JPanel(); //panel qui contientra tout les panels "case".
		tabPanel.setOpaque(false);
		//tabPanel.add(messageAcceuil());
		GridBagConstraints gbc = new GridBagConstraints(); //Variable permettant de placer les différents cellules en fonctions de coordonnées.
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		tabPanel.setLayout(new GridBagLayout());
		int i ,j;
		for (i = 0; i < 10; i++){
			gbc.gridx = i; //Définit à chaque itération de i la coordonnée x d'une cellule.
			for(j = 0; j < 10; j++){
				gbc.gridy = j; //Définit à chaque itération de j la coordonnée y d'une cellule.
				JButton cell = new JButton();
				cell.setText(i + ", " + j);
				tabPanel.add(cell, gbc);
			}
		}
		return tabPanel;
	}
	
	/*public JPanel messageAcceuil(){
		
	}*/
}	

