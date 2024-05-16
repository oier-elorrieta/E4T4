package model.metodoak;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import model.Abestia;
import model.Album;
import model.Artista;
import model.Audio;
import model.Musikaria;
import model.PlayListak;
import model.Podcast;
import model.Podcasterra;
import view.admin.AbestiakKudeatu;
import view.admin.AdminMenuNagusia;
import view.admin.AlbumakKudeatu;
import view.admin.MusikaKudeatu;
import view.bezeroa.MenuErreprodukzioa;
import view.bezeroa.Erregistroa;
import view.bezeroa.ErregistroaPremium;
import view.bezeroa.Erreprodukzioa;
import view.bezeroa.IragarkiaErreproduzitu;
import view.bezeroa.Login;
import view.bezeroa.MenuNagusia;
import view.bezeroa.musikaDeskubritu.AbestiakView;
import view.bezeroa.musikaDeskubritu.AlbumakView;
import view.bezeroa.musikaDeskubritu.MusikariakView;
import view.bezeroa.nirePlayListak.PlayListAbestiakView;
import view.bezeroa.nirePlayListak.PlayListaSortuView;
import view.bezeroa.nirePlayListak.PlayListakView;
import view.bezeroa.podcastDeskubritu.PodcastakView;
import view.bezeroa.podcastDeskubritu.PodcasterrakView;

public class JFrameSortu{
	
	/*-----------------------LOGIN-----------------------*/
	
	public static void erregistroAukeraSortu() {
		Erregistroa erregistroAukera = new Erregistroa();
		erregistroAukera.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		erregistroAukera.setVisible(true);
	}

	public static void premiumErregistroAukeraSortu(JFrame aurrekoFrame) {
		ErregistroaPremium PerregistroAukera = new ErregistroaPremium(aurrekoFrame);
		PerregistroAukera.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		PerregistroAukera.setVisible(true);
	}

	public static void loginSortu() {
		Login loginAukera = new Login();
		loginAukera.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		loginAukera.setVisible(true);
	}

	/*-----------------------BEZEROA-----------------------*/

	public static void menuNagusiaAukeraSortu() {
		MenuNagusia menuNagusiaAukera = new MenuNagusia();
		menuNagusiaAukera.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuNagusiaAukera.setVisible(true);
	}

	public static void musikariakViewSortu() {
		MusikariakView musikariakView = new MusikariakView();
		musikariakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		musikariakView.setVisible(true);
	}

	public static void albumakViewSortu(Musikaria musikaria) {
		AlbumakView albumakView = new AlbumakView(musikaria);
		albumakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		albumakView.setVisible(true);
	}

	public static void abestiakViewSortu(Musikaria musikaria, Album album) {
		AbestiakView abestiakView = new AbestiakView(musikaria, album);
		abestiakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		abestiakView.setVisible(true);
	}

	public static void podcasterrakViewSortu() {
		PodcasterrakView podcasterrakView = new PodcasterrakView();
		podcasterrakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		podcasterrakView.setVisible(true);
	}

	public static void podcastakViewSortu(Podcasterra podcasterra) {
		PodcastakView podcastakView = new PodcastakView(podcasterra);
		podcastakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		podcastakView.setVisible(true);
	}

	public static void playListakViewSortu() {
		PlayListakView playListakView = new PlayListakView();
		playListakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		playListakView.setVisible(true);
	}

	public static void playListaSortuViewSortu() {
		PlayListaSortuView playListaSortuView = new PlayListaSortuView();
		playListaSortuView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		playListaSortuView.setVisible(true);
	}

	public static void playListAbestiakViewSortu(PlayListak playlist) {
		PlayListAbestiakView playListAbestiakView = new PlayListAbestiakView(playlist);
		playListAbestiakView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		playListAbestiakView.setVisible(true);
	}

	public static void erreprodukzioaSortu(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak,
			int abestiAukera, boolean isrunning, float abiadura) throws SQLException {
		Erreprodukzioa erreprodukzioaSortu = new Erreprodukzioa(aurrekoKlasea, artista, abestiak, abestiAukera,
				isrunning, abiadura);
		erreprodukzioaSortu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		erreprodukzioaSortu.setVisible(true);
	}

	public static void menuErreprodukzioaSortu(Audio audio) throws SQLException {
		MenuErreprodukzioa menuErreprodukzioa = new MenuErreprodukzioa(audio);
		menuErreprodukzioa.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuErreprodukzioa.setVisible(true);
	}

	public static void iragarkiaErreproduzituSortu(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak,
			int abestiAukera, boolean isrunning) throws SQLException {
		IragarkiaErreproduzitu iragarkiaErreproduzituSortu = new IragarkiaErreproduzitu(aurrekoKlasea, artista,
				abestiak, abestiAukera, isrunning);
		iragarkiaErreproduzituSortu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		iragarkiaErreproduzituSortu.setVisible(true);
	}

	/*------------------------ADMIN------------------------*/

	public static void menuAdminAukeraSortu() {
		AdminMenuNagusia adminMenu = new AdminMenuNagusia();
		adminMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		adminMenu.setVisible(true);
	}
	
public static void musikaKudeatuAukeraSortu() {
        MusikaKudeatu musikaKude = new MusikaKudeatu();
        musikaKude.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        musikaKude.setVisible(true);
    
    }

public static void albumakKudeatuAukeraSortu(String izena) {
	
	AlbumakKudeatu ak = new AlbumakKudeatu(izena);
	ak.setVisible(true);
}


public static void abestiakKudeatuAukeraSortu(Album albuma) {
	
	AbestiakKudeatu abk = new AbestiakKudeatu(albuma);
	abk.setVisible(true);
}
}


