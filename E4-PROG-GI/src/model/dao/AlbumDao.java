package model.dao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Abestia;
import model.Album;
import model.Audio;
import model.Musikaria;
import model.sql.Kone;




public class AlbumDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	/**
	 * Musikariaren albumak itzultzen dituen metodoa.
	 * 
	 * @param musikari Musikari objektua
	 * @return Album objektuen ArrayList bat
	 */
	public static ArrayList<Album> getAlbumakByMusikari(Musikaria musikari) {
		Connection konexioa = Kone.konektatu();
		ArrayList<Album> albumak = new ArrayList<Album>();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Album where IdArtista =" + musikari.getIdArtista() + "";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				albumak.add(new Album(rs.getInt("IdAlbum"), rs.getString("Izenburua"), rs.getString("Generoa"), rs.getBlob("Irudia")));
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return albumak;
	}
	
	/**
	 * Albumen kanta kopurua betetzen duen metodoa.
	 * 
	 * @param albumak Album objektuen ArrayList bat
	 */
	public static void beteAlbumakKantaKop(ArrayList<Album> albumak) {
		Connection konexioa = Kone.konektatu();
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
	
	public static Album getAlbumByAbesti(Audio audio) {
		Album albumAbestia = null;
		Connection konexioa = Kone.konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT al.IdAlbum, al.Izenburua, al.Generoa, al.Irudia  from Album al Inner join Abestia ab using (IdAlbum) inner join Audio au where au.IdAudio = " + audio.getIdAudio() + " and ab.IdAudio = " + audio.getIdAudio() + ";";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			albumAbestia = new Album(rs.getInt("al.IdAlbum"), rs.getString("al.Izenburua"), rs.getString("al.Generoa"), rs.getBlob("al.Irudia"));			
		} catch (SQLException e) {
			e.getMessage();
		}
		Kone.itxiConexioa();
		return albumAbestia;
	}
}
