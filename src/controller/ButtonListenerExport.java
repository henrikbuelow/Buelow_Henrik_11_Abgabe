package controller;

import java.awt.event.*;
import main.VLSucheMain;
import java.io.*;
import model.*;

/**
 * Diese Klasse stellt den ActionListener für den Button export bereit.
 * 
 * @author Henrik Bülow - ucxbi@student.kit.edu
 * @version 2020-06-04
 *
 */

public class ButtonListenerExport implements ActionListener{
	
	/**
	 * Diese Methode überschreibt die actionPerformed()-Methode des Interface ActionListener.
	 * Die Methode schreibt die gesuchten Vorlesungen in die Textdatei vorlesungen.txt.
	 * 
	 * @param e
	 * 		übergebenes ActionEvent	
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		VLSucheMain.zaehler++;
		
		//Schreibe über den BufferedWriter out die gewünschten Vorlesungen in die TextDatei
		try {
			
			VLSucheMain.out.write(VLSucheMain.zaehler + ". gespeichertes Ergebnis:");				
			VLSucheMain.out.newLine();
			
			for (Vorlesung v : VLSucheMain.suche) {
				
				VLSucheMain.out.write(v.toString());
				VLSucheMain.out.newLine();
				VLSucheMain.out.flush();
				
			}
			
		} catch (IOException ioe) {
			
		}
	}
}
