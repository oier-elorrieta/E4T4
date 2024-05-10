package test;
import static org.junit.Assert.*;
import org.junit.Test;

import model.ErabiltzailePremium;

import java.util.Date;

public class ErabiltzailePremiumTest {

    @Test
    public void testId() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(idErabiltzailea, erabiltzailePremium.getIdErabiltzailea());
    }
    @Test
    public void testErabilzaile() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(erabiltzailea, erabiltzailePremium.getErabiltzailea());
    }
    @Test
    public void testpasahitza() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(pasahitza, erabiltzailePremium.getPasahitza());
    }
    @Test
    public void testIzena() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(izena, erabiltzailePremium.getIzena());
    }
    @Test
    public void testAbizena() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(abizena, erabiltzailePremium.getAbizena());
    }
    @Test
    public void testdata() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(data, erabiltzailePremium.getJaiotzeData());
    }
    @Test
    public void testHizkuntza() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(hizkuntza, erabiltzailePremium.getHizkuntza());
    }
    @Test
    public void testPM() {
        int idErabiltzailea = 1;
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "testName";
        String abizena = "testSurname";
        String hizkuntza = "testLanguage";
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(idErabiltzailea, erabiltzailea, pasahitza, izena, abizena, data, hizkuntza, data);

        assertEquals(data, erabiltzailePremium.getPremiumMuga());
    }

    @Test
    public void testSetPremiumMuga() {
        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium();
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        erabiltzailePremium.setPremiumMuga(data);

        assertEquals(data, erabiltzailePremium.getPremiumMuga());
    }
}