package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.SesioAldagaiak;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewMetodoakTest {

    @Test
    public void testCboHizkuntzaModeloaSortu() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> result = ViewMetodoak.cboHizkuntzaModeloaSortu(model);
        Assertions.assertEquals(8, result.getSize());
    }

    @Test
    public void testComprobatuLogin() {
        boolean result = ViewMetodoak.comprobatuLogin("a", "a");
        Assertions.assertTrue(result);
    }

    @Test
    public void testErabiltzaileaKargatu() {
        ViewMetodoak.erabiltzaileaKargatu(1, "free");
        Assertions.assertFalse(SesioAldagaiak.erabiltzailePremium);
    }

    @Test
    public void testBtnErabiltzaileaSortu() {
        JButton result = ViewMetodoak.btnErabiltzaileaSortu();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(Color.LIGHT_GRAY, result.getBackground());
        Assertions.assertEquals(Color.BLACK, result.getForeground());
        Assertions.assertEquals(new Rectangle(700, 60, 144, 50), result.getBounds());
        Assertions.assertEquals(new Font("SansSerif", Font.BOLD, 22), result.getFont());
        Assertions.assertFalse(result.isFocusPainted());
    }

    @Test
    public void testKomprobatuAdmin() {
        boolean result = ViewMetodoak.komprobatuAdmin("admin", "admin");
        Assertions.assertTrue(result);
    }

    @Test
    public void testBtnGeneratu() {
        JPanel pane = new JPanel();
        Musikaria m;
        m = Kone.getMusikaria("Estopa");
        Blob irudia = m.getIrudia();
        String izena = m.getIzena();
        int entzunaldiak = m.getEntzunaldiak();
        JFrame jf = new JFrame();
        ViewMetodoak.btnGeneratu(pane, irudia, izena, entzunaldiak, jf);
        JButton button = (JButton) pane.getComponent(0);
        Assertions.assertEquals(izena + " Entzunaldiak: " + entzunaldiak, button.getText());
    }

    @Test
    public void testMusikariakEntzunaldiakBotoiarentzako() {
        JPanel pane = new JPanel();
        JFrame jf = new JFrame();
        ViewMetodoak.musikariakEntzunaldiakBotoiarentzako(pane, jf);
        Assertions.assertEquals(2, pane.getComponentCount());
    }

    @Test
    public void testPodcasterrakEntzunaldiakBotoiarentzako() {
        JPanel pane = new JPanel();
        JFrame jf = new JFrame();
        ViewMetodoak.podcasterrakEntzunaldiakBotoiarentzako(pane, jf);
        Assertions.assertEquals(2, pane.getComponentCount());
    }

    @Test
    public void testGetMusikariAlbumak() {
        DefaultListModel<Album> result = ViewMetodoak.getMusikariAlbumak("Musikari");
        Assertions.assertEquals(2, result.getSize());
    }

    @Test
    public void testGetMusikariAbestiak() {
        DefaultListModel<Audio> result = ViewMetodoak.getMusikariAbestiak(1);
        Assertions.assertEquals(5, result.getSize());
    }

    @Test
    public void testSetIrudia() {
        JLabel lbl = new JLabel();
        Blob m = null;
        ViewMetodoak.setIrudia(lbl, m);
        Icon icon = lbl.getIcon();
        Assertions.assertNotNull(icon);
        Assertions.assertEquals(550, icon.getIconWidth());
        Assertions.assertEquals(500, icon.getIconHeight());
    }

    @Test
    public void testGetPodcastList() {
        ArrayList<Audio> result = ViewMetodoak.getPodcastList("LiSa");
        Assertions.assertEquals(3, result.size());
    }
}