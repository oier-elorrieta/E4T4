package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.ErabiltzaileFree;

import java.util.Date;

public class ErabiltzaileFreeTest {

    @Test
    public void testGetIdErabiltzailea() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals(1, erabiltzaile.getIdErabiltzailea());
    }

    @Test
    public void testGetErabiltzailea() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("username", erabiltzaile.getErabiltzailea());
    }

    @Test
    public void testGetPasahitza() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("password", erabiltzaile.getPasahitza());
    }

    @Test
    public void testGetIzena() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("John", erabiltzaile.getIzena());
    }

    @Test
    public void testGetAbizena() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("Doe", erabiltzaile.getAbizena());
    }

    @Test
    public void testGetJaiotzeData() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals(new java.sql.Date(new Date().getTime()), erabiltzaile.getJaiotzeData());
    }

    @Test
    public void testGetHizkuntza() {
        ErabiltzaileFree erabiltzaile = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertEquals("eu", erabiltzaile.getHizkuntza());
    }
}