package model;

import java.sql.Blob;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Audio klasea errepresentazioa egiten du audio fitxategien datuei buruz.
 */
public class Audio {
	protected int idAudio;
	protected String izena;
	protected Time iraupena;
	protected Blob irudia;

	/**
	 * Audio objektuaren eraikitzailea.
	 * 
	 * @param izena     audioaren izena
	 * @param iraupena  audioaren iraupena
	 */
	
	public Audio(int idAudio, String izena, Time iraupena) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
	}
	public Audio(int idAudio, String izena, Time iraupena, Blob irudia) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
		this.irudia = irudia;
	}

	public int getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Time getIraupena() {
		return iraupena;
	}

	public void setIraupena(Time iraupena) {
		this.iraupena = iraupena;
	}

	public Blob getIrudia() {
		return irudia;
	}

	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	@Override
	public String toString() {
		return "Audio [idAudio=" + idAudio + ", izena=" + izena + ", iraupena=" + iraupena + ", irudia=" + irudia + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return idAudio == other.idAudio && Objects.equals(iraupena, other.iraupena)
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izena, other.izena);
	}

	
	
	
}