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
		int zenbatIragarkiTest;
		
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "select count(*) as zbk from Audio where mota = 'iragarkia'";
		ResultSet rs = stm.executeQuery(kontsulta);
		rs.next();
		zenbatIragarkiTest = rs.getInt("zbk");
		konexioa.close();
		
		assertEquals(zenbatIragarkiTest, iragarkiakTest.size());
	}

}
