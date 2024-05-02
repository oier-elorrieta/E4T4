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
	
	public static void playlistEzabatu(int idPlaylist) throws SQLException {
		Connection konexioa = Kone.konektatu();

		kontsulta = "DELETE FROM Playlist WHERE IdList = " + idPlaylist;
		stm.executeUpdate(kontsulta);

		Kone.itxiConexioa();
	}
	
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
	
	
}
