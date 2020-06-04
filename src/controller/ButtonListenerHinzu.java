package controller;

import java.awt.event.*;
import javax.swing.*;
import model.*;
import main.*;
//import view.VLSucheFrame;

public class ButtonListenerHinzu implements ActionListener {

	private String title;
	private String profName;
	private String semester;
	
	private JTextField titelField;
	private JTextField profNameField;
	private JRadioButton ws;
	private JLabel fehler1;
	private JLabel fehler2;
	
	public ButtonListenerHinzu(JTextField titelField, JTextField profNameField, JRadioButton ws, JLabel fehler1, JLabel fehler2) {
		this.titelField = titelField;
		this.profNameField = profNameField;
		this.ws = ws;
		this.fehler1 = fehler1;
		this.fehler2 = fehler2;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
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
				
				VLSucheMain.verzeichnis.add(new Vorlesung(title, profName, semester));
			
				//boolean istEnthalten = false;
				
				//for(Vorlesung v : VLSucheMain.verzeichnis) {
					//VLSucheMain.verzeichnis.add(new Vorlesung(title, profName, semester));
					/*if (this.title.equalsIgnoreCase(v.getTitel()) && this.profName.equalsIgnoreCase(v.getProf()) && this.semester.equalsIgnoreCase(v.getSemester())) {
						//istEnthalten = true;
						VLSucheMain.verzeichnis.add(new Vorlesung(title, profName, semester));
					}*/
				//}
				
				/*if(istEnthalten == false) {
					VLSucheMain.verzeichnis.add(new Vorlesung(title, profName, semester));
					System.out.println(istEnthalten);
					titelField.setText(null);
				} else {
					titelField.setText("Ihre Eingabe war ein Duplikat!");
				}
				*/
				//System.out.println(VLSucheMain.verzeichnis.size());
				//System.out.println(new Vorlesung(title, profName, semester));
				
				titelField.setText(null);
				profNameField.setText(null);
				ws.setSelected(true);
			
		}
	}
}
