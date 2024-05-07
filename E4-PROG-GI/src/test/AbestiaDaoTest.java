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
        assertNotNull(result);
    }

    @Test
    public void testGetAbestiak() {
        ArrayList<Audio> result = AbestiaDao.getAbestiak(1);
        assertNotNull(result);
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
        abestiaB.setIdAudio(3);
        AbestiaDao.abestiGustokoaGehitu(abestiaB);
    }
    
    @Test
    public void testAbestiGuztokoaEzabatu() throws SQLException {
    	ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        Audio abestiaB = new Audio();
        abestiaB.setIdAudio(3);
        AbestiaDao.abestiGuztokoaEzabatu(abestiaB.getIdAudio());
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