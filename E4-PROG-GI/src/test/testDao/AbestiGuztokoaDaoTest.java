package test.testDao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.AbestiGuztokoa;
import model.Abestia;
import model.Audio;
import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.dao.AbestiGuztokoaDao;
import model.sql.Kone;

public class AbestiGuztokoaDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;

		Audio audioTest1 = new Audio();
		audioTest1.setIdAudio(1);
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa(erabitzaileFreeTest, audioTest1);
		AbestiGuztokoaDao.abestiGustokoaGehitu(abestiGuztokoa1);

		Audio audioTest2 = new Audio();
		audioTest2.setIdAudio(2);
		AbestiGuztokoa abestiGuztokoa2 = new AbestiGuztokoa(erabitzaileFreeTest, audioTest2);
		AbestiGuztokoaDao.abestiGustokoaGehitu(abestiGuztokoa2);

	}

	@Test
	public void getAbestiGustokoakTest() throws SQLException {

		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;

		Time time = new Time(0, 4, 8);
		Abestia abestiaTest = new Abestia(1, "Phoenix", time, null, false);

		ArrayList<Audio> audioakTest = AbestiGuztokoaDao.getAbestiGustokoak();
		assertEquals(abestiaTest, audioakTest.get(0));

	}

	@Test
	public void abestiGustokoaGehituTest() throws SQLException {
		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;

		Audio audioTest = new Audio();
		audioTest.setIdAudio(3);

		AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(erabitzaileFreeTest, audioTest);

		assertTrue(AbestiGuztokoaDao.abestiGustokoaGehitu(abestiGuztokoa));

	}

	@Test
	public void abestiGustokoaEzabatuTest() throws SQLException {
		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;
		Audio audioTest = new Audio();
		audioTest.setIdAudio(2);
		AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(erabitzaileFreeTest, audioTest);

		assertTrue(AbestiGuztokoaDao.abestiGuztokoaEzabatu(abestiGuztokoa));

	}

	@Test
	public void abestiGuztokoaKonprobatuTrueTest() throws SQLException {
		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;
		Audio audioTest = new Audio();
		audioTest.setIdAudio(1);
		AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(erabitzaileFreeTest, audioTest);

		assertTrue(AbestiGuztokoaDao.abestiGuztokoaKonprobatu(abestiGuztokoa));

	}

	@Test
	public void abestiGuztokoaKonprobatuFalseTest() throws SQLException {
		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;
		Audio audioTest = new Audio();
		audioTest.setIdAudio(4);
		AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(erabitzaileFreeTest, audioTest);

		assertFalse(AbestiGuztokoaDao.abestiGuztokoaKonprobatu(abestiGuztokoa));

	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		ErabiltzaileFree erabitzaileFreeTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabitzaileFreeTest;

		Audio audioTest = new Audio();
		audioTest.setIdAudio(1);
		AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(erabitzaileFreeTest, audioTest);
		AbestiGuztokoaDao.abestiGuztokoaEzabatu(abestiGuztokoa);

		Audio audioTest1 = new Audio();
		audioTest1.setIdAudio(3);
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa(erabitzaileFreeTest, audioTest1);
		AbestiGuztokoaDao.abestiGuztokoaEzabatu(abestiGuztokoa1);

	}

}
