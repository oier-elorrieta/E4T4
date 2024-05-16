package model;

import java.sql.Blob;
import java.sql.Time;

/**
 * Iragarkia klasea, Audio klasearen luzapena da.
 * Iragarkiak idAudio, izena eta irudia atributuak ditu.
 */
public class Iragarkia extends Audio{
	/**
	 * Iragarkia klasearen eraikitzailea.
	 * @param idAudio Iragarkiaren identifikazio zenbakia.
	 * @param izena Iragarkiaren izena.
	 * @param irudia Iragarkiaren irudia.
	 */
	public Iragarkia(int idAudio, String izena, Blob irudia) {
		super(idAudio, izena, null, irudia);
	}
	
	
}
