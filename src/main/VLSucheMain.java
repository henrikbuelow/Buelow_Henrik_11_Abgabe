package main;

import view.*;
import model.*;
import javax.swing.*;
import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Diese Klasse enthält die main-Methode der VL_Suche.
 * 
 * @author Henrik Bülow - ucxbi@student.kit.edu
 * @version 2020-06-02
 * 
 */

public class VLSucheMain {

	/**
	 * Main-Methode des Projektes
	 * 
	 * @param args 
	 * 		Kommandozeilenparameter
	 * 
	 */
	
	public static Set<Vorlesung> verzeichnis;
	public static Set<Vorlesung> suche;
	public static int zaehler;
	
	public static BufferedWriter out;
	
	public static void main(String[] args) {
		
		// Instanz der Klasse VLSucheFrame erstellen
		VLSucheFrame myFrame = new VLSucheFrame();
		myFrame.setTitle("VL_Suche");
		myFrame.setSize(800, 800);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
		// TreeSet verzeichnis und suche erstellen zum speichern der Vorlesungen
		verzeichnis = new TreeSet<Vorlesung>();
		suche = new TreeSet<Vorlesung>();
		
		// BufferedWriter out erstellen um die Vorlesungen auf die TextDatei zu schreiben
		try {
			
		out = new BufferedWriter(new FileWriter("vorlesungen.txt", false));
		
		} catch (IOException ioe) {
			
		}
	}
}
