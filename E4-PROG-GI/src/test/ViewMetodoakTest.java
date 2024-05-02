package test;
import static org.junit.Assert.*;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.SesioAldagaiak;
import model.dao.MusikariaDao;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewMetodoakTest {

    @Test
    public void testKomprobatuAdmin() {
        boolean result = ViewMetodoak.komprobatuAdmin("admin", "headmin");
        assertTrue(result);
    }

    @Test
    public void testCboHizkuntzaModeloaSortu() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> result = ViewMetodoak.cboHizkuntzaModeloaSortu(model);
        assertEquals(8, result.getSize());
    }

    @Test
    public void testComprobatuLogin() {
        boolean result = ViewMetodoak.comprobatuLogin("a", "a");
        assertTrue(result);
    }

    @Test
    public void testErabiltzaileaKargatu() {
        ViewMetodoak.erabiltzaileaKargatu(1, "free");
        assertFalse(SesioAldagaiak.erabiltzailePremium);
    }

    @Test
    public void testBtnErabiltzaileaSortu() {
        JButton result = ViewMetodoak.btnErabiltzaileaSortu();
        assertNotNull(result);
        assertEquals(Color.LIGHT_GRAY, result.getBackground());
        assertEquals(Color.BLACK, result.getForeground());
        assertEquals(new Rectangle(700, 60, 144, 50), result.getBounds());
        assertEquals(new Font("SansSerif", Font.BOLD, 22), result.getFont());
        assertFalse(result.isFocusPainted());
    }



    @Test
    public void testBtnGeneratu() {
        JPanel pane = new JPanel();
        Musikaria m;
        m = MusikariaDao.getMusikaria("Estopa");
        Blob irudia = m.getIrudia();
        String izena = m.getIzena();
        int entzunaldiak = m.getEntzunaldiak();
        JFrame jf = new JFrame();
        ViewMetodoak.btnGeneratu(pane, irudia, izena, entzunaldiak, jf);
        JButton button = (JButton) pane.getComponent(0);
        assertEquals(izena + " Entzunaldiak: " + entzunaldiak, button.getText());
    }

    @Test
    public void testMusikariakEntzunaldiakBotoiarentzako() {
        JPanel pane = new JPanel();
        JFrame jf = new JFrame();
        ViewMetodoak.musikariakEntzunaldiakBotoiarentzako(pane, jf);
        assertEquals(4, pane.getComponentCount());
    }

    @Test
    public void testPodcasterrakEntzunaldiakBotoiarentzako() {
        JPanel pane = new JPanel();
        JFrame jf = new JFrame();
        ViewMetodoak.podcasterrakEntzunaldiakBotoiarentzako(pane, jf);
        assertEquals(2, pane.getComponentCount());
    }

    @Test
    public void testGetMusikariAlbumak() {
        DefaultListModel<Album> result = ViewMetodoak.getMusikariAlbumak("Melendi");
        assertEquals(2, result.getSize());
    }

    @Test
    public void testGetMusikariAbestiak() {
        DefaultListModel<Audio> result = ViewMetodoak.getMusikariAbestiak(5);
        assertEquals(3, result.getSize());
    }

    @Test
    public void testSetIrudia() {
        JLabel lbl = new JLabel();
        Blob m = MusikariaDao.getMusikaria("LiSa").getIrudia();
        ViewMetodoak.setIrudia(lbl, m);
        Icon icon = lbl.getIcon();
        assertNotNull(icon);
        assertEquals(320, icon.getIconWidth());
        assertEquals(320, icon.getIconHeight());
    }

    @Test
    public void testGetPodcastList() {
        ArrayList<Audio> result = ViewMetodoak.getPodcastList("Jordi Wild");
        assertEquals(2, result.size());
    }
}