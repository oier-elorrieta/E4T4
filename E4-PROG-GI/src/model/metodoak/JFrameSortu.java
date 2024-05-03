package model.metodoak;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import model.Abestia;
import model.Audio;
import model.PlayListak;
import model.Podcast;
import view.AbestiaPlayListeanSartu;
import view.Erregistroa;
import view.ErregistroaPremium;
import view.Erreprodukzioa;
import view.IragarkiaErreproduzitu;
import view.Login;
import view.MenuNagusia;
import view.NirePlaylista;
import view.PlayListaSortu;
import view.PlaylistAbestiak;






public class JFrameSortu {

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
	public static void erreprodukzioaSortu(ArrayList<Audio> abestiak, int abestiAukera, String izenaAlbum, float abiadura) throws SQLException{
		Erreprodukzioa erreprodukzioaSortu = new Erreprodukzioa(abestiak,abestiAukera,izenaAlbum, abiadura);
		erreprodukzioaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erreprodukzioaSortu.setVisible(true);
	}
	
	public static void iragarkiaErreproduzituSortu(ArrayList<Audio> abestiak, int abestiAukera, String izenaAlbum) throws SQLException{
		IragarkiaErreproduzitu iragarkiaErreproduzituSortu = new IragarkiaErreproduzitu(abestiak,abestiAukera,izenaAlbum);
		iragarkiaErreproduzituSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		iragarkiaErreproduzituSortu.setVisible(true);
	}
	
	public static void abestiaPlayListeanSartuSortu(Audio audio) throws SQLException{
		AbestiaPlayListeanSartu abestiaPlayListeanSartuSortu = new AbestiaPlayListeanSartu(audio);
		abestiaPlayListeanSartuSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		abestiaPlayListeanSartuSortu.setVisible(true);
	}
}
