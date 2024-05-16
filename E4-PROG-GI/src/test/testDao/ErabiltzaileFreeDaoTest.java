package test.testDao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import model.ErabiltzaileFree;
import model.Erabiltzailea;
import model.dao.ErabiltzaileFreeDao;

public class ErabiltzaileFreeDaoTest {

	@Test
	public void erregistratuErabiltzailea() {
		java.util.Date date = new java.util.Date();
		java.sql.Date datesql = new java.sql.Date(date.getTime());
		ErabiltzaileFree erabiltzaileaFree = new ErabiltzaileFree(0, "new", "new", "new", "new", datesql, "ES");
		boolean ondo = ErabiltzaileFreeDao.erregistratuErabiltzailea(erabiltzaileaFree);
		assertTrue(ondo);
	}
	
	@Test
	public void kargatuErabiltzaileFreeTest() {
		boolean ondo = ErabiltzaileFreeDao.kargatuErabiltzaileFree(1);
		assertTrue(ondo);
	}

}
