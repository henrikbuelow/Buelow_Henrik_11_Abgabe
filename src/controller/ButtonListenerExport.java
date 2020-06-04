package controller;

import java.awt.event.*;
import javax.swing.*;

import main.VLSucheMain;

import java.io.*;
import model.*;

public class ButtonListenerExport implements ActionListener{
	
	private JButton export;
	
	public ButtonListenerExport(JButton export) {
		this.export = export;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(VLSucheMain.suche);
		
		VLSucheMain.zaehler++;
		
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
