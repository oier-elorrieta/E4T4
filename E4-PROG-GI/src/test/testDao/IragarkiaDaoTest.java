package test.testDao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import model.Iragarkia;
import model.dao.IragarkiaDao;

public class IragarkiaDaoTest {

	@Test
	public void getIragarkiakTest() throws SQLException {
		ArrayList<Iragarkia> iragarkiakTest = IragarkiaDao.getIragarkiak();
		Iragarkia iragarkiaTest = new Iragarkia(35, "Nocilla", null);
		assertEquals(iragarkiaTest, iragarkiakTest.get(0));
	}

}
