package model;

import javax.swing.JButton;

import model.metodoak.ViewMetodoak;

/**
 * Klase honek SesioAldagaiak klasearen erabiltzaile logeatuak gordetzeko aldagaiei buruzko informazioa gordetzen du.
 */

public class SesioAldagaiak {
	public static Erabiltzailea logErabiltzailea = null;
	public static ErabiltzaileFree erabiltzaileLogeatutaFree = null;
	public static ErabiltzailePremium erabiltzaileLogeatutaPremium = null;
	public static boolean erabiltzailePremium;
	public static JButton jb = null;
	public static boolean doSkip = true;
	public static boolean iragarkiaAtera = true;
	public static int erreprodukzioKop = 0;
}
