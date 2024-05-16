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
        Erabiltzailea erabiltzailea1 = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        Erabiltzailea erabiltzailea3 = new Erabiltzailea(2, "user2", "password2", "Jane", "Smith", new java.sql.Date(new Date().getTime()), "en");

        assertFalse(erabiltzailea1.equals(erabiltzailea3));
    }

    @Test
    public void testToString() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        String expected = "Erabiltzailea [idErabiltzailea=1, erabiltzailea=user1, pasahitza=password1, izena=John, abizena=Doe, jaiotzeData=" + erabiltzailea.getJaiotzeData() + ", hizkuntza=eu]";
        assertEquals(expected, erabiltzailea.toString());
    }

    @Test
    public void testGetIdErabiltzailea() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals(1, erabiltzailea.getIdErabiltzailea());
    }

    @Test
    public void testSetIdErabiltzailea() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setIdErabiltzailea(1);
        assertEquals(1, erabiltzailea.getIdErabiltzailea());
    }

    @Test
    public void testGetErabiltzailea() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("user1", erabiltzailea.getErabiltzailea());
    }

    @Test
    public void testSetErabiltzailea() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setErabiltzailea("user1");
        assertEquals("user1", erabiltzailea.getErabiltzailea());
    }

    @Test
    public void testGetPasahitza() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("password1", erabiltzailea.getPasahitza());
    }

    @Test
    public void testSetPasahitza() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setPasahitza("password1");
        assertEquals("password1", erabiltzailea.getPasahitza());
    }

    @Test
    public void testGetIzena() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("John", erabiltzailea.getIzena());
    }

    @Test
    public void testSetIzena() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setIzena("John");
        assertEquals("John", erabiltzailea.getIzena());
    }

    @Test
    public void testGetAbizena() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("Doe", erabiltzailea.getAbizena());
    }

    @Test
    public void testSetAbizena() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setAbizena("Doe");
        assertEquals("Doe", erabiltzailea.getAbizena());
    }

    @Test
    public void testGetJaiotzeData() {
        java.sql.Date jaiotzeData = new java.sql.Date(new Date().getTime());
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", jaiotzeData, "eu");
        assertEquals(jaiotzeData, erabiltzailea.getJaiotzeData());
    }

    @Test
    public void testSetJaiotzeData() {
        java.sql.Date jaiotzeData = new java.sql.Date(new Date().getTime());
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setJaiotzeData(jaiotzeData);
        assertEquals(jaiotzeData, erabiltzailea.getJaiotzeData());
    }

    @Test
    public void testGetHizkuntza() {
        Erabiltzailea erabiltzailea = new Erabiltzailea(1, "user1", "password1", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("eu", erabiltzailea.getHizkuntza());
    }

    @Test
    public void testSetHizkuntza() {
        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setHizkuntza("eu");
        assertEquals("eu", erabiltzailea.getHizkuntza());
    }
}