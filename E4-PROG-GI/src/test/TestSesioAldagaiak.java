package test;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.SesioAldagaiak;

public class TestSesioAldagaiak {

    @Test
    public void testErabiltzaileLogeatutaFree() {
        SesioAldagaiak.erabiltzaileLogeatutaFree = new ErabiltzaileFree(1, "erabiltzailea", "pasahitza", "izena", "abizena", new Date(), "hizkuntza");
        Assertions.assertNotNull(SesioAldagaiak.erabiltzaileLogeatutaFree);
    }

    @Test
    public void testErabiltzaileLogeatutaPremium() {
        SesioAldagaiak.erabiltzaileLogeatutaPremium = new ErabiltzailePremium(1, "erabiltzailea", "pasahitza", "izena", "abizena", new Date(), "hizkuntza", new Date());
        Assertions.assertNotNull(SesioAldagaiak.erabiltzaileLogeatutaPremium);
    }

    @Test
    public void testErabiltzailePremium() {
        SesioAldagaiak.erabiltzailePremium = true;
        Assertions.assertTrue(SesioAldagaiak.erabiltzailePremium);
    }
}