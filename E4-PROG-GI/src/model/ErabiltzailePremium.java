package model;

import java.sql.Date;
import java.util.Objects;

/**
 * Klase honek Erabiltzailea klasea heredatzen du eta ErabiltzailePremium motako erabiltzaileak
 * errepresentatzen ditu. ErabiltzailePremium-ek premium mugaren data bat izango dute.
 */
public class ErabiltzailePremium extends Erabiltzailea {
	private Date premiumMuga;

	/**
	 * ErabiltzailePremium klasearen eraikitzailea. Erabiltzailearen datuak eta premium mugaren data
	 * emanda, ErabiltzailePremium objektua sortzen du.
	 *
	 * @param idErabiltzailea Erabiltzaile idea
	 * @param erabiltzailea Erabiltzailearen erabiltzaile izena
	 * @param pasahitza Erabiltzailearen pasahitza
	 * @param izena Erabiltzailearen izena
	 * @param abizena Erabiltzailearen abizena
	 * @param jaiotzeData Erabiltzailearen jaiotze data
	 * @param hizkuntza Erabiltzailearen hizkuntza
	 * @param premiumMuga ErabiltzailePremium-aren premium mugaren data
	 */
	
	public ErabiltzailePremium() {
		
	}
	
	public ErabiltzailePremium(int idErabiltzailea, String erabiltzailea, String pasahitza, String izena,
			String abizena, Date jaiotzeData, String hizkuntza, Date premiumMuga) {
		super(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, jaiotzeData, hizkuntza);
		this.premiumMuga = premiumMuga;
	}

	/**
	 * ErabiltzailePremium-aren premium mugaren data itzultzen du.
	 *
	 * @return ErabiltzailePremium-aren premium mugaren data
	 */
	public Date getPremiumMuga() {
		return premiumMuga;
	}

	/**
	 * ErabiltzailePremium-aren premium mugaren data ezartzen du.
	 *
	 * @param premiumMuga ErabiltzailePremium-aren premium mugaren data
	 */
	public void setPremiumMuga(Date premiumMuga) {
		this.premiumMuga = premiumMuga;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErabiltzailePremium other = (ErabiltzailePremium) obj;
		return Objects.equals(premiumMuga, other.premiumMuga);
	}
	
	
}
