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
	private JLabel fehler3;
	private JLabel fehler4;
	
	public ButtonListenerSuchen(JTextField profNameFeld2, JRadioButton ws2, DefaultListModel<String> ergebnisse, JButton enter, JButton neueSuche, JLabel fehler3, JLabel fehler4) {
		
		this.profNameFeld2 = profNameFeld2;
		this.ws2 = ws2;
		this.ergebnisse = ergebnisse;
		this.enter = enter;
		this.neueSuche = neueSuche;
		this.fehler3 = fehler3;
		this.fehler4 = fehler4;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (profNameFeld2.getText().equals("")) {
			
			fehler3.setVisible(true);
			fehler4.setVisible(false);
			
		} else {
			
			VLSucheMain.suche.clear();
			
			this.prof = profNameFeld2.getText();
			//System.out.println(this.prof);
			
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
