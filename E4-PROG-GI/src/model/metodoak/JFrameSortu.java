package model.metodoak;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import model.Abestia;
import model.Album;
import model.Artista;
import model.Audio;
import model.Musikaria;
import model.PlayListak;
import model.Podcast;
import model.Podcasterra;
import view.AbestiaPlayListeanSartu;
import view.AbestiakMusikaria;
import view.AdminMenuNagusia;
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






public class JFrameSortu {

	
	
	
	/**
	 * Adminaren menu nagusia sortzeko metodoa.
	 */
	public static void menuAdminAukeraSortu() {
		
		AdminMenuNagusia adminMenu = new AdminMenuNagusia();
		adminMenu.setVisible(true);
	
	}
	
	
	
	
	/**
	 * Login aukera sortzeko metodoa.
	 */
	public static void loginAukeraSortu() {
		Login loginAukera = new Login();
		loginAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loginAukera.setVisible(true);
	}
	
	/**
	 * Erregistro aukera sortzeko metodoa.
	 */
	public static void erregistroAukeraSortu(){
		Erregistroa erregistroAukera = new Erregistroa();
		erregistroAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroAukera.setVisible(true);
	}
	
	/**
	 * Premium erregistro aukera sortzeko metodoa.
	 */
	public static void premiumErregistroAukeraSortu(){
		ErregistroaPremium PerregistroAukera = new ErregistroaPremium();
		PerregistroAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PerregistroAukera.setVisible(true);
	}
	
	/**
	 * Menu nagusia aukera sortzeko metodoa.
	 */
	public static void menuNagusiaAukeraSortu(){
		MenuNagusia menuNagusiaAukera = new MenuNagusia();
		menuNagusiaAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuNagusiaAukera.setVisible(true);
	}
	
	/**
	 * Nire playlista sortzeko metodoa.
	 */
	public static void nirePlaylistaSortu(){
		NirePlaylista nirePlaylista = new NirePlaylista();
		nirePlaylista.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		nirePlaylista.setVisible(true);
	}
	
	/**
	 * Playlista sortzeko metodoa.
	 */
	public static void playListaSortuSortu(){
		PlayListaSortu playListaSortu = new PlayListaSortu();
		playListaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		playListaSortu.setVisible(true);
	}
	
	/**
	 * Abestiak playlistan gehitzeko metodoa.
	 * @param playlist Playlista
	 */
	public static void playlistAbestiakSortu(PlayListak playlist){
		PlaylistAbestiak playlistAbestiakSortu = new PlaylistAbestiak(playlist);
		playlistAbestiakSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		playlistAbestiakSortu.setVisible(true);
	}
	
	/**
	 * Erreprodukzioa sortzeko metodoa.
	 * @param abestiak Abestiak
	 * @param abestiAukera Abestiaren aukera
	 * @param izenaAlbum Albumaren izena
	 * @throws SQLException SQL errorea
	 */
	public static void erreprodukzioaSortu(Artista artista, ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning, String izenaAlbum, float abiadura) throws SQLException{
		Erreprodukzioa erreprodukzioaSortu = new Erreprodukzioa(artista, abestiak,abestiAukera, isrunning, izenaAlbum, abiadura);
		erreprodukzioaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erreprodukzioaSortu.setVisible(true);
	}
	
	public static void musikaViewSortu(Musikaria musikaria) {
		MusikariView musicariView = new MusikariView(musikaria);
		musicariView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		musicariView.setVisible(true);
	}
	
	public static void abestiakMusikaria(Musikaria musikaria, Album album) {
		AbestiakMusikaria abestiakMusikaria = new AbestiakMusikaria(musikaria,album);
		abestiakMusikaria.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		abestiakMusikaria.setVisible(true);
	}
	
	public static void podcastViewSortu(Podcasterra podcasterra) {
		PodcastView podcastView = new PodcastView(podcasterra);
		podcastView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcastView.setVisible(true);
	}
	
	public static void iragarkiaErreproduzituSortu(Artista artista, ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning, String izenaAlbum) throws SQLException{
		IragarkiaErreproduzitu iragarkiaErreproduzituSortu = new IragarkiaErreproduzitu(artista, abestiak,abestiAukera, isrunning, izenaAlbum);
		iragarkiaErreproduzituSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		iragarkiaErreproduzituSortu.setVisible(true);
	}
	
	public static void abestiaPlayListeanSartuSortu(Audio audio) throws SQLException{
		AbestiaPlayListeanSartu abestiaPlayListeanSartuSortu = new AbestiaPlayListeanSartu(audio);
		abestiaPlayListeanSartuSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		abestiaPlayListeanSartuSortu.setVisible(true);
	}
	
	
}
