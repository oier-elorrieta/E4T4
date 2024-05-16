package test.testDao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.Iragarkia;
import model.dao.IragarkiaDao;
import model.sql.Kone;

public class IragarkiaDaoTest {

	@Test
	public void getIragarkiakTest() throws SQLException {
		ArrayList<Iragarkia> iragarkiakTest = IragarkiaDao.getIragarkiak();
		Iragarkia iragarkiaTest = new Iragarkia(35, "Nocilla", null);
		assertEquals(iragarkiaTest, iragarkiakTest.get(0));
	}

}
