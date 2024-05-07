package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;

import org.junit.Test;

import model.Podcasterra;
import model.dao.PodcasterraDao;

public class PodcasterraDaoTest {

    @Test
    public void testGetPodcasterEntzunaldiak() {
        ArrayList<Podcasterra> result = PodcasterraDao.getPodcasterEntzunaldiak();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testGetPodcasterra() {
        Podcasterra result = PodcasterraDao.getPodcasterra("Podcaster1");
        assertNotNull(result);
        assertEquals("Podcaster1", result.getIzenArtistikoa());
        Blob irudia = result.getIrudia();
        assertNotNull(irudia);
        // Add more assertions if needed
    }
}