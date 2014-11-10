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
		build();//On initialise notre fenêtre
	}
 
	private void build(){
		setTitle("Ma première fenêtre"); //On donne un titre à l'application
		setSize(800,600); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
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
		JButton bouton2 = new JButton("Ou là !");
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