package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.Podcasterra;
import model.dao.PodcasterraDao;
import model.sql.Kone;

public class PodcasterraDaoTest {

    @Test
    public void getPodcasterraTest() {
    	Podcasterra podcasterTest1 = null;
    	Podcasterra podcasterTest2 = null;
    	
    	Connection konexioa = Kone.konektatu();
    	try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Podcaster p INNER JOIN Artista a on p.IdArtista = a.IdArtista WHERE IzenArtistikoa='Ibai Llanos'";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			podcasterTest1 = new Podcasterra(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"), rs.getBlob("a.Irudia"));
			konexioa.close();
		} catch (SQLException e) {
			e.getMessage();
		}
    	
    	podcasterTest2 = PodcasterraDao.getPodcasterra("Ibai Llanos");
    	
    	assertEquals(podcasterTest1, podcasterTest2);
    }
}