package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import javax.swing.WindowConstants;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import model.Abestia;
import model.Album;
import model.Artista;
import model.Audio;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Musikaria;
import model.PlayListak;
import model.Podcasterra;
import model.SesioAldagaiak;
import model.dao.AlbumDao;
import model.dao.MusikariaDao;
import model.metodoak.JFrameSortu;
import model.sql.Kone;
import view.AbestiaPlayListeanSartu;
import view.AbestiakMusikaria;
import view.Erregistroa;
import view.ErregistroaPremium;
import view.Erreprodukzioa;
import view.IragarkiaErreproduzitu;
import view.Login;
import view.MenuNagusia;
import view.MusikariView;
import view.NirePlaylista;
import view.PlayListaSortu;
import view.PlaylistAbestiak;
import view.PodcastView;

public class JFrameSortuTest {
	
	private ErabiltzaileFree erabiltzailea;
	private ErabiltzailePremium erabiltzaileaP;

    @Before
    public void setUp() {
    	Kone.kargatuErabiltzaileFree(1);
    	Kone.kargatuErabiltzailePremium(2);
    	erabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaFree;
    	erabiltzaileaP = SesioAldagaiak.erabiltzaileLogeatutaPremium;
    	SesioAldagaiak.logErabiltzailea = erabiltzailea;
    	SesioAldagaiak.jb = null;
    }

    @Test
    public void testLoginAukeraSortu() {
        JFrameSortu.loginAukeraSortu();
    }

    @Test
    public void testErregistroAukeraSortu() {
        JFrameSortu.erregistroAukeraSortu();
    }

    @Test
    public void testPremiumErregistroAukeraSortu() {
        JFrameSortu.premiumErregistroAukeraSortu();
    }

    @Test
    public void testMenuNagusiaAukeraSortu() {
        JFrameSortu.menuNagusiaAukeraSortu();
    }

    @Test
    public void testNirePlaylistaSortu() {
        JFrameSortu.nirePlaylistaSortu();
    }

    @Test
    public void testPlayListaSortuSortu() {
        JFrameSortu.playListaSortuSortu();
    }

    @Test
    public void testPlaylistAbestiakSortu() {
        PlayListak playlist = new PlayListak();
        JFrameSortu.playlistAbestiakSortu(playlist);
    }

    @Test
    public void testErreprodukzioaSortu() throws SQLException {
        Artista artista = new Artista();
        ArrayList<Audio> abestiak = new ArrayList<>();
        int abestiAukera = 0;
        boolean isrunning = false;
        String izenaAlbum = "Album";
        float abiadura = 1.0f;
        JFrameSortu.erreprodukzioaSortu(artista, abestiak, abestiAukera, isrunning, izenaAlbum, abiadura);
        // Verify that the "Playback" frame is created and visible
        // You can add additional assertions if needed
    }

    @Test
    public void testMusikaViewSortu() {
        Musikaria musikaria = new Musikaria();
        JFrameSortu.musikaViewSortu(musikaria);
        // Verify that the "Musician View" frame is created and visible
        // You can add additional assertions if needed
    }

    @Test
    public void testAbestiakMusikaria() {
        Musikaria musikaria = MusikariaDao.getMusikaria("Burnout Syndromes");
        Abestia a = new Abestia();
        a.setIdAudio(1);
        a.setIzena("Fly High");
        a.setIraupena((Time)"00:03:12");
        Album album = AlbumDao.getAlbumByAbesti();
        JFrameSortu.abestiakMusikaria(musikaria, album);
        // Verify that the "Musician Songs" frame is created and visible
        // You can add additional assertions if needed
    }

    @Test
    public void testPodcastViewSortu() {
        Podcasterra podcasterra = new Podcasterra();
        JFrameSortu.podcastViewSortu(podcasterra);
        // Verify that the "Podcast View" frame is created and visible
        // You can add additional assertions if needed
    }

    @Test
    public void testIragarkiaErreproduzituSortu() throws SQLException {
        Artista artista = new Artista();
        ArrayList<Audio> abestiak = new ArrayList<>();
        int abestiAukera = 0;
        boolean isrunning = false;
        String izenaAlbum = "Album";
        JFrameSortu.iragarkiaErreproduzituSortu(artista, abestiak, abestiAukera, isrunning, izenaAlbum);
        // Verify that the "Advertisement Playback" frame is created and visible
        // You can add additional assertions if needed
    }

    @Test
    public void testAbestiaPlayListeanSartuSortu() throws SQLException {
        Audio audio = new Audio();
        JFrameSortu.abestiaPlayListeanSartuSortu(audio);
        // Verify that the "Add Song to Playlist" frame is created and visible
        // You can add additional assertions if needed
    }
}