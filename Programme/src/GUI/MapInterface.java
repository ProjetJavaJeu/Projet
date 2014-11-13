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
		setResizable(false); // On interdit la redimensionnement de la fen�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);// On la rend visible
		setBackground(new Color(255, 140, 0)); //Donne la couleur de l'arri�re plan : suffit de sp�cifier les trois variables RGB (Voir fichier inspirations_java)
		
		setContentPane(buildContentPane()); //Ajoute du contenu dans le "contentPane". Je vais taper un sch�ma sur le git, ce sera plus clair.
		}
		
	private JPanel buildContentPane(){
		JPanel tabPanel = new JPanel(); //panel qui contientra tout les panels "case".
		tabPanel.setOpaque(false);
		//tabPanel.add(messageAcceuil());
		GridBagConstraints gbc = new GridBagConstraints(); //Variable permettant de placer les diff�rents cellules en fonctions de coordonn�es.
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		tabPanel.setLayout(new GridBagLayout());
		int i ,j;
		for (i = 0; i < 10; i++){
			gbc.gridx = i; //D�finit � chaque it�ration de i la coordonn�e x d'une cellule.
			for(j = 0; j < 10; j++){
				gbc.gridy = j; //D�finit � chaque it�ration de j la coordonn�e y d'une cellule.
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

