package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Iragarkia;
import model.dao.IragarkiaDao;

public class IragarkiaDaoTest {

	@Test
	public void test() {
		ArrayList<Iragarkia> iragarkiaTest;
		iragarkiaTest = IragarkiaDao.getIragarkiak();
		assertNotNull(iragarkiaTest);
	}

}
