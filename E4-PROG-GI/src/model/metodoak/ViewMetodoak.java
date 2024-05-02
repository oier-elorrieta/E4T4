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

import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;
import model.dao.AlbumDao;
import model.dao.MusikariaDao;
import model.dao.PodcastDao;
import model.dao.PodcasterraDao;
import model.sql.Kone;
import view.MusikariView;
import view.PodcastView;

/**
 * ViewMetodoak klasea aplikazioaren ikuspegia kudeatzeko metodoak dituen klasea da.
 */
public class ViewMetodoak {

	/**
	 * Metodo honek ComboBoxModel bat sortzen du, hizkuntza guztiak gehituz.
	 *
	 * @param modeloa ComboBoxModel bat, hizkuntzak gehitzeko.
	 * @return Sortutako ComboBoxModela.
	 */
	public static DefaultComboBoxModel cboHizkuntzaModeloaSortu(DefaultComboBoxModel modeloa) {
		try {
			Kone.konektatu();
			ResultSet hizkuntzaLista = Kone.hizkuntzakAtera();
			while (hizkuntzaLista.next()) {
				modeloa.addElement(hizkuntzaLista.getString("IdHizkuntza"));
			}
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modeloa;
	}

	/**
	 * Metodo honek erabiltzailearen sartutako erabiltzaile-izena eta pasahitza egiaztatzen du.
	 *
	 * @param erabiltzailea Erabiltzaile-izena.
	 * @param pasahitza Pasahitza.
	 * @return Sartutako erabiltzailea eta pasahitza egiaztatzen badira, true itzultzen du. Bestela, false.
	 */
	public static boolean comprobatuLogin(String erabiltzailea, String pasahitza) {
		boolean loginOK = false;
		try {
			Kone.konektatu();
			ResultSet erabiltzaileInfo = Kone.isLoginaOk(erabiltzailea);
			while (erabiltzaileInfo.next()) {
				if (erabiltzaileInfo.getString("Pasahitza").equals(pasahitza)) {
					loginOK = true;
					erabiltzaileaKargatu(erabiltzaileInfo.getInt("IdBezeroa"), erabiltzaileInfo.getString("Mota"));

				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginOK;
	}

	/**
	 * Metodo honek erabiltzailea kargatzen du, motaren arabera.
	 *
	 * @param id Erabiltzailearen identifikadorea.
	 * @param mota Erabiltzailearen mota ("free" edo "premium").
	 */
	public static void erabiltzaileaKargatu(int id, String mota) {
		switch (mota) {
		case "free":
			Kone.kargatuErabiltzaileFree(id);
			SesioAldagaiak.erabiltzailePremium = false;

			break;
		case "premium":
			Kone.kargatuErabiltzailePremium(id);
			SesioAldagaiak.erabiltzailePremium = true;
			break;
		}
	}

	/**
	 * Metodo honek JButton bat sortzen du, erabiltzailea sortzeko.
	 *
	 * @return Sortutako JButtona.
	 */
	public static JButton btnErabiltzaileaSortu() {
		JButton btnErabiltzaile = null;
		if (!SesioAldagaiak.erabiltzailePremium) {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaFree.getIzena());
			SesioAldagaiak.logErabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaFree;
		} else {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaPremium.getIzena());
			SesioAldagaiak.logErabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaPremium;
		}
		btnErabiltzaile.setBackground(Color.LIGHT_GRAY);
		btnErabiltzaile.setForeground(Color.BLACK);
		btnErabiltzaile.setBounds(700, 60, 144, 50);
		btnErabiltzaile.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnErabiltzaile.setFocusPainted(false);
		return btnErabiltzaile;
	}

	/**
	 * Metodo honek erabiltzailea eta pasahitza egiaztatzen du, administrazioa egiteko.
	 *
	 * @param user Erabiltzaile-izena.
	 * @param pass Pasahitza.
	 * @return Sartutako erabiltzailea eta pasahitza egiaztatzen badira, true itzultzen du. Bestela, false.
	 */
	public static boolean komprobatuAdmin(String user, String pass) {
		return Kone.konektatuAdmin(user, pass);
	}

	/**
	 * Metodo honek JButton bat sortzen du, musikariaren irudia eta entzunaldi kopurua erakusteko.
	 *
	 * @param pane JPanel bat, botoiak gehitzeko.
	 * @param irudia Musikariaren irudia.
	 * @param izena Musikariaren izena.
	 * @param entzunaldiak Musikariaren entzunaldi kopurua.
	 * @param jf JFrame bat, berriz kargatzeko.
	 */
	public static void btnGeneratu(JPanel pane, Blob irudia, String izena, int entzunaldiak, JFrame jf) {
		JButton newButton = new JButton();
		newButton.setText(izena + " Entzunaldiak: " + entzunaldiak);

		try {
			ImageIcon icono = new ImageIcon(irudia.getBytes(1, (int) irudia.length()));
			newButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MusikariView mv = new MusikariView(izena);
					mv.setVisible(true);
					jf.dispose();
				}
			});

			// Escala la imagen al tamaño deseado
			Image imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

			// Crea un nuevo ImageIcon con la imagen escalada
			ImageIcon iconoEscalado = new ImageIcon(imagen);
			newButton.setIcon(iconoEscalado);

			pane.add(newButton);

			// Se actualiza el layout del panel para que se ajuste automáticamente
			pane.revalidate();
			pane.repaint();

		} catch (SQLException e) {
			e.getMessage();
		}

	}

	/**
	 * Metodo honek JPanel batean musikarien entzunaldiak erakusteko botoiak sortzen ditu.
	 *
	 * @param pane JPanel bat, botoiak gehitzeko.
	 * @param jf JFrame bat, berriz kargatzeko.
	 */
	public static void musikariakEntzunaldiakBotoiarentzako(JPanel pane, JFrame jf) {
		
		ResultSet rs = MusikariaDao.getMusikariakEntzunaldiak();
		//ResultSet rs = Kone.getMusikariakEntzunaldiak();
		try {
			while (rs.next()) {

				String izena = rs.getString("Izena");
				int entzunaldiak = rs.getInt("Totala");
				Blob irudia = rs.getBlob("Irudia");
				btnGeneratu(pane, irudia, izena, entzunaldiak, jf);
			}
		} catch (SQLException e) {

		}
	}

	/**
	 * Metodo honek JPanel batean podcasterrak entzunaldiak erakusteko botoiak sortzen ditu.
	 *
	 * @param pane JPanel bat, botoiak gehitzeko.
	 * @param jf JFrame bat, berriz kargatzeko.
	 */
	public static void podcasterrakEntzunaldiakBotoiarentzako(JPanel pane, JFrame jf) {
		ResultSet rs = PodcasterraDao.getPodcasterEntzunaldiak();
		//ResultSet rs = Kone.getPodcasterEntzunaldiak();
		try {
			while (rs.next()) {

				String izena = rs.getString("Izena");
				int entzunaldiak = rs.getInt("Totala");
				Blob irudia = rs.getBlob("Irudia");
				btnGeneratuPodcaster(pane, irudia, izena, entzunaldiak, jf);
			}
		} catch (SQLException e) {

		}
	}

	/**
	 * Metodo honek JButton bat sortzen du, podcasterraren irudia eta entzunaldi kopurua erakusteko.
	 *
	 * @param pane JPanel bat, botoiak gehitzeko.
	 * @param irudia Podcasterraren irudia.
	 * @param izena Podcasterraren izena.
	 * @param entzunaldiak Podcasterraren entzunaldi kopurua.
	 * @param jf JFrame bat, berriz kargatzeko.
	 */
	public static void btnGeneratuPodcaster(JPanel pane, Blob irudia, String izena, int entzunaldiak, JFrame jf) {
		JButton newButton = new JButton();
		newButton.setText(izena + " Entzunaldiak: " + entzunaldiak);
		try {
			ImageIcon icono = new ImageIcon(irudia.getBytes(1, (int) irudia.length()));
			newButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PodcastView mv = new PodcastView(izena);
					mv.setVisible(true);
					jf.dispose();
				}
			});

			// Escala la imagen al tamaño deseado
			Image imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

			// Crea un nuevo ImageIcon con la imagen escalada
			ImageIcon iconoEscalado = new ImageIcon(imagen);
			newButton.setIcon(iconoEscalado);

			pane.add(newButton);

			// Se actualiza el layout del panel para que se ajuste automáticamente
			pane.revalidate();
			pane.repaint();

		} catch (SQLException e) {
			e.getMessage();
		}

	}

	/**
	 * Metodo honek musikariaren albumak lortzen ditu eta DefaultListModel bat itzultzen du.
	 *
	 * @param izena Musikariaren izena.
	 * @return Musikariaren albumak dituen DefaultListModel bat.
	 */
	public static DefaultListModel<Album> getMusikariAlbumak(String izena) {

		DefaultListModel<Album> lm = new DefaultListModel();
		Musikaria musikari = MusikariaDao.getMusikaria(izena);
		ArrayList<Album> albumak = AlbumDao.getAlbumak(musikari);
		AlbumDao.beteAlbumakKantaKop(albumak);

		for (Album i : albumak) {
			lm.addElement(i);
		}

		return lm;
	}

	/**
	 * Metodo honek musikariaren abestiak lortzen ditu eta DefaultListModel bat itzultzen du.
	 *
	 * @param idAlbum Albumaren identifikadorea.
	 * @return Musikariaren abestiak dituen DefaultListModel bat.
	 */
	public static DefaultListModel<Audio> getMusikariAbestiak(int idAlbum) {

		DefaultListModel<Audio> lm = new DefaultListModel();
		ArrayList<Audio> abestiak = AbestiaDao.getAbestiak(idAlbum);
	
		for (Audio i : abestiak) {
			lm.addElement(i);
		}

		return lm;
	}

	/**
	 * Metodo honek irudia jartzen du JLabel batean.
	 *
	 * @param lbl JLabel bat, irudia jartzeko.
	 * @param m Irudia gordetzen duen Blob objektua.
	 */
	public static void setIrudia(JLabel lbl, Blob m) {

		try {
			ImageIcon icon = new ImageIcon(m.getBytes(1, (int) m.length()));
			Image imagen = icon.getImage().getScaledInstance(550, 500, Image.SCALE_SMOOTH);
			ImageIcon iconoEscalado = new ImageIcon(imagen);
			lbl.setIcon(iconoEscalado);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	/**
	 * Metodo honek podcasterraren abestiak lortzen ditu eta ArrayList bat itzultzen du.
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

}
