package controller;

//import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//import main.VLSucheMain;

public class ButtonListenerNeueS implements ActionListener {
	
	private JButton suche;
	private JButton neueSuche;
	private DefaultListModel<String> ergebnisse;
	private JTextField prof;
	private JLabel fehler3;
	private JLabel fehler4;
	private JRadioButton ws2;
	
	public ButtonListenerNeueS(JButton suche, JButton neueSuche, DefaultListModel<String> ergebnisse, JTextField prof, JLabel fehler3, JLabel fehler4, JRadioButton ws2) {
		this.suche = suche;
		this.neueSuche = neueSuche;
		this.ergebnisse = ergebnisse;
		this.prof = prof;
		this.fehler3 = fehler3;
		this.fehler4 = fehler4;
		this.ws2 = ws2;
	}

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
