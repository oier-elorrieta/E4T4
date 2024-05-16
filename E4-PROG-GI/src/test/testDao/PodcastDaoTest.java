package test.testDao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.Test;

import model.Audio;
import model.Podcast;
import model.Podcasterra;
import model.dao.PodcastDao;

public class PodcastDaoTest {

	@Test
	public void getPodcastakTest() throws SQLException {
		Podcasterra podcasterraTest = new Podcasterra(7, "IbaiLlanos");
		ArrayList<Audio> podcastakTest = PodcastDao.getPodcastak(podcasterraTest);

		Time time = new Time(0, 14, 12);
		Podcast audio = new Podcast(33, "Podcast Aitana", time, null);
		
		assertEquals(podcastakTest.get(0), audio);
	}

	@Test
	public void getPodcastListTest() throws SQLException {
		Time time = new Time(1,21,2);
		Podcast audio = new Podcast(31, "Podcast Ibai Llanos", time , null);
		ArrayList<Audio> audioakTest = PodcastDao.getPodcastList("Jordi Wild");
	
		
		assertEquals(audio, audioakTest.get(0));
	}
	
}