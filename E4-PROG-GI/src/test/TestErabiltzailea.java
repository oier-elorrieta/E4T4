package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Erabiltzailea;

import java.util.Date;

public class TestErabiltzailea {
	
	private Erabiltzailea erabiltzailea;
	
	@Before
	public void Erabiltzailea() {
	    erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new Date(), "English");
	}

    @Test
    public void testgetsetIdErabiltzailea() {
    	erabiltzailea.setIdErabiltzailea(erabiltzailea.getIdErabiltzailea());
    }

    @Test
    public void testgetsetErabiltzailea() {
        erabiltzailea.setErabiltzailea(erabiltzailea.getErabiltzailea());
    }

    @Test
    public void testgetsetPasahitza() {
        erabiltzailea.setPasahitza(erabiltzailea.getPasahitza());
    }

    @Test
    public void testgetsetIzena() {
        erabiltzailea.setIzena(erabiltzailea.getIzena());
    }

    @Test
    public void testgetsetAbizena() {
        erabiltzailea.setAbizena(erabiltzailea.getAbizena());
    }

    @Test
    public void testgetsetJaiotzeData() {
        erabiltzailea.setJaiotzeData(erabiltzailea.getJaiotzeData());
    }

    @Test
    public void testgetsetHizkuntza() {
        erabiltzailea.setHizkuntza(erabiltzailea.getHizkuntza());
    }

    @Test
    public void testEquals() {
        Erabiltzailea erabiltzailea1 = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new Date(), "English");
        Erabiltzailea erabiltzailea2 = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new Date(), "English");
        Erabiltzailea erabiltzailea3 = new Erabiltzailea(2, "user2", "password2", "Jane", "Smith", new Date(), "Spanish");

        assertTrue(erabiltzailea1.equals(erabiltzailea2));

        assertFalse(erabiltzailea1.equals(erabiltzailea3));
    }
}