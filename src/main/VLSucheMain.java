package main;

import view.*;
import controller.*;
import model.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.HashSet;

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
	 * @param args Kommandozeilenparameter
	 * 
	 */
	
	public static HashSet<Vorlesung> verzeichnis;
	public static HashSet<Vorlesung> suche;
	
	public static void main(String[] args) {
		
		VLSucheFrame myFrame = new VLSucheFrame();
		myFrame.setTitle("VL Suche");
		myFrame.setSize(800, 1000);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		
		verzeichnis = new HashSet<Vorlesung>();
		suche = new HashSet<Vorlesung>();

		
	}
	
}
