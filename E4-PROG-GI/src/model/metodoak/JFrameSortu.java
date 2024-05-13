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
import view.admin.AdminMenuNagusia;
import view.bezeroa.AbestiaPlayListeanSartu;
import view.bezeroa.AbestiakMusikaria;
import view.bezeroa.Erregistroa;
import view.bezeroa.ErregistroaPremium;
import view.bezeroa.Erreprodukzioa;
import view.bezeroa.IragarkiaErreproduzitu;
import view.bezeroa.Login;
import view.bezeroa.MenuNagusia;
import view.bezeroa.MusikaDeskubritu;
import view.bezeroa.MusikariView;
import view.bezeroa.NirePlaylista;
import view.bezeroa.PlayListaSortu;
import view.bezeroa.PlaylistAbestiak;
import view.bezeroa.PodcastDeskubritu;
import view.bezeroa.PodcastView;






public class JFrameSortu {
	
	
	/**
     * Adminaren menu nagusia sortzeko metodoa.
     */
    public static void menuAdminAukeraSortu() {
        
        AdminMenuNagusia adminMenu = new AdminMenuNagusia();
        adminMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
	public static void premiumErregistroAukeraSortu(JFrame aurrekoFrame){
		ErregistroaPremium PerregistroAukera = new ErregistroaPremium(aurrekoFrame);
		PerregistroAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PerregistroAukera.setVisible(true);
	}
	
	//--------------------
	
	public static void menuNagusiaAukeraSortu(){
		MenuNagusia menuNagusiaAukera = new MenuNagusia();
		menuNagusiaAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuNagusiaAukera.setVisible(true);
	}
	
	public static void musikaDeskubrituSortu(){
		MusikaDeskubritu musikaDeskubrituSortu = new MusikaDeskubritu();
		musikaDeskubrituSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		musikaDeskubrituSortu.setVisible(true);
	}
	
	public static void musikariViewSortu(Musikaria musikaria) {
		MusikariView musicariView = new MusikariView(musikaria);
		musicariView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		musicariView.setVisible(true);
	}
	
	public static void abestiakMusikaria(Musikaria musikaria, Album album) {
		AbestiakMusikaria abestiakMusikaria = new AbestiakMusikaria(musikaria,album);
		abestiakMusikaria.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		abestiakMusikaria.setVisible(true);
	}
	
	public static void podcastDeskubrituSortu() {
		PodcastDeskubritu podcastDeskubrituSortu = new PodcastDeskubritu();
		podcastDeskubrituSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcastDeskubrituSortu.setVisible(true);
	}
	
	public static void podcastViewSortu(Podcasterra podcasterra) {
		PodcastView podcastView = new PodcastView(podcasterra);
		podcastView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		podcastView.setVisible(true);
	}

	public static void nirePlaylistaSortu(){
		NirePlaylista nirePlaylista = new NirePlaylista();
		nirePlaylista.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		nirePlaylista.setVisible(true);
	}
	
	public static void playListaSortuSortu(){
		PlayListaSortu playListaSortu = new PlayListaSortu();
		playListaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		playListaSortu.setVisible(true);
	}
	
	public static void playlistAbestiakSortu(PlayListak playlist){
		PlaylistAbestiak playlistAbestiakSortu = new PlaylistAbestiak(playlist);
		playlistAbestiakSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		playlistAbestiakSortu.setVisible(true);
	}
	
	
	//--------------------

	public static void erreprodukzioaSortu(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning, float abiadura) throws SQLException{
		Erreprodukzioa erreprodukzioaSortu = new Erreprodukzioa(aurrekoKlasea, artista, abestiak,abestiAukera, isrunning, abiadura);
		erreprodukzioaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erreprodukzioaSortu.setVisible(true);
	}
	
	public static void abestiaPlayListeanSartuSortu(Audio audio) throws SQLException{
		AbestiaPlayListeanSartu abestiaPlayListeanSartuSortu = new AbestiaPlayListeanSartu(audio);
		abestiaPlayListeanSartuSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		abestiaPlayListeanSartuSortu.setVisible(true);
	}
		
	public static void iragarkiaErreproduzituSortu(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning) throws SQLException{
		IragarkiaErreproduzitu iragarkiaErreproduzituSortu = new IragarkiaErreproduzitu(aurrekoKlasea, artista, abestiak,abestiAukera, isrunning);
		iragarkiaErreproduzituSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		iragarkiaErreproduzituSortu.setVisible(true);
	}
	
	//--------------------
	
	
	
	
}
