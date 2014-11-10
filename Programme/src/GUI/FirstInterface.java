package GUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FirstInterface extends JFrame{
 
	public FirstInterface(){
		super();
		build();//On initialise notre fen�tre
	}
 
	private void build(){
		setTitle("Ma premi�re fen�tre"); //On donne un titre � l'application
		setSize(800,600); //On donne une taille � notre fen�tre
		setLocationRelativeTo(null); //On centre la fen�tre sur l'�cran
		setResizable(false); //On interdit la redimensionnement de la fen�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
		setJMenuBar(buildMenuBar());
	}

	private JMenuBar buildMenuBar(){
		JMenuBar panel = new JMenuBar();
		JLabel label = new JLabel("Ceci est la MenuBar");
		panel.add(label);
		return panel;
	}
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
	 
		JLabel label = new JLabel("Bienvenue dans ma modeste application");
		panel.add(label);
		JButton bouton = new JButton("Cliquez ici !");
		panel.add(bouton);
		JButton bouton2 = new JButton("Ou l� !");
		panel.add(bouton2);
		JButton bouton3 = new JButton("Ou ici ! Soyons fou ! ");
		panel.add(bouton3);
	 
		return panel;
	}	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FirstInterface fenetre = new FirstInterface();
				fenetre.setVisible(true);//On la rend visible
			}
		});
	}
}