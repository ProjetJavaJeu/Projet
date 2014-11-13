package main;

import javax.swing.SwingUtilities;

import GUI.FirstInterface;
import GUI.MapInterface;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FirstInterface fenetre = new FirstInterface();
			}
		});

	}

}
