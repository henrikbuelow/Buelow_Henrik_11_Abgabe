package controller;

import java.awt.event.*;
import javax.swing.*;
import model.*;
import main.*;

/**
 * Diese Klasse stellt den ActionListener für den Button enterButton bereit.
 * 
 * @author Henrik Bülow - ucxbi@student.kit.edu
 * @version 2020-06-04
 *
 */

public class ButtonListenerHinzu implements ActionListener {

	private String title;
	private String profName;
	private String semester;
	
	private JTextField titelField;
	private JTextField profNameField;
	private JRadioButton ws;
	private JLabel fehler1;
	private JLabel fehler2;
	
	/**
	 * Konstruktor der Klasse ButtonListenerHinzu
	 * 
	 * @param titelField
	 * 		JTextField zum Einlesen des Titels der Vorlesung (VL)
	 * @param profNameField
	 * 		JTextField zum Einlesen des Profs der VL
	 * @param ws
	 * 		JRadioButton zum Einlesen des Semesters der VL
	 * @param fehler1
	 * 		JLabel zum Anzeigen falls der Titel der VL fehlt
	 * @param fehler2
	 * 		JLabel zum Anzeigen falls der Prof der VL fehlt
	 * 
	 */
	
	public ButtonListenerHinzu(JTextField titelField, JTextField profNameField, JRadioButton ws, JLabel fehler1, JLabel fehler2) {
		
		this.titelField = titelField;
		this.profNameField = profNameField;
		this.ws = ws;
		this.fehler1 = fehler1;
		this.fehler2 = fehler2;
		
	}
	
	/**
	 * Diese Methode überschreibt die actionPerformed()-Methode des Interface ActionListener.
	 * Diese Methode prüft die eingelesenen Vorlesungen und fügt diese dem TreeSet hinzu.
	 * 
	 * @param e
	 * 		übergebenes ActionEvent
	 * 			
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// kontrollieren ob einer oder beide der Text Felder leer sind
		if ((titelField.getText().equals("")) && !(profNameField.getText().equals(""))) { 
			
			fehler1.setVisible(true); 
			fehler2.setVisible(false);
			
		} else if (!(titelField.getText().equals("")) && (profNameField.getText().equals(""))) { 
			
			fehler1.setVisible(false);
			fehler2.setVisible(true);
			
		} else if ((titelField.getText().equals("")) && (profNameField.getText().equals(""))) {
			
			fehler1.setVisible(true);
			fehler2.setVisible(true);
			
		} else if (!(titelField.getText().equals("")) && !(profNameField.getText().equals(""))){
		
			fehler1.setVisible(false);
			fehler2.setVisible(false);
				
			title = titelField.getText();
			profName = profNameField.getText();
			
			if (ws.isSelected()) {
				semester = "Wintersemester";
			} else {
				semester = "Sommersemester";
			}
			
			//Vorlesung zu TreeSet hinzufügen
			VLSucheMain.verzeichnis.add(new Vorlesung(title, profName, semester));
			
			// Felder zurück in Default Einstellung setzen
			titelField.setText(null);
			profNameField.setText(null);
			ws.setSelected(true);
			
		}
	}
}
