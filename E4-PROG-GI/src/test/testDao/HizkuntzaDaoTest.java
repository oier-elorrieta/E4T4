package test.testDao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Hizkuntza;
import model.dao.HizkuntzaDao;

public class HizkuntzaDaoTest {

	@Test
	public void getHizkuntzakTest() {
		Hizkuntza hizkuntza = new Hizkuntza("ES", "Español");
		ArrayList<Hizkuntza> hizkuntzak = HizkuntzaDao.getHizkuntzak();
		
		assertEquals(hizkuntza, hizkuntzak.get(0));
	}

}
