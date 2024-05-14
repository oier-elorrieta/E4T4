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
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;

	/**
	 * Aukeratutako PlayListaren abestiak itzultzen dituen metodoa.
	 * 
	 * @param aukeraPlaylist Aukeratutako PlayLista
	 * @return Abestiak ArrayList moduan
	 */
	public static ArrayList<Audio> getAbestiakByPlayList(PlayListak aukeraPlaylist) {
		ArrayList<Audio> abestiakList = new ArrayList<Audio>();
		Abestia abestia;
		int id = 0;

		Connection konexioa = Kone.konektatu();

		id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT au.IdAudio, au.Izena, au.Iraupena, au.Irudia FROM PlaylistAbestiak pla INNER JOIN Audio au on pla.IdAudio = au.IdAudio where IdList = "
					+ aukeraPlaylist.getIdPlayList();

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

	public static boolean erregistratuErreprodukzioa(Audio audio) {

		int idBezero;

		idBezero = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Connection konexioa = Kone.konektatu();
			kontsulta = "INSERT into Erreprodukzioak (IdBezeroa, IdAudio, ErreData) VALUES(?,?,?)";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, idBezero);
			pstm.setInt(2, audio.getIdAudio());
			pstm.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			pstm.execute();
			Kone.itxiConexioa();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}
		return true;
	}

}
