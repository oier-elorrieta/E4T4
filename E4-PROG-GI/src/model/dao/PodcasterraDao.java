package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Podcasterra;
import model.sql.Kone;

public class PodcasterraDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	
	public static ResultSet getPodcasterEntzunaldiak() {

		Connection konexioa = Kone.konektatu();

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstatistikakAurkestuPodcasterraTotala";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
		return rs;

	}
	
	public static Podcasterra getPodcasterra(String izena) {
		Connection konexioa = Kone.konektatu();
		Podcasterra podcaster = null;
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Podcaster p INNER JOIN Artista a on p.IdArtista = a.IdArtista WHERE IzenArtistikoa='"
					+ izena + "'";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			podcaster = new Podcasterra(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"), rs.getBlob("a.Irudia"));
		} catch (SQLException e) {
			e.getMessage();

		}
		return podcaster;

	}
}
