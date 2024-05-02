package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Audio;
import model.Podcast;
import model.Podcasterra;
import model.sql.Kone;

public class PodcastDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	public static ArrayList<Audio> getPodcastak(Podcasterra podcaster) {
		
		
		ArrayList<Audio> podcastList = new ArrayList<Audio>();

		Connection konexioa = Kone.konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "select * from Audio a inner join Podcast p using (IdAudio) where IdArtista = "
					+ podcaster.getIdArtista();
			rs = stm.executeQuery(kontsulta);

			while (rs.next()) {
				Podcast podcast = new Podcast(rs.getInt("a.IdAudio"), rs.getString("a.Izena"), rs.getTime("a.Iraupena"),
						rs.getBlob("a.Irudia"));
				podcastList.add(podcast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return podcastList;
	}
}
