package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.VLSucheController;
import view.*;
import main.*;
import model.*;

public class ButtonListenerSuchen implements ActionListener {
	
	private String prof;
	private String semester;
	
	private String text;
	
	private JTextField profNameFeld2;
	private JRadioButton ws2;
	private DefaultListModel<String> ergebnisse;
	private JButton enter;
	private JButton neueSuche;
	
	public ButtonListenerSuchen(JTextField profNameFeld2, JRadioButton ws2, DefaultListModel<String> ergebnisse, JButton enter, JButton neueSuche) {
		
		this.profNameFeld2 = profNameFeld2;
		this.ws2 = ws2;
		this.ergebnisse = ergebnisse;
		this.enter = enter;
		this.neueSuche = neueSuche;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		VLSucheMain.suche.clear();
		//ergebnisse.removeAllElements();
		//this.ergebnisse.setText(null);
		
		this.prof = profNameFeld2.getText();
		System.out.println(this.prof);
		
		if (ws2.isSelected()) {
			this.semester = "Wintersemester";
		} else {
			this.semester = "Sommersemester";
		}
		
		// Suche nach allen übereinstimmenden Vorlesungen 
		for (Vorlesung v : VLSucheMain.verzeichnis) {
			if (v.getProf().equals(prof) && v.getSemester().equals(semester)) {
				VLSucheMain.suche.add(v);
			}
		}
		
		// Gefundene Vorlesungen in JList anzeigen
		for (Vorlesung v : VLSucheMain.suche) {
			ergebnisse.addElement(v.toString());
			//text = text + v.toString() + "\n";
		}
		
		enter.setVisible(false);
		neueSuche.setVisible(true);
		
		//this.ergebnisse.setText(text);
		
	}

}
