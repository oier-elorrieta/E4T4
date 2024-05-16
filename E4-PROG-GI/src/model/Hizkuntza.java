package model;

import java.util.Objects;

/**
 * Hizkuntza klasea hizkuntza objetuak gordetzeko eta kudeatzeko erabiliko da.
 */
public class Hizkuntza {
	private String idHizkuntza;
	private String izenaHizkuntza;

	public Hizkuntza() {
	
	}
	
	/**
	 * Hizkuntza klasearen eraikitzailea.
	 * 
	 * @param idHizkuntza    hizkuntzaren identifikadorea
	 * @param izenaHizkuntza hizkuntzaren izena
	 */
	public Hizkuntza(String idHizkuntza, String izenaHizkuntza) {
		this.idHizkuntza = idHizkuntza;
		this.izenaHizkuntza = izenaHizkuntza;
	}

	/**
	 * Hizkuntzaren identifikadorea itzultzen du.
	 * 
	 * @return hizkuntzaren identifikadorea
	 */
	public String getIdHizkuntza() {
		return idHizkuntza;
	}

	/**
	 * Hizkuntzaren identifikadorea ezarri du.
	 * 
	 * @param idHizkuntza hizkuntzaren identifikadorea
	 */
	public void setIdHizkuntza(String idHizkuntza) {
		this.idHizkuntza = idHizkuntza;
	}

	/**
	 * Hizkuntzaren izena itzultzen du.
	 * 
	 * @return hizkuntzaren izena
	 */
	public String getIzenaHizkuntza() {
		return izenaHizkuntza;
	}

	/**
	 * Hizkuntzaren izena ezarri du.
	 * 
	 * @param izenaHizkuntza hizkuntzaren izena
	 */
	public void setIzenaHizkuntza(String izenaHizkuntza) {
		this.izenaHizkuntza = izenaHizkuntza;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hizkuntza other = (Hizkuntza) obj;
		return Objects.equals(idHizkuntza, other.idHizkuntza) && Objects.equals(izenaHizkuntza, other.izenaHizkuntza);
	}

	@Override
	public String toString() {
		return "Hizkuntza [idHizkuntza=" + idHizkuntza + ", izenaHizkuntza=" + izenaHizkuntza + "]";
	}

}
