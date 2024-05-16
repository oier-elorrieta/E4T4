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

		ArrayList<Audio> podcastakTest = PodcastDao.getPodcastak(podcasterraTest);

		Time time = new Time(0, 14, 12);
		Podcast audio = new Podcast(33, "Podcast Aitana", time, null);
		
		assertEquals(podcastakTest.get(0), audio);
	}

}