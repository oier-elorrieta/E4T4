package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Audio;
import model.Podcast;
import model.Podcasterra;
import model.dao.PodcastDao;
import model.dao.PodcasterraDao;

public class PodcastDaoTest {
	

	private static Podcasterra podcaster = null;
	private static ArrayList<Audio> result;
	
	@BeforeClass
	public static void setup() {
		podcaster = PodcasterraDao.getPodcasterra("Ibai Llanos");
		result = PodcastDao.getPodcastak(podcaster);
	}

    @Test
    public void testGetPodcastak1() throws SQLException {
        assertEquals(2, result.size());

    }
    @Test
    public void testGetPodcastak2() throws SQLException {
        assertEquals(9, result.get(0).getIdAudio());
    }
    @Test
    public void testGetPodcastak3() throws SQLException {
    	String izena = result.get(0).getIzena();
    	
        assertEquals("Podcast Aitana", izena);
    }
    @Test
    public void testGetPodcastak4() throws SQLException {
        assertEquals(Time.valueOf("00:14:12"), result.get(0).getIraupena());
    }
    @Test
    public void testGetPodcastak5() throws SQLException {
        assertNotNull(result.get(0).getIrudia());
    }
    @Test
    public void testGetPodcastak6() throws SQLException {
        assertEquals(10, result.get(1).getIdAudio());
    }
    @Test
    public void testGetPodcastak7() throws SQLException {
    	String izena = result.get(1).getIzena();
        assertEquals("Podcast AuronPlay", izena);
    }
    @Test
    public void testGetPodcastak8() throws SQLException {
        assertEquals(Time.valueOf("00:52:23"), result.get(1).getIraupena());
    }
    @Test
    public void testGetPodcastak9() throws SQLException {
        assertNotNull(result.get(1).getIrudia());
    }
}