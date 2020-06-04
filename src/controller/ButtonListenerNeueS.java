package controller;

import java.awt.event.*;
import javax.swing.*;

/**
 * Diese Klasse stellt den ActionListener f�r den Button neueSuche bereit
 * 
 * @author Henrik B�low - ucxbi@student.kit.edu
 * @version 2020-06-04
 *
 */

public class ButtonListenerNeueS implements ActionListener {
	
	private JButton suche;
	private JButton neueSuche;
	private DefaultListModel<String> ergebnisse;
	private JTextField prof;
	private JLabel fehler3;
	private JLabel fehler4;
	private JRadioButton ws2;
	
	/**
	 * Konstruktor der Klasse ButtonListenerNeueS
	 * 
	 * @param suche
	 * 		JButton der die Suche ausl�st
	 * @param neueSuche
	 * 		JButton der den Suchverlauf neustarted
	 * @param ergebnisse
	 * 		DefaultListModel in dem die Ergebnisse der Suche gespeichert sind
	 * @param prof
	 * 		JTextField dass den zu suchenen Prof einliesst
	 * @param fehler3
	 * 		JLabel wird zum zur�cksetzen der Fehler Anzeigen genutzt
	 * @param fehler4
	 * 		JLabel wird zum zur�cksetzen der Fehler Anzeigen genutzt 
	 * @param ws2
	 * 		JRadioButton wird zum zur�cksetzten des Default Zustandes genutzt
	 */
	
	public ButtonListenerNeueS(JButton suche, JButton neueSuche, DefaultListModel<String> ergebnisse, JTextField prof, JLabel fehler3, JLabel fehler4, JRadioButton ws2) {
		this.suche = suche;
		this.neueSuche = neueSuche;
		this.ergebnisse = ergebnisse;
		this.prof = prof;
		this.fehler3 = fehler3;
		this.fehler4 = fehler4;
		this.ws2 = ws2;
	}

	/**
	 * Diese Methode �berschreibt die actionPerformed()-Methode des Interface ActionListener.
	 * Diese Methode setzt die Buttons, Labels und TextFields auf ihre Default Einstellung zur�ck
	 * und leert den TreeSet mit den gespeicherten Vorlesungen der letzten Suche.
	 * 
	 * @param e
	 * 		�bergebenes ActionEvent
	 * 			
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		neueSuche.setVisible(false);
		suche.setVisible(true);
		
		ergebnisse.removeAllElements();
		
		prof.setText(null);
		
		fehler3.setVisible(false);
		fehler4.setVisible(false);
		
		ws2.setSelected(true);
		
	}
}
