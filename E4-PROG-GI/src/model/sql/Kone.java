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
import model.Musikaria;
import model.PlayListak;
import model.Podcast;
import model.Podcasterra;
import model.SesioAldagaiak;

public class Kone {

	private static String url = "jdbc:mysql://10.5.6.111:3306/Sphea";
	private static String user = "erabiltzaile";
	private static String pass = "4321";

	private static String userErabiltzailea;
	private static String passErabiltzailea;

	private static Connection konexioa = null;
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;

	// Datu-basearekin konexioa egiteko metodoa
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

	public static boolean konektatuAdmin(String user, String pass) {
		boolean LoginOk = true;
		try {
			konexioa = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			LoginOk = false;
		}
		
		return LoginOk;
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

	public static boolean erregistratu(ErabiltzaileFree erab) {
		konektatu();
		kontsulta = "INSERT into Bezeroa(Izena,Abizena,Erabiltzailea,Pasahitza,JaiotzeData,IdHizkuntza) VALUES(?,?,?,?,?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, erab.getIzena());
			pstm.setString(2, erab.getAbizena());
			pstm.setString(3, erab.getErabiltzailea());
			pstm.setString(4, erab.getPasahitza());
			pstm.setDate(5, (java.sql.Date) erab.getJaiotzeData());
			pstm.setString(6, erab.getHizkuntza());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
			
		}

	}

	public static void eguneratuErabiltzailea(Erabiltzailea erab) {
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "UPDATE Bezeroa"
					+ "	SET Izena = ?, Abizena = ?, Erabiltzailea = ?, Pasahitza = ?, JaiotzeData = ?, IdHizkuntza = ?"
					+ "	WHERE IdBezeroa = ?;";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, erab.getIzena());
			pstm.setString(2, erab.getAbizena());
			pstm.setString(3, erab.getErabiltzailea());
			pstm.setString(4, erab.getPasahitza());
			pstm.setDate(5, new java.sql.Date(erab.getJaiotzeData().getTime()));
			pstm.setString(6, erab.getHizkuntza());
			pstm.setInt(7, SesioAldagaiak.logErabiltzailea.getIdErabiltzailea());
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		itxiConexioa();
	}

	public static void erregistratuPremium(int id, java.sql.Date iranD) {
		konektatu();
		try {
			stm = konexioa.createStatement();
			// Zaiatu Premium bezala ezartzen berria bada
			kontsulta = "INSERT into Premium values(?, ?);";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, id);
			pstm.setDate(2, iranD);
			pstm.execute();
		} catch (SQLException e) {
			try {
				kontsulta = "UPDATE Premium SET IraungitzeData = ? WHERE IdBezeroa = ?;";
				pstm = konexioa.prepareStatement(kontsulta);
				pstm.setDate(1, iranD);
				pstm.setInt(2, id);
				pstm.execute();
			} catch (SQLException i) {
				System.out.println("Kontsulta txarto" + e.getMessage());
			}
		}
		try {
			kontsulta = "UPDATE Bezeroa SET Mota = ? WHERE IdBezeroa = ?;";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, "Premium");
			pstm.setInt(2, id);
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Ezin izan da Premium ezarri " + e.getMessage());
		}

		itxiConexioa();
	}

	public static ResultSet isLoginaOk(String erabiltzailea) {
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT Erabiltzailea, Pasahitza, IdBezeroa, Mota FROM Bezeroa WHERE Erabiltzailea = '"
					+ erabiltzailea + "'";
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
				SesioAldagaiak.erabiltzaileLogeatutaFree = new ErabiltzaileFree(rs.getInt("IdBezeroa"),
						rs.getString("Erabiltzailea"), rs.getString("Pasahitza"), rs.getString("Izena"),
						rs.getString("Abizena"), rs.getDate("JaiotzeData"), rs.getString("IdHizkuntza"));
			}

		} catch (SQLException e) {
			e.getMessage();
		}

	}

	public static void kargatuErabiltzailePremium(int id) {
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Bezeroa b join Premium p where b.IdBezeroa = p.IdBezeroa and b.IdBezeroa = "
					+ id;
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				SesioAldagaiak.erabiltzaileLogeatutaPremium = new ErabiltzailePremium(rs.getInt("b.IdBezeroa"),
						rs.getString("b.Erabiltzailea"), rs.getString("b.Pasahitza"), rs.getString("b.Izena"),
						rs.getString("b.Abizena"), rs.getDate("JaiotzeData"), rs.getString("b.IdHizkuntza"),
						rs.getDate("p.IraungitzeData"));
			}
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	public static ArrayList<Abestia> getAbestiGustokoak() {
		ArrayList<Abestia> abestiakList = new ArrayList<Abestia>();
		Abestia abestia;

		int id = 0;

		konektatu();

		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT a.IdAudio, a.Izena, a.Iraupena, a.Irudia FROM Gustokoak g join Audio a using (IdAudio) where IdBezeroa = "
					+ id;
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				Abestia abestiaSartu = new Abestia(rs.getInt("a.IdAudio"), rs.getString("a.izena"),
						rs.getTime("a.Iraupena"), rs.getBlob("a.Irudia"), true);
				abestiakList.add(abestiaSartu);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		itxiConexioa();
		return abestiakList;
	}
}
