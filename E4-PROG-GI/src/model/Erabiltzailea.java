package model;

import java.util.Date;
import java.util.Objects;

/**
 * Erabiltzailea klasea erabiltzailearen datuak gordetzeko eta kudeatzeko erabiliko da.
 */
public class Erabiltzailea {
	protected String erabiltzailea;
	protected String pasahitza;
	protected String izena;
	protected String abizena;
	protected Date jaiotzeData;
	protected String hizkuntza;
	
<<<<<<< HEAD
	public Erabiltzailea(String izena, String abizena, String erabiltzailea, String pasahitza, String data,
			String hizk) {
=======
	/**
	 * Erabiltzailea klasearen eraikitzailea.
	 * 
	 * @param erabiltzailea Erabiltzailearen erabiltzaile izena
	 * @param pasahitza Erabiltzailearen pasahitza
	 * @param izena Erabiltzailearen izena
	 * @param abizena Erabiltzailearen abizena
	 * @param jaiotzeData Erabiltzailearen jaiotze data
	 * @param hizkuntza Erabiltzailearen hizkuntza
	 */
	public Erabiltzailea(String erabiltzailea, String pasahitza, String izena, String abizena, Date jaiotzeData,
			String hizkuntza) {
>>>>>>> 51c2b42dcd235e05ca3dcbdf3b433d9826b6d262
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.jaiotzeData = jaiotzeData;
		this.hizkuntza = hizkuntza;
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez jakiteko metodoa.
	 * 
	 * @param obj Beste objektua
	 * @return Objektuak berdinak diren ala ez
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Erabiltzailea other = (Erabiltzailea) obj;
		return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzailea, other.erabiltzailea)
				&& Objects.equals(hizkuntza, other.hizkuntza) && Objects.equals(izena, other.izena)
				&& Objects.equals(jaiotzeData, other.jaiotzeData) && Objects.equals(pasahitza, other.pasahitza);
	}

	/**
	 * Erabiltzailea klasearen testu errepresentazioa itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen testu errepresentazioa
	 */
	@Override
	public String toString() {
		return "Erabiltzailea [erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", izena=" + izena
				+ ", abizena=" + abizena + ", jaiotzeData=" + jaiotzeData + ", hizkuntza=" + hizkuntza + "]";
	}

	/**
	 * Erabiltzailearen erabiltzaile izena itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen erabiltzaile izena
	 */
	public String getErabiltzailea() {
		return erabiltzailea;
	}

	/**
	 * Erabiltzailearen erabiltzaile izena ezartzen duen metodoa.
	 * 
	 * @param erabiltzailea Erabiltzailearen erabiltzaile izena
	 */
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	/**
	 * Erabiltzailearen pasahitza itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * Erabiltzailearen pasahitza ezartzen duen metodoa.
	 * 
	 * @param pasahitza Erabiltzailearen pasahitza
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * Erabiltzailearen izena itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Erabiltzailearen izena ezartzen duen metodoa.
	 * 
	 * @param izena Erabiltzailearen izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Erabiltzailearen abizena itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen abizena
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * Erabiltzailearen abizena ezartzen duen metodoa.
	 * 
	 * @param abizena Erabiltzailearen abizena
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	/**
	 * Erabiltzailearen jaiotze data itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen jaiotze data
	 */
	public Date getJaiotzeData() {
		return jaiotzeData;
	}

	/**
	 * Erabiltzailearen jaiotze data ezartzen duen metodoa.
	 * 
	 * @param jaiotzeData Erabiltzailearen jaiotze data
	 */
	public void setJaiotzeData(Date jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
	}

	/**
	 * Erabiltzailearen hizkuntza itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen hizkuntza
	 */
	public String getHizkuntza() {
		return hizkuntza;
	}

	/**
	 * Erabiltzailearen hizkuntza ezartzen duen metodoa.
	 * 
	 * @param hizkuntza Erabiltzailearen hizkuntza
	 */
	public void setHizkuntza(String hizkuntza) {
		this.hizkuntza = hizkuntza;
	}	
}
