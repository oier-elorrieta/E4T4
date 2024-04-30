package model.metodoak;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.WindowConstants;

import model.Abestia;
import model.Audio;
import model.PlayListak;
import model.Podcast;
import view.Erregistroa;
import view.ErregistroaPremium;
import view.Erreprodukzioa;
import view.Login;
import view.MenuNagusia;
import view.NirePlaylista;
import view.PlayListaSortu;
import view.PlaylistAbestiak;

public class JFrameSortu {

	public static void loginAukeraSortu() {
		Login loginAukera = new Login();
		loginAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loginAukera.setVisible(true);
	}
	
	public static void erregistroAukeraSortu(){
		Erregistroa erregistroAukera = new Erregistroa();
		erregistroAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroAukera.setVisible(true);
	}
	
	public static void premiumErregistroAukeraSortu(){
		ErregistroaPremium PerregistroAukera = new ErregistroaPremium();
		PerregistroAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		PerregistroAukera.setVisible(true);
	}
	
	public static void menuNagusiaAukeraSortu(){
		MenuNagusia menuNagusiaAukera = new MenuNagusia();
		menuNagusiaAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menuNagusiaAukera.setVisible(true);
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
	
	public static void erreprodukzioaSortu(ArrayList<Audio> abestiak, int abestiAukera) throws SQLException{
		Erreprodukzioa erreprodukzioaSortu = new Erreprodukzioa(abestiak,abestiAukera);
		erreprodukzioaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erreprodukzioaSortu.setVisible(true);
	}
	
	/*public static void erreprodukzioaSortuPodcast(ArrayList<Podcast> podcast, int podcastAukera) throws SQLException{
		Erreprodukzioa erreprodukzioaSortu = new Erreprodukzioa(podcast,podcastAukera,"podcast");
		erreprodukzioaSortu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erreprodukzioaSortu.setVisible(true);
	}*/
}
