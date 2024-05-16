package model.sql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import com.mysql.cj.jdbc.Blob;
import model.Abestia;
import model.Album;
import model.Audio;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Erabiltzailea;
import model.Hizkuntza;
import model.Musikaria;
import model.PlayListak;
import model.Podcast;
import model.Podcasterra;
import model.SesioAldagaiak;

public class Kone {

	//private static String url = "jdbc:mysql://10.5.6.111:3306/Sphea";
	//private static String user = "erabiltzaile";
	//private static String pass = "4321";

	private static String url = "jdbc:mysql://localhost/Sphea";
	private static String user = "root";
	private static String pass = "";

	private static String userErabiltzailea;
	private static String passErabiltzailea;

	private static Connection konexioa = null;
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	private static String userAdmin;
	private static String passAdmin;

	/**
	 * Datu-basearekin konexioa egiteko metodoa.
	 * @return konexioa - datu-basearekin konexioa
	 */
	public static Connection konektatu() {
		try {
			// Konexioa sortu, oraindik ez badago
			if (konexioa == null || konexioa.isClosed()) {
				konexioa = DriverManager.getConnection(url, user, pass);
				stm = konexioa.createStatement();

			}
		} catch (SQLException e) {
			System.out.println("Errorea datu-basearekin konexioa egiten: " + e.getMessage());
		}
		return konexioa;
	}

	/**
	 * Erabiltzailearen erabiltzailea eta pasahitza erabiliz konektatu.
	 * @param user - erabiltzailea
	 * @param pass - pasahitza
	 * @return LoginOk - konexioa ondo egin den ala ez adierazten duen boolearra
	 */
	public static boolean konektatuAdminKomprobatu(String user, String pass) {
		boolean LoginOk = true;
		try {
			konexioa = DriverManager.getConnection(url, user, pass);
			userAdmin = user;
			passAdmin = pass;
			konexioa.close();
		} catch (SQLException e) {
			LoginOk = false;
		}
		
		return LoginOk;
	}
	
	public static Connection konektatuAdmin() {
		try {
			konexioa = DriverManager.getConnection(url, userAdmin, passAdmin);
		} catch (SQLException e) {
			
		}
		
		return konexioa;
	}
}
