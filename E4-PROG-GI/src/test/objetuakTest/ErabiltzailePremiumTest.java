package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.ErabiltzailePremium;

import java.util.Date;

public class ErabiltzailePremiumTest {

    @Test
    public void testEqualsErabiltzailePremiumTrue() {
        java.sql.Date data = new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium1 = new ErabiltzailePremium(1, "testUser", "testPassword", "testName", "testSurname", data, "testLanguage", data);
        ErabiltzailePremium erabiltzailePremium2 = new ErabiltzailePremium(1, "testUser", "testPassword", "testName", "testSurname", data, "testLanguage", data);

        assertTrue(erabiltzailePremium1.equals(erabiltzailePremium2));
    }
    
    @Test
    public void testEqualsErabiltzaileaPremiumPuntero() {
        java.sql.Date data = new java.sql.Date(new Date().getTime());

        ErabiltzailePremium erabiltzailePremium1 = new ErabiltzailePremium(1, "testUser", "testPassword", "testName", "testSurname", data, "testLanguage", data);

        assertTrue(erabiltzailePremium1.equals(erabiltzailePremium1));
    }
        
    @Test
    public void testSetGetPremiumMuga() {
        ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium();
        java.sql.Date data =new java.sql.Date(new Date().getTime());

        erabiltzailePremium.setPremiumMuga(data);

        assertEquals(data, erabiltzailePremium.getPremiumMuga());
    }
}