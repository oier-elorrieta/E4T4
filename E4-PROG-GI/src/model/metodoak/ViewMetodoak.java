package model.metodoak;

import model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import model.dao.AbestiaDao;
import model.dao.AlbumDao;
import model.dao.ErabiltzaileFreeDao;
import model.dao.ErabiltzailePremiumDao;
import model.dao.ErabiltzaileaDao;
import model.dao.MusikariaDao;
import model.dao.PodcastDao;
import model.dao.PodcasterraDao;
import model.sql.Kone;
import view.bezeroa.IragarkiaErreproduzitu;
import view.bezeroa.musikaDeskubritu.AlbumakView;
import view.bezeroa.podcastDeskubritu.PodcastakView;

/**
 * ViewMetodoak klasea aplikazioaren ikuspegia kudeatzeko metodoak dituen klasea
 * da.
 */
public class ViewMetodoak {

	/**
	 * Metodo honek erabiltzailearen sartutako erabiltzaile-izena eta pasahitza
	 * egiaztatzen du.
	 *
	 * @param erabiltzailea Erabiltzaile-izena.
	 * @param pasahitza     Pasahitza.
	 * @return Sartutako erabiltzailea eta pasahitza egiaztatzen badira, true
	 *         itzultzen du. Bestela, false.
	 */
	public static boolean comprobatuLogin(String erabiltzailea, String pasahitza) {
		boolean loginOK = false;
				
		Erabiltzailea erabiltzaileInfo = ErabiltzaileaDao.isLoginaOk(erabiltzailea);
		if (erabiltzaileInfo != null) {
			String mota = ErabiltzaileaDao.erabiltzaileMota(erabiltzaileInfo);
			if (erabiltzaileInfo.getPasahitza().equals(pasahitza)) {
				loginOK = true;
				erabiltzaileaKargatu(erabiltzaileInfo.getIdErabiltzailea(), mota);
		}
		}
		
		return loginOK;
	}

	/**
	 * Metodo honek erabiltzailea kargatzen du, motaren arabera.
	 *
	 * @param id   Erabiltzailearen identifikadorea.
	 * @param mota Erabiltzailearen mota ("free" edo "premium").
	 */
	public static void erabiltzaileaKargatu(int id, String mota) {
		switch (mota) {
		case "free":
			ErabiltzaileFreeDao.kargatuErabiltzaileFree(id);
			//SesioAldagaiak.erabiltzailePremium = false;

			break;
		case "premium":
			ErabiltzailePremiumDao.kargatuErabiltzailePremium(id);
			//SesioAldagaiak.erabiltzailePremium = true;
			break;
		}
	}

	/**
	 * Metodo honek JButton bat sortzen du, erabiltzailea sortzeko.
	 *
	 * @return Sortutako JButtona.
	 */
	public static JButton btnErabiltzaileaSortu() {
		JButton btnErabiltzaile = new JButton(SesioAldagaiak.logErabiltzailea.getIzena());
		btnErabiltzaile.setBackground(Color.LIGHT_GRAY);
		btnErabiltzaile.setForeground(Color.BLACK);
		btnErabiltzaile.setBounds(700, 60, 144, 50);
		btnErabiltzaile.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnErabiltzaile.setFocusPainted(false);
		return btnErabiltzaile;
	}
	
	public static JButton btnAtzeraSortu() {
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.LIGHT_GRAY);
		btnAtzera.setForeground(Color.BLACK);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);
		return btnAtzera;
	}

	/**
	 * Metodo honek erabiltzailea eta pasahitza egiaztatzen du, administrazioa
	 * egiteko.
	 *
	 * @param user Erabiltzaile-izena.
	 * @param pass Pasahitza.
	 * @return Sartutako erabiltzailea eta pasahitza egiaztatzen badira, true
	 *         itzultzen du. Bestela, false.
	 */
	public static boolean komprobatuAdmin(String user, String pass) {
		return Kone.konektatuAdminKomprobatu(user, pass);
	}

	/**
	 * Metodo honek JButton bat sortzen du, musikariaren irudia eta entzunaldi
	 * kopurua erakusteko.
	 *
	 * @param pane         JPanel bat, botoiak gehitzeko.
	 * @param irudia       Musikariaren irudia.
	 * @param izena        Musikariaren izena.
	 * @param entzunaldiak Musikariaren entzunaldi kopurua.
	 * @param jf           JFrame bat, berriz kargatzeko.
	 */
	public static void btnGeneratu(JPanel pane,Musikaria musikaria, JFrame jf) {
		
		Musikaria musikariaPasatu = MusikariaDao.getMusikaria(musikaria.getIzena());
		
		JButton newButton = new JButton();
		newButton.setText(musikaria.getIzena() + " Entzunaldiak: " + musikaria.getEntzunaldiak());
		ImageIcon iconoEscalado;
		ImageIcon icono;
		Image imagen;
		
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameSortu.albumakViewSortu(musikaria);
				jf.dispose();
			}
		});
		
		try {

			icono = new ImageIcon(musikaria.getIrudia().getBytes(1, (int) musikaria.getIrudia().length()));
			imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			iconoEscalado = new ImageIcon(imagen);
			newButton.setIcon(iconoEscalado);

			

		} catch (Exception e) {
			
			icono = new ImageIcon("src\\DefaultImg\\default.jpg");
			imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			iconoEscalado = new ImageIcon(imagen);
			newButton.setIcon(iconoEscalado);
		}
		
		pane.add(newButton);
		pane.revalidate();
		pane.repaint();

	}

	/**
	 * Metodo honek JPanel batean musikarien entzunaldiak erakusteko botoiak sortzen
	 * ditu.
	 *
	 * @param pane JPanel bat, botoiak gehitzeko.
	 * @param jf   JFrame bat, berriz kargatzeko.
	 */
	public static void musikariakEntzunaldiakBotoiarentzako(JPanel pane, JFrame jf) {
		ArrayList<Musikaria> musikariak = MusikariaDao.getMusikariakEntzunaldiak();		
			for (int i = 0; i < musikariak.size(); i++) {
				btnGeneratu(pane,musikariak.get(i), jf);
			}				
	}
	/**
	 * Metodo honek JPanel batean podcasterrak entzunaldiak erakusteko botoiak
	 * sortzen ditu.
	 *
	 * @param pane JPanel bat, botoiak gehitzeko.
	 * @param jf   JFrame bat, berriz kargatzeko.
	 */
	public static void podcasterrakEntzunaldiakBotoiarentzako(JPanel pane, JFrame jf) {
		ArrayList<Podcasterra> podcasterrak = PodcasterraDao.getPodcasterEntzunaldiak();
		for (int i = 0; i < podcasterrak.size(); i++) {
			btnGeneratuPodcaster(pane,podcasterrak.get(i), jf);
		}
	}

	/**
	 * Metodo honek JButton bat sortzen du, podcasterraren irudia eta entzunaldi
	 * kopurua erakusteko.
	 *
	 * @param pane         JPanel bat, botoiak gehitzeko.
	 * @param irudia       Podcasterraren irudia.
	 * @param izena        Podcasterraren izena.
	 * @param entzunaldiak Podcasterraren entzunaldi kopurua.
	 * @param jf           JFrame bat, berriz kargatzeko.
	 */
	public static void btnGeneratuPodcaster(JPanel pane, Podcasterra podcasterra, JFrame jf) {
		JButton newButton = new JButton();
		newButton.setText(podcasterra.getIzena() + " Entzunaldiak: " + podcasterra.getEntzunaldiak());
		try {
			ImageIcon icono = new ImageIcon(podcasterra.getIrudia().getBytes(1, (int) podcasterra.getIrudia().length()));
			newButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				JFrameSortu.podcastakViewSortu(podcasterra);
					jf.dispose();
				}
			});

		
			Image imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

			
			ImageIcon iconoEscalado = new ImageIcon(imagen);
			newButton.setIcon(iconoEscalado);

			pane.add(newButton);

			
			pane.revalidate();
			pane.repaint();

		} catch (SQLException e) {
			e.getMessage();
		}

	}

	/**
	 * Metodo honek musikariaren albumak lortzen ditu eta DefaultListModel bat
	 * itzultzen du.
	 *
	 * @param izena Musikariaren izena.
	 * @return Musikariaren albumak dituen DefaultListModel bat.
	 */
	public static DefaultListModel<Album> getMusikariAlbumak(String izena) {

		DefaultListModel<Album> lm = new DefaultListModel();
		Musikaria musikari = MusikariaDao.getMusikaria(izena);
		ArrayList<Album> albumak = AlbumDao.getAlbumakByMusikari(musikari);
		AlbumDao.beteAlbumakKantaKop(albumak);

		for (Album i : albumak) {
			lm.addElement(i);
		}

		return lm;
	}

	
	/**
	 * Metodo honek irudia jartzen du JLabel batean.
	 *
	 * @param lbl JLabel bat, irudia jartzeko.
	 * @param m   Irudia gordetzen duen Blob objektua.
	 */
	public static void setIrudia(JLabel lbl, Blob m) {

		try {
			ImageIcon icon = new ImageIcon(m.getBytes(1, (int) m.length()));
			lbl.setIcon(icon);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	/**
	 * Metodo honek podcasterraren abestiak lortzen ditu eta ArrayList bat itzultzen
	 * du.
	 *
	 * @param izena Podcasterraren izena.
	 * @return Podcasterraren abestiak dituen ArrayList bat.
	 */
	public static ArrayList<Audio> getPodcastList(String izena) {
		ArrayList<Audio> podcastList = new ArrayList<Audio>();
		Podcasterra podcaster = PodcasterraDao.getPodcasterra(izena);
		podcastList = PodcastDao.getPodcastak(podcaster);
		return podcastList;
	}

	public static void skipBaimendu() {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				SesioAldagaiak.doSkip = true;
			}
		};
		timer.schedule(task, 10000);
	}
	
	public static String kalkulatuIraupena(int seg) {
		boolean b = false;
		int h = 0;
		int min = 0;
		String hString;
		String minString;
		String segString;
		String iraupena;
		
		do {
			b = false;
			if (seg >= 60) {
				min++;
				seg = seg - 60;
				b = true;
				}
			if (min>=60) {
				h++;
				min = min - 60;
				b=true;
			}
		} while (b);
		
		hString = iraupenaToString(h);
		minString = iraupenaToString(min);
		segString = iraupenaToString(seg);
		
		iraupena = hString + ":" + minString + ":" + segString;
		return iraupena;
	}
	
	public static String iraupenaToString(int zbk) {
		String zbkString;
		if (zbk < 10) {
			zbkString = "0" + zbk;
		} else {
			zbkString = zbk + "";
		}
		return zbkString;
	}
	
	
	private boolean Balidatu(Erabiltzailea e) {
		
		boolean ondo = true;
		 
		return ondo;
			
		}
}
