package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Audio;
import model.Podcast;
import model.Podcasterra;
import model.sql.Kone;

/**
 * Podcast-ak lortzeko metodoa.
 * 
 * @param podcaster Podcast-ak lortzeko erabiltzen den podcaster objektua.
 * @return podcast-ak ArrayList moduan itzultzen ditu.
 */
public class PodcastDao {
	/**
	 * Podcast-ak lortzeko metodoa.
	 * 
	 * @param podcaster Podcast-ak lortzeko erabiltzen den podcaster objektua.
	 * @return podcast-ak ArrayList moduan itzultzen ditu.
	 */
	public static ArrayList<Audio> getPodcastak(Podcasterra podcaster) {
		ArrayList<Audio> podcastList = new ArrayList<Audio>();
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "select * from Audio a inner join Podcast p using (IdAudio) where IdArtista = "
					+ podcaster.getIdArtista();
			ResultSet rs = stm.executeQuery(kontsulta);

			while (rs.next()) {
				Podcast podcast = new Podcast(rs.getInt("a.IdAudio"), rs.getString("a.Izena"), rs.getTime("a.Iraupena"),
						rs.getBlob("a.Irudia"));
				podcastList.add(podcast);
			}
			konexioa.close();
			return podcastList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Metodo honek podcasterraren abestiak lortzen ditu eta ArrayList bat itzultzen
	 * du.
	 *
	 * @param izena Podcasterraren izena.
	 * @return Podcasterraren abestiak dituen ArrayList bat.
	 */
	
	public static ArrayList<Audio> getPodcastList(String izena) {
		ArrayList<Audio> podcastList = new ArrayList<Audio>();
		Podcasterra podcaster = PodcasterraDao.getPodcasterra(izena);
		podcastList = getPodcastak(podcaster);
		return podcastList;
	}
}
