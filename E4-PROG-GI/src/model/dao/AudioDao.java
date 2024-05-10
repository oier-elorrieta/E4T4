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
