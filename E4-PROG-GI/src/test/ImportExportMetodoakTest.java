package test;

import static org.junit.Assert.*;

import java.sql.Time;

import org.junit.Test;

import model.Audio;
import model.PlayListak;
import model.metodoak.ImportExportMetodoak;
import model.sql.Kone;

public class ImportExportMetodoakTest {

    @Test
    public void testExportatuPlaylist() {
    	Kone.kargatuErabiltzaileFree(1);
        PlayListak pl = new PlayListak();
        pl.setIzena("Lo egiteko");
        ImportExportMetodoak.exportatuPlaylist(pl);
    }

    @Test
    public void testImportatuPlaylist() {
        String[] result = ImportExportMetodoak.importatuPlaylist();
        assertEquals(result[0],"Lo egiteko");
    }

    @Test
    public void testExportatuAbesti() {
        Audio a = new Audio();
        a.setIdAudio(1);
        a.setIzena("Fly High");
        Time t = new Time(0,3,12);
        a.setIraupena(t);
        ImportExportMetodoak.exportatuAbesti(a);
    }
}