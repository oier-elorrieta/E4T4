package view;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.cj.Session;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import model.*;
import model.dao.PlayListakDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbestiaPlayListeanSartu extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;

	public AbestiaPlayListeanSartu(Audio audio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 600, 425);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInfo = new JLabel("Abesti Informazioa:");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblInfo.setBounds(50, 125, 200, 75);
		
		JLabel lblIzena = new JLabel(audio.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblIzena.setBounds(50, 150, 200, 75);
		
		JLabel lblIraupena = new JLabel(audio.getIraupena() + "");
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblIraupena.setBounds(50, 175, 200, 75);
		
		ArrayList<PlayListak> playlistLista = PlayListakDao.getPlaylist();
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		for (int i = 0; i < playlistLista.size(); i++) {
			modeloLista.addElement(playlistLista.get(i).getIzena());
		}
		JList<String> jListPlayList = new JList(modeloLista);
		jListPlayList.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListPlayList);
		jListPlayList.setBounds(300, 150, 250, 200);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		model.SesioAldagaiak.jb = ViewMetodoak.btnErabiltzaileaSortu();
		JButton btnErabiltzaile = model.SesioAldagaiak.jb;
		btnErabiltzaile.setBounds(400, 60, 144, 50);
		
		contentPane.add(lblInfo);
		contentPane.add(lblIzena);
		contentPane.add(lblIraupena);
		contentPane.add(jListPlayList);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.premiumErregistroAukeraSortu();
			}
		});
	}
}