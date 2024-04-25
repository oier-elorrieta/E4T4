package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Abestia;
import model.PlayListak;
import model.SesioAldagaiak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class PlaylistAbestiak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PlaylistAbestiak(PlayListak aukeraPlaylist) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Abestia> abestiakList = Kone.getPlayListAbestiak(aukeraPlaylist);
		
		DefaultListModel<Abestia> modeloLista = new DefaultListModel<>();
		for (int i = 0; i < abestiakList.size(); i++) {
			modeloLista.addElement(abestiakList.get(i));
		}
		JList<Abestia> jListAbestiak = new JList(modeloLista);
		jListAbestiak.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListAbestiak);
		jListAbestiak.setBounds(50, 150, 550, 350);
		
		JButton btnErreproduzitu= new JButton("Erreproduzitu");
		btnErreproduzitu.setBounds(650, 225, 208, 50);
		btnErreproduzitu.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JButton btnKompartitu= new JButton("Kompartitu");
		btnKompartitu.setBounds(650, 300, 208, 50);
		btnKompartitu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBounds(650, 375, 208, 50);
		btnEzabatu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);
		
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();
		
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.nirePlaylistaSortu();
			}
		});
		
		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SesioAldagaiak.erabiltzaileLogeatutaFree = null;
				SesioAldagaiak.erabiltzaileLogeatutaPremium = null;
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});
		
		contentPane.add(jListAbestiak);
		contentPane.add(btnErreproduzitu);
		contentPane.add(btnKompartitu);
		contentPane.add(btnEzabatu);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

	}

}
