package test;

import org.junit.Test;

import model.Podcast;

import static org.junit.Assert.*;

public class TestPodcast {

    @Test
    public void testPodcastConstructor() {
        Podcast podcast = new Podcast("My Podcast", 60);
        assertEquals("My Podcast", podcast.getIzena());
        assertEquals(60, podcast.getIraupena());
    }
}