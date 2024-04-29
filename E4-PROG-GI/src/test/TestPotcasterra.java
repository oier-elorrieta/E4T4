package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Podcasterra;

public class TestPotcasterra {

    @Test
    public void testConstructor() {
        String izena = "Podcaterra";
        String deskription = "Description";
        String irudia = "Image";
        
        Podcasterra podcaterra = new Podcasterra(izena, deskription, irudia);
        
        Assertions.assertEquals(izena, podcaterra.getIzena());
        Assertions.assertEquals(deskription, podcaterra.getDeskription());
        Assertions.assertEquals(irudia, podcaterra.getIrudia());
    }
}