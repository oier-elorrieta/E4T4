package model.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Abestia;
import model.Audio;
import model.PlayListak;
import model.SesioAldagaiak;
import model.sql.Kone;


public class PlayListakDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	/**
	 * Erabiltzailearen playlist-ak itzultzen dituen metodoa.
	 * 
	 * @return Erabiltzailearen playlist-ak ArrayList<PlayListak> moduan itzultzen ditu.
	 */
	public static ArrayList<PlayListak> getPlaylist() {
		ArrayList<PlayListak> playlistList = new ArrayList<PlayListak>();
		PlayListak playLista;
		int id = 0;

		Connection konexioa = Kone.konektatu();

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
	
	/**
	 * Playlist bati abesti bat gehitzeko metodoa.
	 * 
	 * @param izenburua Gehitu nahi den abestiaren izenburua.
	 */
	public static void playlistGehitu(String izenburua) {

		Connection konexioa = Kone.konektatu();

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

		Kone.itxiConexioa();
	}
	
	/**
	 * Playlist bat ezabatzeko metodoa.
	 * 
	 * @param idPlaylist Ezabatu nahi den playlist-aren identifikadorea.
	 * @throws SQLException SQL errore bat gertatu bada.
	 */
	public static void playlistEzabatu(int idPlaylist) throws SQLException {
		Connection konexioa = Kone.konektatu();

		kontsulta = "DELETE FROM Playlist WHERE IdList = " + idPlaylist;
		stm.executeUpdate(kontsulta);

		Kone.itxiConexioa();
	}
	
	/**
	 * Playlist bateko abesti bat ezabatzeko metodoa.
	 * 
	 * @param idPlaylist Playlist-aren identifikadorea.
	 * @param idAbestia Ezabatu nahi den abestiaren identifikadorea.
	 * @throws SQLException SQL errore bat gertatu bada.
	 */
	public static void abestiPlaylistEzabatu(int idPlaylist, int idAbestia) throws SQLException {
		Connection konexioa = Kone.konektatu();
		kontsulta = "DELETE FROM PlaylistAbestiak WHERE IdList = " + idPlaylist + " AND IdAudio = " + idAbestia;
		stm.executeUpdate(kontsulta);
		Kone.itxiConexioa();
	}
	

	
	public static ArrayList<Audio> getPlayListAbestiak(PlayListak aukeraPlaylist) {
		ArrayList<Audio> abestiakList = new ArrayList<Audio>();
		Abestia abestia;
		int id = 0;

		Connection konexioa = Kone.konektatu();

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
		Kone.itxiConexioa();
		return abestiakList;
	}
	
	

	public static void playlisteanAbestiaGehitu(PlayListak playlist, Audio audio) {

		Connection konexioa = Kone.konektatu();

		java.util.Date dataOrain = new java.util.Date();
		java.sql.Date sqlDataOrain = new java.sql.Date(dataOrain.getTime());

		kontsulta = "INSERT into PlaylistAbestiak(IdList, IdAudio, PData) VALUES(?,?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, playlist.getIdPlayList());
			pstm.setInt(2, audio.getIdAudio());
			pstm.setDate(3, sqlDataOrain);
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}

		Kone.itxiConexioa();
	}
	

	public static boolean komprobatuAbestiaBadago(PlayListak playlist, Audio audio) {
		boolean badago = false;
		Connection konexioa = Kone.konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "select count(*) as cont from PlaylistAbestiak where IdAudio = " + audio.getIdAudio() + " and IdList = " + playlist.getIdPlayList() + ";";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			if (rs.getInt("cont") != 0) {
				badago = true;
			}			
		} catch (SQLException e) {
			e.getMessage();
		}
		Kone.itxiConexioa();
		return badago;
	}

	public static int getPlayListIzenarekin(String izena) {
		int idList = 0;
		Connection konexioa = Kone.konektatu();
		kontsulta = "Select  IdList from Playlist where Izenburua='"+izena+"' ORDER BY IdList desc LIMIT 1";
		try {
			stm = konexioa.createStatement();
			rs = stm.executeQuery(kontsulta);
			rs.next();
			idList = rs.getInt("IdList");
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		
		return idList;
		
	}

}
