package model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Podcasterra;
import model.sql.Kone;



public class PodcasterraDao {
	
	/**
	 * Emandako kontsulta erabiliz, podcasterraren entzunaldi guztiak itzultzen ditu.
	 * 
	 * @return Entzunaldi guztiak itzultzen dituen ResultSet objektua.
	 */
	public static ArrayList<Podcasterra> getPodcasterEntzunaldiak() {
		ArrayList<Podcasterra> podcasterrak = new ArrayList<Podcasterra>();
		Podcasterra podcasterraSartu;
			
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstatistikakAurkestuPodcasterraTotala";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				podcasterraSartu = new Podcasterra(rs.getString("Izena"), rs.getBlob("Irudia"), rs.getInt("Totala"));
				podcasterrak.add(podcasterraSartu);
			}
			konexioa.close();
			return podcasterrak;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
		

	}
	
	/**
	 * Emandako izenaren arabera, podcasterra bat itzultzen du.
	 * 
	 * @param izena Podcasterra izena
	 * @return Podcasterra objektua
	 */
	public static Podcasterra getPodcasterra(String izena) {
		
		Podcasterra podcaster = null;
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Podcaster p INNER JOIN Artista a on p.IdArtista = a.IdArtista WHERE IzenArtistikoa='"
					+ izena + "'";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			podcaster = new Podcasterra(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"), rs.getBlob("a.Irudia"));
			konexioa.close();
			return podcaster;
		} catch (SQLException e) {
			e.getMessage();
			return null;

		}
		
	}
}
