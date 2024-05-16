package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.metodoak.ViewMetodoak;

public class ViewMetodoakTest {

	@Test
	public void comprobatuLoginFreeTest() {
		boolean ondo = ViewMetodoak.comprobatuLogin("eka", "bla");
		assertTrue(ondo);
	}
	
	@Test
	public void comprobatuLoginPremiumTest() {
		boolean ondo = ViewMetodoak.comprobatuLogin("ait", "sag");
		assertTrue(ondo);
	}

	@Test
	public void komprobatuAdminTest() {
		boolean ondo = ViewMetodoak.komprobatuAdmin("admin", "headmin");
		assertTrue(ondo);
	}
	
}
