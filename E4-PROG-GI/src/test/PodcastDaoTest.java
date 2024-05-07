package test;

import static org.junit.Assert.*;

import java.sql.Blob;
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
    public void testGetPodcastak() throws SQLException {
        Podcasterra podcaster = new Podcasterra();
        podcaster.setIdArtista(1);
        
        ArrayList<Audio> result = PodcastDao.getPodcastak(podcaster);
        
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getIdAudio());
        assertEquals("Podcast1", result.get(0).getIzena());
        assertEquals(Time.valueOf("00:30:00"), result.get(0).getIraupena());
        assertNull(result.get(0).getIrudia());
        
        assertEquals(2, result.get(1).getIdAudio());
        assertEquals("Podcast2", result.get(1).getIzena());
        assertEquals(Time.valueOf("00:45:00"), result.get(1).getIraupena());
        assertNull(result.get(1).getIrudia());
    }
}