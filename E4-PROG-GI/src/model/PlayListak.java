package model;

import java.util.Date;
import java.util.Objects;

/**
 * PlayListak klasea errepresentatzen duen klasea.
 */
public class PlayListak {
	private int idPlayList;
	private String izena;
	private Date sorreraData;
	
	public PlayListak() {
		
	}
	
	
	
	/**
	 * PlayListak klasearen eraikitzailea.
	 * @param izena PlayListaren izena
	 * @param sorreraData PlayListaren sorrera data
	 */
	public PlayListak(int idPlayList, String izena, Date sorreraData) {
		this.idPlayList = idPlayList;
		this.izena = izena;
		this.sorreraData = sorreraData;
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez adierazten duen metodoa.
	 * @param obj Beste objektu bat
	 * @return Objektuak berdinak diren ala ez adierazten duen boolean balioa
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayListak other = (PlayListak) obj;
		return Objects.equals(izena, other.izena) && Objects.equals(sorreraData, other.sorreraData);
	}

	/**
	 * Objektuaren testu errepresentazioa itzultzen duen metodoa.
	 * @return Objektuaren testu errepresentazioa
	 */
	@Override
	public String toString() {
		return izena;
	}

	/**
	 * PlayListaren izena itzultzen duen metodoa.
	 * @return PlayListaren izena
	 */
	
	public int getIdPlayList() {
		return idPlayList;
	}

	public void setIdPlayList(int idPlayList) {
		this.idPlayList = idPlayList;
	}
	
	public String getIzena() {
		return izena;
	}

	/**
	 * PlayListaren izena ezartzen duen metodoa.
	 * @param izena PlayListaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * PlayListaren sorrera data itzultzen duen metodoa.
	 * @return PlayListaren sorrera data
	 */
	public Date getSorreraData() {
		return sorreraData;
	}

	/**
	 * PlayListaren sorrera data ezartzen duen metodoa.
	 * @param sorreraData PlayListaren sorrera data
	 */
	public void setSorreraData(Date sorreraData) {
		this.sorreraData = sorreraData;
	}
}
