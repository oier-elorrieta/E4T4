package test;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;

import model.Musikaria;

import static org.junit.Assert.*;

public class TestArtista {

	@Test
	public void testSetIzena() {
		Musikaria artist = new Musikaria("John Doe", "Description", "image.jpg");
		artist.setIzena("Jane Smith");
		assertEquals("Jane Smith", artist.getIzena());
	}

	@Test
	public void testSetDeskription() {
		Musikaria artist = new Musikaria("John Doe", "Description", "image.jpg");
		artist.setDeskription("New description");
		assertEquals("New description", artist.getDeskription());
	}

	@Test
	public void testSetIrudia() {
		Musikaria artist = new Musikaria("John Doe", "Description", "image.jpg");
		artist.setIrudia("new_image.jpg");
		assertEquals("new_image.jpg", artist.getIrudia());
	}

	@Test
	public void testEquals() {
		Musikaria artist1 = new Musikaria("John Doe", "Description 1", "image1.jpg");
		Musikaria artist2 = new Musikaria("John Doe", "Description 1", "image1.jpg");
		Musikaria artist3 = new Musikaria("Jane Smith", "Description 2", "image2.jpg");

		Assertions.assertEquals(artist1, artist2);
		Assertions.assertNotEquals(artist1, artist3);
	}

	@Test
	public void testToString() {
		Musikaria artist = new Musikaria("John Doe", "Description", "image.jpg");
		String expectedString = "Artistak [izena=John Doe, deskription=Description, irudia=image.jpg]";

		Assertions.assertEquals(expectedString, artist.toString());
	}

	@Test
	public void testGettersAndSetters() {
		Musikaria artist = new Musikaria("John Doe", "Description", "image.jpg");

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