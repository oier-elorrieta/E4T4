/*
package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.Assert.*;

public class TestArtistak {

    @Test
    public void testEquals() {
        Artistak artist1 = new Artistak("John Doe", "Description 1", "image1.jpg");
        Artistak artist2 = new Artistak("John Doe", "Description 1", "image1.jpg");
        Artistak artist3 = new Artistak("Jane Smith", "Description 2", "image2.jpg");

        Assertions.assertEquals(artist1, artist2); // Same attributes, should be equal
        Assertions.assertNotEquals(artist1, artist3); // Different attributes, should not be equal
    }

    @Test
    public void testToString() {
        Artistak artist = new Artistak("John Doe", "Description", "image.jpg");
        String expectedString = "Artistak [izena=John Doe, deskription=Description, irudia=image.jpg]";

        Assertions.assertEquals(expectedString, artist.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Artistak artist = new Artistak("John Doe", "Description", "image.jpg");

        Assertions.assertEquals("John Doe", artist.getIzena());
        Assertions.assertEquals("Description", artist.getDeskription());
        Assertions.assertEquals("image.jpg", artist.getIrudia());

        artist.setIzena("Jane Smith");
        artist.setDeskription("New Description");
        artist.setIrudia("new_image.jpg");

        Assertions.assertEquals("Jane Smith", artist.getIzena());
        Assertions.assertEquals("New Description", artist.getDeskription());
        Assertions.assertEquals("new_image.jpg", artist.getIrudia());
    }
}
*/