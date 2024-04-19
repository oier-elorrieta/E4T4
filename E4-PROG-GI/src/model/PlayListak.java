package model;

import java.util.Date;
import java.util.Objects;

public class PlayListak {
	private String izena;
	private Date sorreraData;
	
	public PlayListak(String izena, Date sorreraData) {
		this.izena = izena;
		this.sorreraData = sorreraData;
	}

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

	@Override
	public String toString() {
		return "PlayListak [izena=" + izena + ", sorreraData=" + sorreraData + "]";
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Date getSorreraData() {
		return sorreraData;
	}

	public void setSorreraData(Date sorreraData) {
		this.sorreraData = sorreraData;
	}
}
