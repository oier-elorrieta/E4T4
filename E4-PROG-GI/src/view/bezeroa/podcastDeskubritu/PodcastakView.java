package view.bezeroa.podcastDeskubritu;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Audio;
import model.Podcasterra;
import model.Interfazeak.IAtzeraIzan;
import model.Interfazeak.IProfilaIzan;
import model.dao.PodcastDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextPane;

public class PodcastakView extends JFrame implements IAtzeraIzan, IProfilaIzan{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame = this;
	private String klasea = this.getClass().getSimpleName();

	public PodcastakView(Podcasterra podcasterra) {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Podcaster izena atera
		JLabel lblPodcasterIzena = new JLabel(podcasterra.getIzena());
		lblPodcasterIzena.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPodcasterIzena.setBounds(373, 63, 295, 38);
		
		JLabel lblPodcastAukeratu = new JLabel("Aukeratu Podcasta: ");
		lblPodcastAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPodcastAukeratu.setBounds(111, 127, 162, 14);

		JPanel panel = new JPanel();
		panel.setBounds(10, 152, 359, 389);
		
		// Listaren modeloa bete podcasterraren podcastekin
		ArrayList<Audio> podcastak = PodcastDao.getPodcastList(podcasterra.getIzena());
		DefaultListModel<String> modeloList = new DefaultListModel<>();
		for (int i = 0; i < podcastak.size(); i++) {
			modeloList.addElement(podcastak.get(i).getIzena());
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		// Modeloan lista implementatu
		JList list = new JList(modeloList);
		list.setBounds(100, 5, 0, 0);

		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(373, 121, 469, 223);

		// Irudiaren lbl-a
		JLabel lblIrudia = new JLabel("");
		panel_1.add(lblIrudia);

		// // Irudia lbl-ari sartu
		ViewMetodoak.setIrudia(lblIrudia, podcasterra.getIrudia());

		// Podcasterraren deskripzioa
		JTextPane txtPodcasterDeskripzioa = new JTextPane();
		JScrollPane scrollPane_1 = new JScrollPane(txtPodcasterDeskripzioa);
		txtPodcasterDeskripzioa.setText(podcasterra.getDeskription());
		scrollPane_1.setBounds(373, 378, 469, 166);
		txtPodcasterDeskripzioa.setEditable(false);
		
		// Erabiltzailearen datuak aldatzeko botoia
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();

		// Aurreko pantallara joan
		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();
		
		contentPane.add(lblPodcasterIzena);
		contentPane.add(lblPodcastAukeratu);
		contentPane.add(panel);
		contentPane.add(panel_1);
		contentPane.add(scrollPane_1);
		contentPane.setLayout(null);
		contentPane.add(btnErabiltzaile);
		contentPane.add(btnAtzera);

		// Listean podcast bat aukeratzean, erreprodukziora joan
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int podcastAukera = list.getSelectedIndex();
					dispose();
					JFrameSortu.erreprodukzioaSortu(klasea, podcasterra, podcastak, podcastAukera, true, 1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

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
				JFrameSortu.podcasterrakViewSortu();
			}
		});

	}
}
