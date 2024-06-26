package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.ErabiltzaileFree;

import java.util.Date;

public class ErabiltzaileFreeTest {

    @Test
    public void testKonstruktoreaErabiltzaileaFree() {
        ErabiltzaileFree erabiltzaile1 = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        ErabiltzaileFree erabiltzaile2 = new ErabiltzaileFree(1, "username", "password", "John", "Doe", new java.sql.Date(new Date().getTime()), "eu");
        assertTrue(erabiltzaile1.equals(erabiltzaile2));
    }

}