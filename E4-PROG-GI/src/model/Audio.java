package model;

import java.util.Objects;

public class Audio {
	protected String izena;
	protected int iraupena;
	
	public Audio(String izena, int iraupena) {
		this.izena = izena;
		this.iraupena = iraupena;
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
		return iraupena == other.iraupena && Objects.equals(izena, other.izena);
	}

	@Override
	public String toString() {
		return "Audio [izena=" + izena + ", iraupena=" + iraupena + "]";
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getIraupena() {
		return iraupena;
	}

	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}	
}