package controller;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import main.VLSucheMain;

public class ButtonListenerNeueS implements ActionListener {
	
	private JButton suche;
	private JButton neueSuche;
	private DefaultListModel<String> ergebnisse;
	private JTextField prof;
	
	public ButtonListenerNeueS(JButton suche, JButton neueSuche, DefaultListModel<String> ergebnisse, JTextField prof) {
		this.suche = suche;
		this.neueSuche = neueSuche;
		this.ergebnisse = ergebnisse;
		this.prof = prof;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		neueSuche.setVisible(false);
		suche.setVisible(true);
		
		ergebnisse.removeAllElements();
		
		prof.setText(null);
		
		//VLSucheMain.out.replaceAll("");
		
	}
}
