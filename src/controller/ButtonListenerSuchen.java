package controller;

import java.awt.event.*;
import javax.swing.*;
import main.*;
import model.*;

/**
 * Diese Klasse stellt den ActionListener f�r den Button enterButton2 bereit
 * 
 * @author Henrik B�low - ucxbi@student.kit.edu
 * @version 2020-06-04
 *
 */

public class ButtonListenerSuchen implements ActionListener {
	
	private String prof;
	private String semester;
	
	private JTextField profNameFeld2;
	private JRadioButton ws2;
	private DefaultListModel<String> ergebnisse;
	private JButton enter;
	private JButton neueSuche;
	private JLabel fehler3;
	private JLabel fehler4;
	
	/**
	 * Konstruktor der Klasse ButtonListenerSuchen
	 * 
	 * @param profNameFeld2
	 * 		JTextField zum einlesen des Namen des Profs nach dem gesucht wird
	 * @param ws2
	 * 		JRadioButton zum einlesen des Semesters nach dem gesucht wird
	 * @param ergebnisse
	 * 		DefaultListModel zum abgleichen der Ergebnisse
	 * @param enter
	 * 		JButton der in der Methode unsichtbar gemacht werden soll
	 * @param neueSuche
	 * 		JButton der in der Methode sichtbar gemacht werden soll
	 * @param fehler3
	 * 		JLabel zum Anzeigen falls der Prof der VL fehlt
	 * @param fehler4
	 * 		JLabel zum Anzeigen dass nichts gefunden wurd
	 */
	
	public ButtonListenerSuchen(JTextField profNameFeld2, JRadioButton ws2, DefaultListModel<String> ergebnisse, JButton enter, JButton neueSuche, JLabel fehler3, JLabel fehler4) {
		
		this.profNameFeld2 = profNameFeld2;
		this.ws2 = ws2;
		this.ergebnisse = ergebnisse;
		this.enter = enter;
		this.neueSuche = neueSuche;
		this.fehler3 = fehler3;
		this.fehler4 = fehler4;
		
	}

	/**
	 * Diese Methode �berschreibt die actionPerformed()-Methode des Interface ActionListener.
	 * Diese Methode sucht nach �bereinstimmungen, speichert gefundene Vorlesuungen im TreeSet suche
	 * und schreibt die Ergebnisse in die JList.
	 * 
	 * @param e
	 * 		�bergebenes ActionEvent
	 * 			
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (profNameFeld2.getText().equals("")) {
			
			fehler3.setVisible(true);
			fehler4.setVisible(false);
			
		} else {
			
			VLSucheMain.suche.clear();
			
			this.prof = profNameFeld2.getText();
			
			if (ws2.isSelected()) {
				this.semester = "Wintersemester";
			} else {
				this.semester = "Sommersemester";
			}
			
			// Suche nach allen �bereinstimmenden Vorlesungen 
			for (Vorlesung v : VLSucheMain.verzeichnis) {
				if (v.getProf().equalsIgnoreCase(prof) && v.getSemester().equalsIgnoreCase(semester)) {
					VLSucheMain.suche.add(v);
				}
			}
			
			if (VLSucheMain.suche.isEmpty()) {
				
				fehler3.setVisible(false);
				fehler4.setVisible(true);
				
			} else {
			
				// Gefundene Vorlesungen in JList anzeigen
				for (Vorlesung v : VLSucheMain.suche) {
					ergebnisse.addElement(v.toString());
				}
				
				enter.setVisible(false);
				neueSuche.setVisible(true);
				
				fehler3.setVisible(false);
				fehler4.setVisible(false);
				
			}
		}
	}
}
