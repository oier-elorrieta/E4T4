package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Iragarkia;

public class IragarkiaTest {

	@Test
	public void iragarkiaTest() {
		Iragarkia iragarkiaTest = new Iragarkia(20, "Nocilla", null);
		assertEquals(20, iragarkiaTest.getIdAudio());
	}

}
