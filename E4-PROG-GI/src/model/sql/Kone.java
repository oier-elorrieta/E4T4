package model.sql;

import java.sql.Connection;
import model.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Random;

public class Kone {

	private static String url = "jdbc:mysql://10.5.6.111:3306/Sphea";
	private static String user = "admin";
	private static String pass = "headmin";
	private static Connection konexioa = null;
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;

	// Datu-basearekin konexioa egiteko metodoa
	public static void konektatu() {
		try {
			// Konexioa sortu, oraindik ez badago
			if (konexioa == null || konexioa.isClosed()) {
				konexioa = DriverManager.getConnection(url, user, pass);
				System.out.println("Konektatuta!!!");
			}
		} catch (SQLException e) {
			System.out.println("Errorea datu-basearekin konexioa egiten: " + e.getMessage());
		}
		// return konexioa;
	}

	public static void itxiConexioa() {
		try {
			if (stm != null || !stm.isClosed()) {
				stm.close();
			}
			
			konexioa.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static ResultSet hizkuntzakAtera() {
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT Deskribapena FROM Hizkuntza";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
		return rs;
	} 
	 

	public static void erregistratu(ErabiltzaileFree erab) {
		konektatu();
		kontsulta = "INSERT into Bezeroa(Izena,Abizena,Erabiltzailea,Pasahitza,JaiotzeData,IdHizkuntza) VALUES(?,?,?,?,?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, erab.getIzena());
			pstm.setString(2, erab.getAbizena());
			pstm.setString(3, erab.getErabiltzailea());
			pstm.setString(4, erab.getPasahitza());
			pstm.setString(5, erab.getJaiotzeData());
			pstm.setString(6, erab.getHizkuntza());
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		itxiConexioa();
	}
	
	public static boolean isLoginaOk(String erabiltzailea,String mota){
		konektatu();
		kontsulta = "SELECT erabiltzailea FROM bezeroa WHERE erabiltzailea = "+erabiltzailea+" ";
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT Deskribapena FROM Hizkuntza";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
	
		
	}
	
}
