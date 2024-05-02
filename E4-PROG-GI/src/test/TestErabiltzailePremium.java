package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.ErabiltzailePremium;

import java.util.Date;

public class TestErabiltzailePremium {
  
  @Test
  public void testGetPremiumMuga() {
    Date premiumMuga = new Date();
    ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(1, "erabiltzailea", "pasahitza", "izena", "abizena", new Date(), "hizkuntza", premiumMuga);
    assertEquals(premiumMuga, erabiltzailePremium.getPremiumMuga());
  }
  
  @Test
  public void testSetPremiumMuga() {
    Date premiumMuga = new Date();
    ErabiltzailePremium erabiltzailePremium = new ErabiltzailePremium(1, "erabiltzailea", "pasahitza", "izena", "abizena", new Date(), "hizkuntza", new Date());
    erabiltzailePremium.setPremiumMuga(premiumMuga);
    assertEquals(premiumMuga, erabiltzailePremium.getPremiumMuga());
  }
}