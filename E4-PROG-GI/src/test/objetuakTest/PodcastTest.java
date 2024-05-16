package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Podcast;

import java.sql.Blob;
import java.sql.Time;

public class PodcastTest {

    @Test
    public void testPodcastEquals() {
        Time iraupena = new Time(0, 10, 0);

        Podcast podcast1 = new Podcast(1, "Podcast Name", iraupena, null);
        Podcast podcast2 = new Podcast(1, "Podcast Name", iraupena, null);

        assertTrue(podcast1.equals(podcast2));
    }
}