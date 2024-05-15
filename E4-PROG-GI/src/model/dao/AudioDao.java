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

public class AudioDao {
	/**
	 * Aukeratutako PlayListaren abestiak itzultzen dituen metodoa.
	 * 
	 * @param aukeraPlaylist Aukeratutako PlayLista
	 * @return Abestiak ArrayList moduan
	 */
	public static ArrayList<Audio> getAbestiakByPlayList(PlayListak aukeraPlaylist) {
		ArrayList<Audio> abestiakList = new ArrayList<Audio>();
		Abestia abestia;

		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM PlaylistAbestiak pla INNER JOIN Audio au on pla.IdAudio = au.IdAudio where IdList = "
					+ aukeraPlaylist.getIdPlayList();
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				abestia = new Abestia(rs.getInt("au.IdAudio"), rs.getString("au.Izena"), rs.getTime("au.Iraupena"), rs.getBlob("au.Irudia"), false);
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
	 * Erregistratu erreprodukzioa datu-basean.
	 * 
	 * @param audio Erreprodukzioa
	 * @return True, erreprodukzioa ongi erregistratu da; False, errorea gertatu da
	 */
	public static boolean erregistratuErreprodukzioa(Audio audio) {
		int idBezero = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "INSERT into Erreprodukzioak (IdBezeroa, IdAudio, ErreData) VALUES(?,?,?)";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, idBezero);
			pstm.setInt(2, audio.getIdAudio());
			pstm.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			pstm.execute();
			konexioa.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}
	}
}
