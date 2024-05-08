package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Audio;
import model.metodoak.ImportExportMetodoak;

public class ImportExportMetodoakTest {

    @Test
    public void testExportatuPlaylist() {
        PlayListak pl = new PlayListak();
        pl.setIzena("Test Playlist");
        ImportExportMetodoak.exportatuPlaylist(pl);
    }

    @Test
    public void testImportatuPlaylist() {
        // Call the importatuPlaylist() method
        String[] result = ImportExportMetodoak.importatuPlaylist();

        // TODO: Add assertion to check if the playlist is imported correctly
    }

    @Test
    public void testExportatuAbesti() {
        // Create a dummy Audio object for testing
        Audio a = new Audio();
        a.setIzena("Test Audio");
        a.setIraupena("00:03:30");

        // Call the exportatuAbesti() method
        ImportExportMetodoak.exportatuAbesti(a);

        // TODO: Add assertion to check if the audio is exported correctly
    }
}