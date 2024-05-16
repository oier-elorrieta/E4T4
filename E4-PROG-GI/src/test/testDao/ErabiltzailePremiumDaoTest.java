package test.testDao;

import static org.junit.Assert.*;

import org.junit.Test;

import model.dao.ErabiltzailePremiumDao;


public class ErabiltzailePremiumDaoTest {
	
	@Test
	public void erregistratuPremiumTest() {
		
		java.util.Date date = new java.util.Date(2030, 1, 1);
		java.sql.Date datesql = new java.sql.Date(date.getTime());
		
		boolean ondo = ErabiltzailePremiumDao.erregistratuPremium(1, datesql);
		assertTrue(ondo);
	}

	@Test
	public void kargatuErabiltzailePremiumTest() {
		boolean ondo = ErabiltzailePremiumDao.kargatuErabiltzailePremium(3);
		assertTrue(ondo);
	}

}
