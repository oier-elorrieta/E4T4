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
	protected String irudiaString;
	/**
	 * Audio objektuaren eraikitzailea.
	 * 
	 * @param izena     audioaren izena
	 * @param iraupena  audioaren iraupena
	 */
	
	public Audio() {
	}
	
	/**
	 * Audio objektuaren eraikitzailea.
	 * 
	 * @param idAudio   audioaren identifikadorea
	 * @param izena     audioaren izena
	 * @param iraupena  audioaren iraupena
	 */
	public Audio(int idAudio, String izena, Time iraupena) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
	}
	
	/**
	 * Audio objektuaren eraikitzailea.
	 * 
	 * @param idAudio   audioaren identifikadorea
	 * @param izena     audioaren izena
	 * @param iraupena  audioaren iraupena
	 * @param irudia    audioaren irudia
	 */
	public Audio(int idAudio, String izena, Time iraupena, Blob irudia) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
		this.irudia = irudia;
	}

	/**
	 * Audioaren identifikadorea itzultzen du.
	 * 
	 * @return audioaren identifikadorea
	 */
	public int getIdAudio() {
		return idAudio;
	}

	/**
	 * Audioaren identifikadorea ezartzen du.
	 * 
	 * @param idAudio   audioaren identifikadorea
	 */
	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}

	/**
	 * Audioaren izena itzultzen du.
	 * 
	 * @return audioaren izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Audioaren izena ezartzen du.
	 * 
	 * @param izena     audioaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Audioaren iraupena itzultzen du.
	 * 
	 * @return audioaren iraupena
	 */
	public Time getIraupena() {
		return iraupena;
	}

	/**
	 * Audioaren iraupena ezartzen du.
	 * 
	 * @param iraupena  audioaren iraupena
	 */
	public void setIraupena(Time iraupena) {
		this.iraupena = iraupena;
	}

	/**
	 * Audioaren irudia itzultzen du.
	 * 
	 * @return audioaren irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Audioaren irudia ezartzen du.
	 * 
	 * @param irudia    audioaren irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getIrudiaString() {
		return irudiaString;
	}
	/**
	 * 
	 * @param irudiaString
	 */
	public void setIrudiaString(String irudiaString) {
		this.irudiaString = irudiaString;
	}

	/**
	 * Audio objektua testu moduan itzultzen du.
	 * 
	 * @return audio objektua testu moduan
	 */
	@Override
	public String toString() {
		return "Audio [idAudio=" + idAudio + ", izena=" + izena + ", iraupena=" + iraupena + ", irudia=" + irudia + "]";
	}
	


	/**
	 * Audio objektuak alderatzen ditu.
	 * 
	 * @param obj   beste objektu bat
	 * @return      true, objektuak berdinak direnean; false, bestela
	 */
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
				 && Objects.equals(izena, other.izena);
	}
}