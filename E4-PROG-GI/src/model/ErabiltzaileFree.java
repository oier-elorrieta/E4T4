package model;

import java.util.Date;

/**
 * Klase honek Erabiltzailea klasearen luzapena du, eta ErabiltzaileFree motako erabiltzaileak
 * errepresentatzen ditu. ErabiltzaileFree-ek erabiltzailearen izena, pasahitza, izena, abizena,
 * jaiotze data eta hizkuntza dituzten atributuak dituzte.
 */
public class ErabiltzaileFree extends Erabiltzailea {

	public ErabiltzaileFree(int idErabiltzailea, String erabiltzailea, String pasahitza, String izena, String abizena,
			Date jaiotzeData, String hizkuntza) {
		super(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, jaiotzeData, hizkuntza);
		// TODO Auto-generated constructor stub
	}
	/**
	 * ErabiltzaileFree klasearen eraikitzailea. Erabiltzailearen atributuak jasotzen ditu eta
	 * Erabiltzailea klasearen eraikitzaileari deitzen dio.
	 *
	 * @param idErabiltzailea erabiltzailearen id-a
	 * @param erabiltzailea   erabiltzailearen izena
	 * @param pasahitza       erabiltzailearen pasahitza
	 * @param izena           erabiltzailearen izena
	 * @param abizena         erabiltzailearen abizena
	 * @param jaiotzeData     erabiltzailearen jaiotze data
	 * @param hizkuntza       erabiltzailearen hizkuntza
	 */
	
	
}
