package test;
import static org.junit.Assert.*;

import java.util.Date;

import javax.swing.JButton;

import org.junit.Test;

import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Erabiltzailea;
import model.SesioAldagaiak;

public class SesioAldagaiakTest {

    @Test
    public void testGetLogErabiltzailea() {
        SesioAldagaiak.logErabiltzailea = new Erabiltzailea();
        assertNotNull(SesioAldagaiak.logErabiltzailea);
    }

    @Test
    public void testGetErabiltzaileLogeatutaFree() {
        SesioAldagaiak.erabiltzaileLogeatutaFree = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");;
        assertNotNull(SesioAldagaiak.erabiltzaileLogeatutaFree);
    }

    @Test
    public void testGetErabiltzaileLogeatutaPremium() {
        SesioAldagaiak.erabiltzaileLogeatutaPremium = new ErabiltzailePremium();
        assertNotNull(SesioAldagaiak.erabiltzaileLogeatutaPremium);
    }

    @Test
    public void testIsErabiltzailePremium() {
        SesioAldagaiak.erabiltzailePremium = true;
        assertTrue(SesioAldagaiak.erabiltzailePremium);
    }

    @Test
    public void testGetJb() {
        SesioAldagaiak.jb = new JButton();
        assertNotNull(SesioAldagaiak.jb);
    }

}