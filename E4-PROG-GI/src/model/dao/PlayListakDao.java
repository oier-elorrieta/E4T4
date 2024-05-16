package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Abestia;
import model.Audio;
import model.PlayListak;
import model.SesioAldagaiak;
import model.sql.Kone;

public class PlayListakDao {
	/**
	 * Erabiltzailearen playlist-ak itzultzen dituen metodoa.
	 * 
	 * @return Erabiltzailearen playlist-ak ArrayList<PlayListak> moduan itzultzen
	 *         ditu.
	 */
	public static ArrayList<PlayListak> getPlaylist() {
		ArrayList<PlayListak> playlistList = new ArrayList<PlayListak>();
		Date date = new Date();
		PlayListak playLista = new PlayListak(0, "Guztokoak", date);
		playlistList.add(playLista);
		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Playlist where IdBezeroa = " + id;
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				playLista = new PlayListak(rs.getInt("IdList"), rs.getString("Izenburua"), rs.getDate("SorreraData"));
				playlistList.add(playLista);
			}
			konexioa.close();
			return playlistList;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}

	/**
	 * Playlist bati abesti bat gehitzeko metodoa.
	 * 
	 * @param izenburua Gehitu nahi den abestiaren izenburua.
	 */
	public static boolean playlistGehitu(String izenburua) {

		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		java.util.Date dataOrain = new java.util.Date();
		java.sql.Date sqlDataOrain = new java.sql.Date(dataOrain.getTime());

		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "INSERT into Playlist(Izenburua, SorreraData, IdBezeroa) VALUES(?,?,?)";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, izenburua);
			pstm.setDate(2, sqlDataOrain);
			pstm.setInt(3, id);
			pstm.execute();
			konexioa.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}

	}

	/**
	 * Playlist bat ezabatzeko metodoa.
	 * 
	 * @param idPlaylist Ezabatu nahi den playlist-aren identifikadorea.
	 * @throws SQLException SQL errore bat gertatu bada.
	 */
	public static boolean playlistEzabatu(int idPlaylist) {
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "DELETE FROM Playlist WHERE IdList = " + idPlaylist;
			stm.executeUpdate(kontsulta);
			konexioa.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/**
	 * Playlist bateko abesti bat ezabatzeko metodoa.
	 * 
	 * @param idPlaylist Playlist-aren identifikadorea.
	 * @param idAbestia  Ezabatu nahi den abestiaren identifikadorea.
	 * @throws SQLException SQL errore bat gertatu bada.
	 */
	public static boolean abestiPlaylistEzabatu(int idPlaylist, int idAbestia) {
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "DELETE FROM PlaylistAbestiak WHERE IdList = " + idPlaylist + " AND IdAudio = "
					+ idAbestia;
			stm.executeUpdate(kontsulta);
			konexioa.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * Erabiltzailearen aukeratutako playlist-aren abestiak itzultzen dituen
	 * metodoa.
	 * 
	 * @param aukeraPlaylist Aukeratutako playlist objektua.
	 * @return Aukeratutako playlist-aren abestiak ArrayList<Audio> moduan itzultzen
	 *         ditu.
	 */
	public static ArrayList<Audio> getPlayListAbestiak(PlayListak aukeraPlaylist) {
		ArrayList<Audio> abestiakList = new ArrayList<Audio>();
		Abestia abestia;
		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();

			String kontsulta;
			if (aukeraPlaylist.getIdPlayList() == 0) {
				kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM Gustokoak g join Audio au using (IdAudio) where IdBezeroa = "
						+ id;
			} else
				kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM PlaylistAbestiak pla INNER JOIN Audio au on pla.IdAudio = au.IdAudio where IdList = "
						+ aukeraPlaylist.getIdPlayList();

			ResultSet rs = stm.executeQuery(kontsulta);

			while (rs.next()) {
				abestia = new Abestia(rs.getInt("au.IdAudio"), rs.getString("au.Izena"), rs.getTime("au.Iraupena"),
						rs.getBlob("au.Irudia"), false);
				abestiakList.add(abestia);
			}
			konexioa.close();
			return abestiakList;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}

	/**
	 * Abestia aukeratutako playlist-ean gehitzeko metodoa.
	 * 
	 * @param playlist Aukeratutako playlist objektua.
	 * @param audio    Gehitu nahi den abestiaren objektua.
	 * @return True, abestia ongi gehitu da. False, abestia ez da gehitu.
	 */
	public static boolean playlisteanAbestiaGehitu(PlayListak playlist, Audio audio) {

		java.util.Date dataOrain = new java.util.Date();
		java.sql.Date sqlDataOrain = new java.sql.Date(dataOrain.getTime());

		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "INSERT into PlaylistAbestiak(IdList, IdAudio, PData) VALUES(?,?,?)";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, playlist.getIdPlayList());
			pstm.setInt(2, audio.getIdAudio());
			pstm.setDate(3, sqlDataOrain);
			pstm.execute();
			konexioa.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}

	}

	/**
	 * Abestia aukeratutako playlist-ean dagoen ala ez egiaztatzeko metodoa.
	 * 
	 * @param playlist Aukeratutako playlist objektua.
	 * @param audio    Egiaztatu nahi den abestiaren objektua.
	 * @return True, abestia aukeratutako playlist-ean dago. False, abestia ez dago
	 *         aukeratutako playlist-ean.
	 */
	public static boolean komprobatuAbestiaBadago(PlayListak playlist, Audio audio) {
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "select count(*) as cont from PlaylistAbestiak where IdAudio = " + audio.getIdAudio()
					+ " and IdList = " + playlist.getIdPlayList() + ";";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			if (rs.getInt("cont") != 0) {
				return true;
			}
			konexioa.close();
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
		return false;
	}

	/**
	 * Izenarekin playlist bat lortzeko metodoa.
	 * 
	 * @param izena Playlist-aren izena.
	 * @return Izenarekin lortutako playlist objektua.
	 */
	public static PlayListak getPlayListIzenarekin(String izena) {
		PlayListak playlista = null;
		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "Select * from Playlist where Izenburua='" + izena + "' ORDER BY IdList desc LIMIT 1";
			Statement stm = konexioa.createStatement();
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				playlista = new PlayListak(rs.getInt("IdList"), rs.getString("Izenburua"), rs.getDate("SorreraData"));
			}
			konexioa.close();
			return playlista;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return null;
		}
	}
}
