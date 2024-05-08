package test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Abestia;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.SesioAldagaiak;
import model.sql.Kone;

public class KoneTest {
	
	private ErabiltzaileFree erabiltzailea;
	private ErabiltzailePremium erabiltzaileaP;

    @Before
    public void setUp() {
    	Kone.kargatuErabiltzaileFree(1);
    	Kone.kargatuErabiltzailePremium(2);
    	erabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaFree;
    	erabiltzaileaP = SesioAldagaiak.erabiltzaileLogeatutaPremium;
    	SesioAldagaiak.logErabiltzailea = erabiltzailea;
    }

    @After
    public void tearDown() {
    	Kone.itxiConexioa();
    }

    @Test
    public void testKonektatu() {
        assertNotNull(Kone.konektatu());
    }

    @Test
    public void testKonektatuAdmin() {
        boolean result = Kone.konektatuAdmin("admin", "headmin");
        assertTrue(result);
    }

    @Test
    public void testHizkuntzakAtera() {
    	Kone.konektatu();
    	ArrayList <String> H2 = new ArrayList <String>();
    	
    	ResultSet result = null;
    	try {
			result = Kone.hizkuntzakAtera();
			while (result.next()) {
				H2.add(result.getString("IdHizkuntza"));
			}
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertEquals("ES", H2.get(0));
    }

    /*
     * Ezin da beti ondo egin test hau
    @Test
    public void testErregistratu() {
        Kone.erregistratu(erabiltzailea);
    }
     */
    
    @Test
    public void testEguneratuErabiltzailea() {
    	int h1 = erabiltzailea.hashCode();
    	erabiltzailea.setAbizena("a");
        Kone.eguneratuErabiltzailea(erabiltzailea);
    	int h2 = erabiltzailea.hashCode();
        assertEquals(h1, h2);
    }
    
    @Test
    public void testEguneratuErabiltzaileaBerriro() {
    	int h1 = erabiltzailea.hashCode();
    	erabiltzailea.setAbizena("Blanca");
        Kone.eguneratuErabiltzailea(erabiltzailea);
        int h2 = erabiltzailea.hashCode();
        assertEquals(h1, h2);
    }

    /*
     * Ezin da beti ondo egin test hau
    @Test
    public void testErregistratuPremium() {
        int id = 1;
        java.sql.Date iranD = new java.sql.Date(System.currentTimeMillis());
        Kone.erregistratuPremium(id, iranD);
    }
    */

    @Test
    public void testIsLoginaOk() throws SQLException {
        ResultSet result = Kone.isLoginaOk(erabiltzailea.getErabiltzailea());
        assertTrue(result.next());
        
    }

    @Test
    public void testKargatuErabiltzaileFree() {
        Kone.kargatuErabiltzaileFree(1);
        assertEquals(SesioAldagaiak.erabiltzaileLogeatutaFree, erabiltzailea);
    }

    @Test
    public void testKargatuErabiltzailePremium() {
        Kone.kargatuErabiltzailePremium(2);
        assertEquals(SesioAldagaiak.erabiltzaileLogeatutaPremium, erabiltzaileaP);
    }

    @Test
    public void testGetAbestiGustokoak() {
        ArrayList<Abestia> result = Kone.getAbestiGustokoak();
        assertEquals(result.size(), 2);
    }
}