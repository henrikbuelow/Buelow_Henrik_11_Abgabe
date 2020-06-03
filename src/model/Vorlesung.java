package model;

/**
 * Diese Klasse definiert das Object Vorlesung
 * @author Henrik B�low - ucxbi@student.kit.edu
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
	 * Getter Methode f�r die Variable title
	 * @return R�ckgabe des Titels der Vorlesung
	 */
	
	public String getTitel() {
		return this.titel;
	}
	
	/**
	 * Getter Methode f�r die Variable Prof
	 * @return R�ckgabe des Professors der Vorlesung
	 */
	
	public String getProf() {
		return this.prof;
	}
	
	/**
	 * Getter Methode f�r die Variable semester
	 * @return R�ckgabe des Semesters der Vorlesung
	 */
	
	public String getSemester() {
		return this.semester;
	}
	
	public String toString() {
		return "Titel: " + this.titel + "     Professor: " + this.prof + "     Semester: " + this.semester;
	}
}
