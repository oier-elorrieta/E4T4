package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Date;

import model.*;

import static org.junit.Assert.*;

public class TestErabiltzaileFree {

    @Test
    public void testErabiltzaileFreeConstructor() {
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "Test";
        String abizena = "User";
        Date jaiotzeData = new Date();
        String hizkuntza = "eu";

        ErabiltzaileFree erabiltzaileFree = new ErabiltzaileFree(erabiltzailea, pasahitza, izena, abizena, jaiotzeData, hizkuntza);

        assertEquals(erabiltzailea, erabiltzaileFree.getErabiltzailea());
        assertEquals(pasahitza, erabiltzaileFree.getPasahitza());
        assertEquals(izena, erabiltzaileFree.getIzena());
        assertEquals(abizena, erabiltzaileFree.getAbizena());
        assertEquals(jaiotzeData, erabiltzaileFree.getJaiotzeData());
        assertEquals(hizkuntza, erabiltzaileFree.getHizkuntza());
    }
}