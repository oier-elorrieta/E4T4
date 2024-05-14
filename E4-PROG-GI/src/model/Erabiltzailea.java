package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Objects;

/**
 * Erabiltzailea klasea erabiltzailearen datuak gordetzeko eta kudeatzeko erabiliko da.
 */
public class Erabiltzailea {
	protected int idErabiltzailea;
	protected String erabiltzailea;
	protected String pasahitza;
	protected String izena;
	protected String abizena;
	protected Date jaiotzeData;
	protected String hizkuntza;

	
	/**
	 * Erabiltzailea klasearen eraikitzailea.
	 * 
	 * @param idErabiltzailea Erabiltzailearen id-ea
	 * @param erabiltzailea Erabiltzailearen erabiltzaile izena
	 * @param pasahitza Erabiltzailearen pasahitza
	 * @param izena Erabiltzailearen izena
	 * @param abizena Erabiltzailearen abizena
	 * @param jaiotzeData Erabiltzailearen jaiotze data
	 * @param hizkuntza Erabiltzailearen hizkuntza
	 */
	public Erabiltzailea() {
		
	}
	


	public Erabiltzailea(int idErabiltzailea, String erabiltzailea, String pasahitza, String izena, String abizena,Date jaiotzeData2, String hizkuntza) {
		this.idErabiltzailea = idErabiltzailea;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.izena = izena;
		this.abizena = abizena;
		this.jaiotzeData = jaiotzeData2;
		this.hizkuntza = hizkuntza;
	}
	
	public Erabiltzailea(int idErabiltzailea, String erabiltzailea, String pasahitza) {
		this.idErabiltzailea = idErabiltzailea;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
	}



	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez jakiteko metodoa.
	 * 
	 * @param obj Beste objektua
	 * @return Objektuak berdinak diren ala ez
	 */
	
	@Override
	public boolean equals(Object obj) {
		Erabiltzailea other = (Erabiltzailea) obj;
		return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzailea, other.erabiltzailea)
				&& Objects.equals(hizkuntza, other.hizkuntza)
				&& Objects.equals(izena, other.izena) && Objects.equals(jaiotzeData, other.jaiotzeData)
				&& Objects.equals(pasahitza, other.pasahitza);
	}

	/**
	 * Erabiltzailea klasearen testu errepresentazioa itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen testu errepresentazioa
	 */

	
	
	/**
	 * idErabiltzailearen erabiltzaile idea itzultzen duen metodoa.
	 * 
	 * @return Erabiltzailearen idea
	 */
	
	public int getIdErabiltzailea() {
		return idErabiltzailea;
	}
	
	@Override
	public String toString() {
		return "Erabiltzailea [idErabiltzailea=" + idErabiltzailea + ", erabiltzailea=" + erabiltzailea + ", pasahitza="
				+ pasahitza + ", izena=" + izena + ", abizena=" + abizena + ", jaiotzeData=" + jaiotzeData
				+ ", hizkuntza=" + hizkuntza + "]";
	}

	/**
	 * Erabiltzailearen idea ezartzen duen metodoa.
	 * 
	 * @param erabiltzailea id-ea
	 */
	
	public void setIdErabiltzailea(int idErabiltzailea) {
		this.idErabiltzailea = idErabiltzailea;
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
	 * @param date Erabiltzailearen jaiotze data
	 */
	public void setJaiotzeData(Date date) {
		this.jaiotzeData = date;
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
