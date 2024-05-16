package view.bezeroa;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.Session;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import model.*;
import model.Interfazeak.IAtzeraIzan;
import model.Interfazeak.IProfilaIzan;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;
import view.bezeroa.musikaDeskubritu.MusikariakView;
import view.bezeroa.podcastDeskubritu.PodcasterrakView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuNagusia extends JFrame implements IAtzeraIzan, IProfilaIzan {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	private JFrame frame = this;

	public MenuNagusia() {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// lbl Aukeratu atera
		JLabel lblAukeratu = new JLabel("Aukeratu");
		lblAukeratu.setBounds(198, 11, 452, 58);
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Source Sans Pro Black", Font.BOLD, 45));

		// Musika Deskubritu botoia
		JButton btnMusikaDeskubritu = new JButton("Musika Deskubritu");
		btnMusikaDeskubritu.setBounds(150, 175, 550, 54);
		btnMusikaDeskubritu.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnMusikaDeskubritu.setFocusPainted(false);

		//Podcast Deskubritu botoia
		JButton btnPodcastDeskubritu = new JButton("Podcast Deskubritu");
		btnPodcastDeskubritu.setBounds(150, 275, 550, 54);
		btnPodcastDeskubritu.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnPodcastDeskubritu.setFocusPainted(false);

		//Nire PlayLista botoia
		JButton btnNirePlayList = new JButton("Nire PlayList-ak");
		btnNirePlayList.setBounds(150, 375, 550, 54);
		btnNirePlayList.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnNirePlayList.setFocusPainted(false);

		// Erabiltzailearen datuak aldatzeko botoia
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();

		// Aurreko pantallara joan
		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		contentPane.add(lblAukeratu);
		contentPane.add(btnMusikaDeskubritu);
		contentPane.add(btnPodcastDeskubritu);
		contentPane.add(btnNirePlayList);
		contentPane.add(btnErabiltzaile);
		contentPane.add(btnAtzera);
		
		//Musika deskubritu ematean, Musikari listaren jframera deitu
		btnMusikaDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusikariakView MusikaDesk = new MusikariakView();
				MusikaDesk.setVisible(true);
				dispose();
			}
		});

		//Podcast deskubritu ematean, Podcasterra listaren jframera deitu
		btnPodcastDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PodcasterrakView podcastDeskubritu = new PodcasterrakView();
				podcastDeskubritu.setVisible(true);
				dispose();
			}
		});

		//Nire Playlist ematean, Musikari listaren jframera deitu
		btnNirePlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.playListakViewSortu();
			}
		});

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.loginSortu();
			}
		});
	}
}