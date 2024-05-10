package model;

import java.sql.Blob;
import java.sql.Time;

public class Iragarkia extends Audio{
	public Iragarkia(int idAudio, String izena, Blob irudia) {
		super(idAudio, izena, null, irudia);
	}
}
