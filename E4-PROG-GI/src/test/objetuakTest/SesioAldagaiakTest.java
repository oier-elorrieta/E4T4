package test.objetuakTest;
import static org.junit.Assert.*;

import java.util.Date;

import javax.swing.JButton;

import org.junit.Test;

import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Erabiltzailea;
import model.SesioAldagaiak;

public class SesioAldagaiakTest {

    @Test
    public void testGetLogErabiltzailea() {
        SesioAldagaiak.logErabiltzailea = new Erabiltzailea();
        assertNotNull(SesioAldagaiak.logErabiltzailea);
    }

    @Test
    public void testGetJb() {
        SesioAldagaiak.jb = new JButton();
        assertNotNull(SesioAldagaiak.jb);
    }

}