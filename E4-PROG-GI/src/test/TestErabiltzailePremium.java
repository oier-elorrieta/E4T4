package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.ErabiltzailePremium;

import java.util.Date;

public class TestErabiltzailePremium {

    @Test
    public void testErabiltzailePremiumConstructor() {
        String erabiltzailea = "testUser";
        String pasahitza = "testPassword";
        String izena = "Test";
        String abizena = "User";
        Date jaiotzeData = new Date();
        String hizkuntza = "eu";
        Date premiumMuga = new Date();

        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(erabiltzailea, pasahitza, izena, abizena, jaiotzeData, hizkuntza, premiumMuga);

        Assertions.assertEquals(erabiltzailea, erabiltzailePremium.getErabiltzailea());
        Assertions.assertEquals(pasahitza, erabiltzailePremium.getPasahitza());
        Assertions.assertEquals(izena, erabiltzailePremium.getIzena());
        Assertions.assertEquals(abizena, erabiltzailePremium.getAbizena());
        Assertions.assertEquals(jaiotzeData, erabiltzailePremium.getJaiotzeData());
        Assertions.assertEquals(hizkuntza, erabiltzailePremium.getHizkuntza());
        Assertions.assertEquals(premiumMuga, erabiltzailePremium.getPremiumMuga());
    }
}