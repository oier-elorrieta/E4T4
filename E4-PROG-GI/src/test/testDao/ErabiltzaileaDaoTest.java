package test.testDao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

import model.Erabiltzailea;
import model.SesioAldagaiak;
import model.dao.ErabiltzaileaDao;
import model.sql.Kone;

public class ErabiltzaileaDaoTest {

	@Test
	public void eguneratuErabiltzaileaTest() throws SQLException {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		erabiltzailea.setIdErabiltzailea(1);
		SesioAldagaiak.logErabiltzailea = erabiltzailea;
		
		boolean ondo = false;
		java.util.Date date = new Date();
		java.sql.Date datesql = new java.sql.Date(date.getTime())
;		Erabiltzailea erabiltzaileaTest = new Erabiltzailea(1, "probak", "probak", "probak", "probak", datesql, "EN");
		ondo = ErabiltzaileaDao.eguneratuErabiltzailea(erabiltzaileaTest);
		
		assertTrue(ondo);
		
	}
	
	@Test
	public void isLoginaOkTest() {
		Erabiltzailea erabiltzaileaTest = new Erabiltzailea(1, "probak", "probak");
		Erabiltzailea erabiltzaileTest = ErabiltzaileaDao.isLoginaOk("probak");
		assertEquals(erabiltzaileaTest, erabiltzaileTest);
	}

	@Test
	public void erabiltzaileMotaTest() {
		Erabiltzailea erabiltzaileaTest = new Erabiltzailea(1, "probak", "probak");
		String mota = ErabiltzaileaDao.erabiltzaileMota(erabiltzaileaTest);
		assertEquals("free", mota);
	}
}
