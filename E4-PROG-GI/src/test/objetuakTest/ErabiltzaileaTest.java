package test.objetuakTest;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Erabiltzailea;

import java.util.Date;

public class ErabiltzaileaTest {

    @Test
    public void testEquals() {
        Erabiltzailea erabiltzailea1 = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        Erabiltzailea erabiltzailea2 = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertTrue(erabiltzailea1.equals(erabiltzailea2));
    }
    @Test
    public void testEquals2() {
        Erabiltzailea erabiltzailea1 = new Erabiltzailea(1, "user1", "password1");
        Erabiltzailea erabiltzailea3 = new Erabiltzailea(2, "user2", "password2");

        assertFalse(erabiltzailea1.equals(erabiltzailea3));
    }

    @Test
    public void testToString() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        String expected = "Erabiltzailea [idErabiltzailea=1, erabiltzailea=user1, pasahitza=password1, izena=John, abizena=Doe, jaiotzeData=" + erabiltzailea.getJaiotzeData() + ", hizkuntza=eu]";
        assertEquals(expected, erabiltzailea.toString());
    }

    @Test
    public void testSetGetIdErabiltzailea() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setIdErabiltzailea(1);
        assertEquals(1, erabiltzailea.getIdErabiltzailea());
    }

    @Test
    public void testSetGetErabiltzailea() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setErabiltzailea("user1");
        assertEquals("user1", erabiltzailea.getErabiltzailea());
    }

    @Test
    public void testSetGetPasahitza() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setPasahitza("password1");
        assertEquals("password1", erabiltzailea.getPasahitza());
    }

    @Test
    public void testSetGetIzena() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setIzena("John");
        assertEquals("John", erabiltzailea.getIzena());
    }

    @Test
    public void testSetGetAbizena() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setAbizena("Doe");
        assertEquals("Doe", erabiltzailea.getAbizena());
    }

    @Test
    public void testSetGetJaiotzeData() {
        java.sql.Date jaiotzeData = new java.sql.Date(new Date().getTime());
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setJaiotzeData(jaiotzeData);
        assertEquals(jaiotzeData, erabiltzailea.getJaiotzeData());
    }

    @Test
    public void testSetGetHizkuntza() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setHizkuntza("eu");
        assertEquals("eu", erabiltzailea.getHizkuntza());
    }
}