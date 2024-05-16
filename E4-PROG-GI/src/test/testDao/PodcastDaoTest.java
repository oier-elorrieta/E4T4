package test.testDao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Audio;
import model.Podcast;
import model.Podcasterra;
import model.dao.PodcastDao;
import model.dao.PodcasterraDao;
import model.sql.Kone;

public class PodcastDaoTest {
	
    @Test
    public void getPodcastakTest() throws SQLException {
    	Podcasterra podcasterraTest = new Podcasterra(7, "IbaiLlanos");
    	int zenbatPodcast = 0;
    	
    	Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "select count(*) as zbk from Audio a inner join Podcast p using (IdAudio) where IdArtista = "
				+ podcasterraTest.getIdArtista();
		ResultSet rs = stm.executeQuery(kontsulta);

		rs.next();
		zenbatPodcast = rs.getInt("zbk");
		konexioa.close();
		
    	ArrayList<Audio> podcastakTest  = PodcastDao.getPodcastak(podcasterraTest);
    	
    	assertEquals(zenbatPodcast, podcastakTest.size());
    }
    
    
}