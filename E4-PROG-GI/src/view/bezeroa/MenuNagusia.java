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
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuNagusia extends JFrame {

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

		JLabel lblaukeratu = new JLabel("Aukeratu");
		lblaukeratu.setBounds(198, 11, 452, 58);
		lblaukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblaukeratu.setFont(new Font("Source Sans Pro Black", Font.BOLD, 45));

		JButton btnMusikaDeskubritu = new JButton("Musika Deskubritu");

		btnMusikaDeskubritu.setBounds(150, 175, 550, 54);
		btnMusikaDeskubritu.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnMusikaDeskubritu.setFocusPainted(false);

		JButton btnPodcastDeskubritu = new JButton("Podcast Deskubritu");
		btnPodcastDeskubritu.setBounds(150, 275, 550, 54);
		btnPodcastDeskubritu.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnPodcastDeskubritu.setFocusPainted(false);

		JButton btnNirePlayList = new JButton("Nire PlayList-ak");
		btnNirePlayList.setBounds(150, 375, 550, 54);
		btnNirePlayList.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnNirePlayList.setFocusPainted(false);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		model.SesioAldagaiak.jb = ViewMetodoak.btnErabiltzaileaSortu();
		JButton btnErabiltzaile = model.SesioAldagaiak.jb;
		
		contentPane.add(lblaukeratu);
		contentPane.add(btnMusikaDeskubritu);
		contentPane.add(btnPodcastDeskubritu);
		contentPane.add(btnNirePlayList);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.loginSortu();
			}
		});

		

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});
		
		
		btnMusikaDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusikaDeskubritu MusikaDesk = new MusikaDeskubritu();
				MusikaDesk.setVisible(true);
				dispose();
			}
		});

		btnPodcastDeskubritu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PodcastDeskubritu podcastDeskubritu = new PodcastDeskubritu();
				podcastDeskubritu.setVisible(true);
				dispose();
			}
		});

		btnNirePlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.nirePlaylistaSortu();
			}
		});
	}
}