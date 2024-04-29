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

import com.mysql.cj.jdbc.Blob;
import model.Abestia;
import model.Album;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
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
	public static void konektatu() {
		try {
			// Konexioa sortu, oraindik ez badago
			if (konexioa == null || konexioa.isClosed()) {
				konexioa = DriverManager.getConnection(url, user, pass);
				stm = konexioa.createStatement();
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
		try {
			stm = konexioa.createStatement();
			// Por comprobar
			kontsulta = "SELECT Erabiltzailea FROM Bezeroa where(Erabiltzailea = ?);";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
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
						rs.getString("b.Abizena"), rs.getDate("JaiotzeData"),
						rs.getString("b.IdHizkuntza"), rs.getDate("p.IraungitzeData"));
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
	
	public static ResultSet getPodcasterEntzunaldiak() {

		konektatu();

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstatistikakAurkestuPodcasterraTotala";
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
			java.util.Date d = new java.util.Date();
			PlayListak playlistGustokoena = new PlayListak(0, "Gustokoena", d);
			playlistList.add(playlistGustokoena);
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
			
			if (aukeraPlaylist.getIdPlayList() == 0) {
				kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM Gustokoak g join Audio au using (IdAudio) where IdBezeroa = "
						+ id;
			} else {
				kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM PlaylistAbestiak pla INNER JOIN Audio au on pla.IdAudio = au.IdAudio where IdList = "
						+ aukeraPlaylist.getIdPlayList();
			}
			rs = stm.executeQuery(kontsulta);

			while (rs.next()) {
				Abestia abestiaSartu = new Abestia(rs.getInt("au.IdAudio"), rs.getString("au.Izena"),
						rs.getTime("au.Iraupena"), rs.getBlob("au.Irudia"), false);
				abestiakList.add(abestiaSartu);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		itxiConexioa();
		return abestiakList;
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

	public static ArrayList<Album> getAlbumak(Musikaria musikari) {
		konektatu();
		ArrayList<Album> albumak = new ArrayList<Album>();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Album where IdArtista =" + musikari.getIdArtista() + "";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				albumak.add(new Album(rs.getInt("IdAlbum"), rs.getString("Izenburua"), rs.getString("Generoa"),
						(Blob) rs.getBlob("Irudia")));
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return albumak;
	}

	public static Musikaria getMusikaria(String izena) {

		konektatu();
		Musikaria musikari = null;

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Musikaria m INNER JOIN Artista a on m.IdArtista = a.IdArtista WHERE IzenArtistikoa='" + izena + "'";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			musikari = new Musikaria(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"),rs.getBlob("a.Irudia"), rs.getString("m.Ezaugarria"));
		} catch (SQLException e) {
			e.getMessage();

		}
		return musikari;

	}
	
	public static Podcasterra getPodcasterra(String izena) {
		konektatu();
		Podcasterra podcaster = null;
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Podcaster p INNER JOIN Artista a on p.IdArtista = a.IdArtista WHERE IzenArtistikoa='" + izena + "'";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			podcaster = new Podcasterra(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"), (Blob) rs.getBlob("a.Irudia"));
		} catch (SQLException e) {
			e.getMessage();

		}
		return podcaster;

	}
	
	public static ArrayList<Podcast> getPodcastak(Podcasterra podcaster){
		ArrayList<Podcast> podcastList = new ArrayList<Podcast>();
		
		konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "select * from Audio a inner join Podcast p using (IdAudio) where IdArtista = "+ podcaster.getIdArtista();
			rs = stm.executeQuery(kontsulta);
			
			while (rs.next()) {
				Podcast podcast = new Podcast(rs.getInt("a.IdAudio"), rs.getString("a.Izena"), rs.getTime("a.Iraupena"), rs.getBlob("a.Irudia"));
				podcastList.add(podcast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return podcastList;
	}

	public static ArrayList<Abestia> getAbestiak(int idAlbum) {
		konektatu();
		try {
			ArrayList<Abestia> abestiak = new ArrayList<Abestia>();
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Abestia join Audio using(IdAudio) where IdAlbum = '" + idAlbum + "'";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				abestiak.add(new Abestia(rs.getInt("IdAudio"), rs.getString("Izena"), rs.getTime("Iraupena")));
			}
			return abestiak;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	public static void beteAlbumakKantaKop(ArrayList<Album> albumak) {
		konektatu();
		for (Album i : albumak) {
			try {
				stm = konexioa.createStatement();
				kontsulta = "SELECT count(IdAudio) FROM Abestia where IdAlbum =" + i.getId() + "";
				rs = stm.executeQuery(kontsulta);
				rs.next();
				i.setKantaKop(rs.getInt("count(IdAudio)"));
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}

	public static void abestiPlaylistEzabatu(int idPlaylist, int idAbestia) throws SQLException {
		konektatu();
		kontsulta = "DELETE FROM PlaylistAbestiak WHERE IdList = " + idPlaylist + " AND IdAudio = " + idAbestia;
		stm.executeUpdate(kontsulta);
		itxiConexioa();
	}
	
	public static void abestiGuztokoaEzabatu(int idAbestia) throws SQLException {
		
		int id = 0;
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}
		
		konektatu();
		kontsulta = "DELETE FROM Gustokoak WHERE IdBezeroa = " + id + " AND IdAudio = " + idAbestia;
		stm.executeUpdate(kontsulta);
		itxiConexioa();
	}
}
