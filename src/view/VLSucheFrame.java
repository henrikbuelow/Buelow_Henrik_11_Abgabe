package view;

import java.awt.*;
import javax.swing.*;
import controller.*;

/**
 * Diese Klasse stellt das Fester für die VL_Suche dar.
 * 
 * @author Henrik Bülow - ucxbi@student.kit.edu
 * @version 2020-06-04
 * 
 */

public class VLSucheFrame extends JFrame{

	/**
	 * SerialVersionUID zur Identifikation der Version der serialisierbaren Klasse 
	 */
	
	private static final long serialVersionUID = 1L;

	//Allgemein
	private Font ueberschrift;

	// ContentPane
	Container c;
	
	// Erstes Panel
	JPanel erstes;
		
	// Panel erstes
	JPanel enter;
	JLabel ersteAufforderung;
	
	// JPanel enter
	JPanel ersteEingabe;
	JPanel enterUnten;
	
	// JPanel enterUnten
	JButton enterButton;
	
	// JPanel ersteEingabe
	JPanel titel;
	JPanel profName;
	JPanel semester;
	
	// JPanel titel
	JLabel titelSchrift;
	JTextField titelFeld;
	JLabel fehler1;
	
	// JPanel profName
	JLabel profNameSchrift;
	JTextField profNameFeld;
	JLabel fehler2;
	
	// JPanel semester
	JLabel semesterSchrift;
	JPanel semesterButton;
	
	// JPanel semesterButton
	JRadioButton sose;
	JRadioButton ws;
	ButtonGroup semesterGruppe;
	
	// Zweites Panel
	JPanel zweites;
	
	// JPanel zweites
	JPanel enter2;
	JLabel zweiteAufforderung;
	
	// JPanel enter2
	JPanel zweiteEingabe;
	JPanel enterUnten2;
	
	//JPanel enterUnten2
	JButton enterButton2;
	JButton neueSuche;
	ButtonListenerNeueS neueS;
	
	// JPanel zweite Eingabe
	JPanel profName2;
	JPanel semester2;
	
	// JPanel profName2
	JLabel profNameSchrift2;
	JTextField profNameFeld2;
	JPanel profName2Fehler;
	
	// JPanel profName2Fehler
	JLabel fehler3;
	JLabel fehler4;
	
	// JPanel semester2
	JLabel semesterSchrift2;
	JPanel semesterButton2;
	
	// JPanel semesterButton2
	JRadioButton sose2;
	JRadioButton ws2;
	ButtonGroup semesterGruppe2;
	
	// Drittes Panel
	JLabel ergebnisTitel;
	JPanel list;
	DefaultListModel<String> listModel;
	JList<String> ergebnisse;
	
	// Button zum Export der Ergebnisse
	JButton export;
	ButtonListenerExport ex;
	
	/**
	 * Konstruktor der Klasse
	 */
	
	public VLSucheFrame() {
		
		// Allgemein
		c = getContentPane();
		c.setLayout(new GridLayout(3,1));
		ueberschrift = new Font("Tahoma", Font.BOLD, 15);

		// Erstes Panel aufbauen
		erstes = new JPanel(new GridLayout(2,1));
		c.add(erstes);
		
		//JPanel erstes aufbauen
		ersteAufforderung = new JLabel("Fügen Sie eine neue Vorlesung hinzu", SwingConstants.CENTER);
		ersteAufforderung.setFont(ueberschrift);
		erstes.add(ersteAufforderung);
		
		enter = new JPanel(new GridLayout(2,1));
		erstes.add(enter);
		
		// JPanel ersteEingabe
		ersteEingabe = new JPanel(new GridLayout(1,3));
		enter.add(ersteEingabe);
		
		// JPanel ersteEingabe aufbauen
		titel = new JPanel(new GridLayout(3,1));
		ersteEingabe.add(titel);
		profName = new JPanel(new GridLayout(3,1));
		ersteEingabe.add(profName);
		semester = new JPanel(new GridLayout(2,1));
		ersteEingabe.add(semester);
		
		// JPanel titel aufbauen
		titelSchrift = new JLabel("Titel der VL", SwingConstants.CENTER);
		titel.add(titelSchrift);
		titelFeld = new JTextField();
		titel.add(titelFeld);
		fehler1 = new JLabel("Bitte einen Titel eingeben!", SwingConstants.CENTER);
		titel.add(fehler1);
		fehler1.setVisible(false);
		
		// JPanel profName aufbauen
		profNameSchrift = new JLabel("Name des Professors", SwingConstants.CENTER);
		profName.add(profNameSchrift);
		profNameFeld = new JTextField();
		profName.add(profNameFeld);	
		fehler2 = new JLabel("Bitte einen Professor eingeben!", SwingConstants.CENTER);
		profName.add(fehler2);
		fehler2.setVisible(false);
		
		// JPanel semester aufbauen
		semesterSchrift = new JLabel("Semester", SwingConstants.CENTER);
		semester.add(semesterSchrift);
		semesterButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		semester.add(semesterButton);
		
		// JPanel semesterButton aufbauen
		sose = new JRadioButton("Sommersemester");
		ws = new JRadioButton("Wintersemester");
		ws.setSelected(true);
		semesterGruppe = new ButtonGroup();
		semesterGruppe.add(sose);
		semesterGruppe.add(ws);
		semesterButton.add(ws);
		semesterButton.add(sose);
		
		// JPanel enterUnten aufbauen
		enterUnten = new JPanel(new FlowLayout(FlowLayout.CENTER));
		enter.add(enterUnten);
		
		// enterButton hinzufuegen
		enterButton = new JButton("Hinzufügen");
		ButtonListenerHinzu hinzu = new ButtonListenerHinzu(titelFeld, profNameFeld, ws, fehler1, fehler2);
		enterButton.addActionListener(hinzu);
		enterUnten.add(enterButton);
		
		// Zweites Panel aufbauen
		zweites = new JPanel(new GridLayout(2,1));
		c.add(zweites);
		
		// JPanel zweites aufbauen
		zweiteAufforderung = new JLabel("Suchen Sie nach Ihrer Vorlesung", SwingConstants.CENTER);
		zweiteAufforderung.setFont(ueberschrift);
		zweites.add(zweiteAufforderung);
		
		enter2 = new JPanel(new GridLayout(2,1));
		zweites.add(enter2);
		
		// JPanel zweiteEingabe
		zweiteEingabe = new JPanel(new GridLayout(1,2));
		enter2.add(zweiteEingabe);
		
		// JPanel zweiteEingabe aufbauen
		profName2 = new JPanel(new GridLayout(3,1));
		zweiteEingabe.add(profName2);
		semester2 = new JPanel(new GridLayout(2,1));
		zweiteEingabe.add(semester2);
		
		// JPanel profName2 aufbauen
		profNameSchrift2 = new JLabel("Name des Professors", SwingConstants.CENTER);
		profName2.add(profNameSchrift2);
		profNameFeld2 = new JTextField();
		profName2.add(profNameFeld2);
		profName2Fehler = new JPanel(new FlowLayout(FlowLayout.CENTER));
		profName2.add(profName2Fehler);
		
		// JPanel profName2Fehler aufbauen
		fehler3 = new JLabel("Bitte einen Professor eingeben!");
		profName2Fehler.add(fehler3);
		fehler3.setVisible(false);
		fehler4 = new JLabel("Keine Vorlesung gefunden!");
		profName2Fehler.add(fehler4);
		fehler4.setVisible(false);
		
		// JPanel semester aufbauen
		semesterSchrift2 = new JLabel("Semester", SwingConstants.CENTER);
		semester2.add(semesterSchrift2);
		semesterButton2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		semester2.add(semesterButton2);
		
		// JPanel semesterButton aufbauen
		sose2 = new JRadioButton("Sommersemester");
		ws2 = new JRadioButton("Wintersemester");
		ws2.setSelected(true);
		semesterGruppe2 = new ButtonGroup();
		semesterGruppe2.add(sose2);
		semesterGruppe2.add(ws2);
		semesterButton2.add(ws2);
		semesterButton2.add(sose2);
		
		//JPanel enterUnten2 aufbauen
		enterUnten2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		enter2.add(enterUnten2);
		
		// enterButton2 und neueSuche hinzufuegen
		enterButton2 = new JButton("Suchen");
		enterUnten2.add(enterButton2);
		neueSuche = new JButton("Suche neustarten");
		enterUnten2.add(neueSuche);
		neueSuche.setVisible(false);
		
		// Fuenftes Panel aufbauen
		ergebnisTitel = new JLabel("Ergebnisse Ihrer Suche:         ", SwingConstants.LEFT);
		ergebnisTitel.setFont(ueberschrift);
		c.add(ergebnisTitel);
		
		// Sechstes Panel aufbauen
		list = new JPanel(new FlowLayout(FlowLayout.CENTER));
		c.add(list);
		list.add(ergebnisTitel);
		listModel = new DefaultListModel<>(); 
		ergebnisse = new JList<String>(listModel);
		JScrollPane scroll = new JScrollPane(ergebnisse, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		ButtonListenerSuchen such = new ButtonListenerSuchen(profNameFeld2, ws2, listModel, enterButton2, neueSuche, fehler3, fehler4);
		enterButton2.addActionListener(such);
		list.add(scroll);
		
		//ButtonListener für enterButton2 und neueSuche
		neueS = new ButtonListenerNeueS(enterButton2, neueSuche, listModel, profNameFeld2, fehler3, fehler4, ws2);
		neueSuche.addActionListener(neueS);
		
		// Button zum Export der Ergebnisse aufbauen
		export = new JButton("Ergebnisse in Text-Datei schreiben");
		ex = new ButtonListenerExport();
		export.addActionListener(ex);
		enterUnten2.add(export);
		
	}
}