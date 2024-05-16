package test.objetuakTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Iragarkia;

public class IragarkiaTest {

	@Test
	public void testIragarkiaEquals() {
		Iragarkia iragarkiaTest1 = new Iragarkia(1, "Iragarkia", null);
		Iragarkia iragarkiaTest2 = new Iragarkia(1, "Iragarkia", null);
		assertTrue(iragarkiaTest1.equals(iragarkiaTest2));
	}

}
