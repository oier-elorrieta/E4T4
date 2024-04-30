package model.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Album;
import model.Musikaria;
import model.sql.Kone;

public class AlbumDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	public static ArrayList<Album> getAlbumak(Musikaria musikari) {
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
}
