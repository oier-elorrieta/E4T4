package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Podcaterra;

public class TestPotcasterra {

    @Test
    public void testConstructor() {
        String izena = "Podcaterra";
        String deskription = "Description";
        String irudia = "Image";
        
        Podcaterra podcaterra = new Podcaterra(izena, deskription, irudia);
        
        Assertions.assertEquals(izena, podcaterra.getIzena());
        Assertions.assertEquals(deskription, podcaterra.getDeskription());
        Assertions.assertEquals(irudia, podcaterra.getIrudia());
    }
}