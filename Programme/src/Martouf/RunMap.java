package Martouf;

import javax.swing.SwingUtilities;

import GUI.InterfaceMap;

public class RunMap {

	public void LaunchMap(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceMap map = new InterfaceMap();
			}
		});
	}

}
