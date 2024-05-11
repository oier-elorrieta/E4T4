package view.bezeroa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Album;
import model.Audio;
import model.Podcast;
import model.Podcasterra;
import model.dao.PodcasterraDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;

public class PodcastView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIzena;

	public PodcastView(Podcasterra podcasterra) {
		String klasea = this.getClass().getSimpleName();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnErabiltzaile = model.SesioAldagaiak.jb;
		btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.premiumErregistroAukeraSortu();
			}
		});

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		contentPane.add(btnErabiltzaile);
		contentPane.setLayout(null);
		contentPane.add(btnAtzera);

		JPanel panel = new JPanel();
		panel.setBounds(10, 152, 359, 389);
		contentPane.add(panel);
		ArrayList<Audio> podcastak = ViewMetodoak.getPodcastList(podcasterra.getIzena());
		DefaultListModel<String> modeloList = new DefaultListModel<>();
		for (int i = 0; i < podcastak.size(); i++) {
			modeloList.addElement(podcastak.get(i).getIzena());
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JList list = new JList(modeloList);
		list.setBounds(100, 5, 0, 0);

		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(373, 121, 469, 223);
		contentPane.add(panel_1);

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);

		// irudia seteatu lbl-ari
		Podcasterra podcaster = PodcasterraDao.getPodcasterra(podcasterra.getIzena());
		ViewMetodoak.setIrudia(lblNewLabel, podcaster.getIrudia());

		// Deskripzioa
		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane_1 = new JScrollPane(textPane);
		textPane.setText(podcaster.getDeskription());
		scrollPane_1.setBounds(373, 378, 469, 166);
		contentPane.add(scrollPane_1);

		// Izena lbl
		lblIzena = new JLabel("");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIzena.setText(podcaster.getIzena());
		lblIzena.setBounds(373, 63, 295, 38);
		contentPane.add(lblIzena);

		JLabel lblLista = new JLabel("Aukeratu Podcasta: ");
		lblLista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLista.setBounds(111, 127, 162, 14);
		contentPane.add(lblLista);

		// Agregar un ListSelectionListener a la lista
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int podcastAukera = list.getSelectedIndex();
					dispose();
					JFrameSortu.erreprodukzioaSortu(klasea, podcasterra,podcastak, podcastAukera, true, 1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.podcastDeskubrituSortu();
			}
		});

	}
}
