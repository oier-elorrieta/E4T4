package model;

import java.sql.Blob;
import java.sql.Time;

/**
 * Podcast class represents a podcast audio file.
 * It extends the Audio class.
 */
public class Podcast extends Audio {

	/**
	 * Constructs a Podcast object with the specified name and duration.
	 * 
	 * @param izena     the name of the podcast
	 * @param iraupena  the duration of the podcast in seconds
	 */

	
	public Podcast(int IdAudio, String izena, Time iraupena, Blob irudia) {
		super(IdAudio, izena, iraupena, irudia);
	}
}
