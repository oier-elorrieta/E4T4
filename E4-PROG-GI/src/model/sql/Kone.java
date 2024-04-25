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
			kontsulta = "SELECT IdHizkuntza FROM Hizkuntza";
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
			pstm.setDate(5, (Date) erab.getJaiotzeData());
			pstm.setString(6, erab.getHizkuntza());
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		itxiConexioa();
	}

	public static ResultSet isLoginaOk(String erabiltzailea){
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT Erabiltzailea, Pasahitza, IdBezeroa, Mota FROM Bezeroa WHERE Erabiltzailea = '"+erabiltzailea+"'";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
		return rs;
		
	}

	public static void kargatuErabiltzaileFree(int id) {
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Bezeroa WHERE IdBezeroa = " + id;
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				SesioAldagaiak.erabiltzaileLogeatutaFree = new ErabiltzaileFree(rs.getInt("IdBezeroa"),rs.getString("Erabiltzailea"),
						rs.getString("Pasahitza"), rs.getString("Izena"), rs.getString("Abizena"),
						rs.getDate("JaiotzeData"), rs.getString("IdHizkuntza"));
			}

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void kargatuErabiltzailePremium(int id) {
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Bezeroa b join premium p where b.IdBezeroa = p.IdBezeroa and b.IdBezeroa = "
					+ id;
			rs = stm.executeQuery(kontsulta);
			SesioAldagaiak.erabiltzaileLogeatutaPremium = new ErabiltzailePremium(rs.getInt("IdBezeroa"),rs.getString("b.Erabiltzailea"),
					rs.getString("b.Pasahitza"), rs.getString("b.Izena"), rs.getString("b.Abizena"),
					rs.getDate("b.JaiotzeData"), rs.getString("b.IdHizkuntza"), rs.getDate("p.IraungitzeData"));
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
	
	}
	
	public static ResultSet getMusikariakEntzunaldiak() {
		
		konektatu();
		
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstatistikakAurkestuMusikariaTotala";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
		return rs;
		
	}
	
	

}
