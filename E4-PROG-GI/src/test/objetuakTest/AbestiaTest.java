package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Abestia;

import java.sql.Blob;
import java.sql.Time;

public class AbestiaTest {

    @Test
    public void testAbestiaEquals() {
        Time iraupena = new Time(0, 3, 30);
        Abestia abestia1 = new Abestia(1, "Abestia", iraupena, null, false);
        Abestia abestia2 = new Abestia(1, "Abestia", iraupena);

        assertTrue(abestia1.equals(abestia2));
    }
    
    @Test
    public void testAbestiaGustokoaGetSet() {
        Abestia abestia1 = new Abestia();
        abestia1.setGustokoena(true);

        assertTrue(abestia1.getGustokoena());
    }
    
    @Test
    public void testAbestiaToString() {
    	Time iraupena = new Time(0, 3, 30);
        Abestia abestia1 = new Abestia(1, "Abestia", iraupena, null, false);

        String txt = "Izena:Abestia || Iraupena: " + iraupena;
        assertEquals(txt, abestia1.toString());
    }

}