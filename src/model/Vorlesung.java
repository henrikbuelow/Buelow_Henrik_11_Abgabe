package model;

/**
 * Diese Klasse definiert das Object Vorlesung
 * @author Henrik Bülow - ucxbi@student.kit.edu
 * @version 2020-06-02
 * 
 */

public class Vorlesung {

	private String titel;
	private String prof;
	private String semester;
	
	/**
	 * Diese Methode ist der Konstruktor
	 * @param titel Dieser Parameter setzt den Titel der Vorlesung
	 * @param prof Dieser Parameter setzt den Professor der Vorlesung
	 * @param semester Dieser Parameter setzt das Semester der Vorlesung
	 */
	
	public Vorlesung(String titel, String prof, String semester) {
		this.titel = titel;
		this.prof = prof;
		this.semester = semester;
	}
	
	/**
	 * Getter Methode für die Variable title
	 * @return Rückgabe des Titels der Vorlesung
	 */
	
	public String getTitel() {
		return this.titel;
	}
	
	/**
	 * Getter Methode für die Variable Prof
	 * @return Rückgabe des Professors der Vorlesung
	 */
	
	public String getProf() {
		return this.prof;
	}
	
	/**
	 * Getter Methode für die Variable semester
	 * @return Rückgabe des Semesters der Vorlesung
	 */
	
	public String getSemester() {
		return this.semester;
	}
	
	public String toString() {
		return "Titel: " + this.titel + "     Professor: " + this.prof + "     Semester: " + this.semester;
	}
}
