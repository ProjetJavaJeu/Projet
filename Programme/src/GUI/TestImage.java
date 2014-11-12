package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestImage extends JFrame {
	private JFrame frame = new JFrame();

	public static void main(String... args) {
		JFrame frame = new JFrame();
		ImageIcon image = new ImageIcon(
				"D:\\Cours\\Ephec\\2TL2\\Programmation avancée - Java\\Projet\\Rapport\\FICTIF.png");
		System.out.println(image.getIconHeight());
		frame.setPreferredSize(new Dimension(image.getIconWidth(), image
				.getIconHeight()));
		JPanel panel = new JPanel();
		JLabel label = new JLabel(image);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}