package test.objetuakTest;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Erabiltzailea;
import model.SesioAldagaiak;

public class SesioAldagaiakTest {

    @Test
    public void testGetLogErabiltzailea() {
        SesioAldagaiak.logErabiltzailea = new Erabiltzailea();
        assertNotNull(SesioAldagaiak.logErabiltzailea);
    }
    
    @Test
    public void testGetDoSkip() {
        SesioAldagaiak.doSkip = true;
        assertTrue(SesioAldagaiak.doSkip);
    }
    
    @Test
    public void testGetIragarkiaAtera() {
        SesioAldagaiak.iragarkiaAtera = true;
        assertTrue(SesioAldagaiak.iragarkiaAtera);
    }
    
    @Test
    public void testGetErreprodukzioKop() {
        SesioAldagaiak.erreprodukzioKop = 1;
        assertEquals(1, SesioAldagaiak.erreprodukzioKop);
    }
}