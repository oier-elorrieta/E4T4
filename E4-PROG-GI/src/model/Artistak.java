package model;

import java.util.Objects;

public abstract class Artistak {
	protected String izena;
	protected String deskription;
	protected String irudia;
	
	public Artistak(String izena, String deskription, String irudia) {
		this.izena = izena;
		this.deskription = deskription;
		this.irudia = irudia;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artistak other = (Artistak) obj;
		return Objects.equals(deskription, other.deskription) && Objects.equals(irudia, other.irudia)
				&& Objects.equals(izena, other.izena);
	}

	@Override
	public String toString() {
		return "Artistak [izena=" + izena + ", deskription=" + deskription + ", irudia=" + irudia + "]";
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getDeskription() {
		return deskription;
	}

	public void setDeskription(String deskription) {
		this.deskription = deskription;
	}

	public String getIrudia() {
		return irudia;
	}

	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}
}
