package test;
import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Erabiltzailea;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;

public class AbestiaDaoTest {

    @Test
    public void testGetAbestiGustokoak() {
    	ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        ArrayList<Abestia> result = AbestiaDao.getAbestiGustokoak();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testGetAbestiak() {
        ArrayList<Audio> result = AbestiaDao.getAbestiak(1);
        assertEquals(result.size(), 3);
    }



    @Test
    public void testGustukoaKomprobatu() throws SQLException {
    	ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        Audio abestiaB = new Audio();
        abestiaB.setIdAudio(2);
        boolean result = AbestiaDao.gustukoaKomprobatu(abestiaB);
        assertFalse(result);
    }

    @Test
    public void testAbestiGustokoaGehitu() throws SQLException {
    	ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        Audio abestiaB = new Audio();
        abestiaB.setIdAudio(4);
        AbestiaDao.abestiGustokoaGehitu(abestiaB);
        ArrayList<Abestia> result = AbestiaDao.getAbestiGustokoak();
        assertEquals(result.size(), 0);
    }
    
    @Test
    public void testAbestiGuztokoaEzabatu() throws SQLException {
    	ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        Audio abestiaB = new Audio();
        abestiaB.setIdAudio(4);
        AbestiaDao.abestiGuztokoaEzabatu(abestiaB.getIdAudio());
        ArrayList<Abestia> result = AbestiaDao.getAbestiGustokoak();
        assertEquals(result.size(), 0);
    }

    @Test
    public void testErregistratuErreprodukzioa() {
    	ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        Audio abestiaB = new Audio();
        abestiaB.setIdAudio(1);
        AbestiaDao.erregistratuErreprodukzioa(abestiaB);
        
    }
}