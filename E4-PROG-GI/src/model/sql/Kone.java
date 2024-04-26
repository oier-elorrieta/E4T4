package model.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Abestia;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.PlayListak;
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
	
	public static boolean konektatuAdmin(String user, String pass) {
		boolean LoginOk = true;
		try {
			
			if (konexioa == null || konexioa.isClosed()) {
				konexioa = DriverManager.getConnection(url, user, pass);
			}
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

	public static void erregistratu(ErabiltzaileFree erab) {
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
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		itxiConexioa();
	}
	
	public static void erregistratuPremium(ErabiltzailePremium erab) {
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
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
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
			kontsulta = "SELECT * FROM Bezeroa b join Premium p where b.IdBezeroa = p.IdBezeroa and b.IdBezeroa = "
					+ id;
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				SesioAldagaiak.erabiltzaileLogeatutaPremium = new ErabiltzailePremium(rs.getInt("b.IdBezeroa"),
						rs.getString("b.Erabiltzailea"), rs.getString("b.Pasahitza"), rs.getString("b.Izena"),
						rs.getString("b.Abizena"), (java.util.Date) rs.getDate("JaiotzeData"),
						rs.getString("b.IdHizkuntza"), (java.util.Date) rs.getDate("p.IraungitzeData"));
			}
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

	public static ArrayList<PlayListak> getPlaylist() {
		ArrayList<PlayListak> playlistList = new ArrayList<PlayListak>();
		PlayListak playLista;
		int id = 0;

		konektatu();

		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Playlist where IdBezeroa = " + id;
			rs = stm.executeQuery(kontsulta);

			while (rs.next()) {
				playLista = new PlayListak(rs.getInt("IdList"), rs.getString("Izenburua"), rs.getDate("SorreraData"));
				playlistList.add(playLista);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return playlistList;
	}

	public static void playlistGehitu(String izenburua) {
		konektatu();
		int id = 0;
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}

		java.util.Date dataOrain = new java.util.Date();
		java.sql.Date sqlDataOrain = new java.sql.Date(dataOrain.getTime());

		kontsulta = "INSERT into Playlist(Izenburua, SorreraData, IdBezeroa) VALUES(?,?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, izenburua);
			pstm.setDate(2, sqlDataOrain);
			pstm.setInt(3, id);
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		itxiConexioa();
	}

	public static void playlistEzabatu(int idPlaylist) throws SQLException {
		konektatu();

		kontsulta = "DELETE FROM Playlist WHERE IdList = " + idPlaylist;
		stm.executeUpdate(kontsulta);

		itxiConexioa();
	}

	public static ArrayList<Abestia> getPlayListAbestiak(PlayListak aukeraPlaylist) {
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
			kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM PlaylistAbestiak pla INNER JOIN Audio au on pla.IdAudio = au.IdAudio where IdList = "
					+ aukeraPlaylist.getIdPlayList();
			rs = stm.executeQuery(kontsulta);
			
			while (rs.next()) {
				Abestia abestiaSartu = new Abestia(rs.getInt("au.IdAudio"), rs.getString("au.izena"),
						rs.getString("au.Iraupena"), rs.getBlob("au.Irudia"), false);
				abestiakList.add(abestiaSartu);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		itxiConexioa();
		return abestiakList;
	}
	
	public static void abestiPlaylistEzabatu(int idPlaylist, int idAbestia) throws SQLException {
		konektatu();

		kontsulta = "DELETE FROM PlaylistAbestiak WHERE IdList = " + idPlaylist + " AND IdAudio = " + idAbestia;
		stm.executeUpdate(kontsulta);

		itxiConexioa();
	}
}
