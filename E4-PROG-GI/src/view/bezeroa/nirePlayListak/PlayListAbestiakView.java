package view.bezeroa.nirePlayListak;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.AbestiGuztokoa;
import model.Abestia;
import model.Audio;
import model.Musikaria;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.AbestiGuztokoaDao;
import model.dao.AbestiaDao;
import model.dao.AudioDao;
import model.dao.MusikariaDao;
import model.dao.PlayListakDao;
import model.metodoak.ImportExportMetodoak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class PlayListAbestiakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ArrayList<Audio> abestiakList;
	private JFrame frame = this;
	private String klasea = this.getClass().getSimpleName();
	public PlayListAbestiakView(PlayListak aukeraPlaylist) {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if (aukeraPlaylist.getIdPlayList() == 0) {
			abestiakList = AbestiGuztokoaDao.getAbestiGustokoak();
		} else {
			abestiakList = AudioDao.getAbestiakByPlayList(aukeraPlaylist);
		}

	

		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		for (int i = 0; i < abestiakList.size(); i++) {
			modeloLista.addElement(abestiakList.get(i).getIzena());
		}
		JList<String> jListAbestiak = new JList(modeloLista);
		jListAbestiak.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListAbestiak);
		jListAbestiak.setBounds(50, 150, 550, 350);

		JButton btnErreproduzitu = new JButton("Erreproduzitu");
		btnErreproduzitu.setBounds(650, 225, 208, 50);
		btnErreproduzitu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnKompartitu = new JButton("Kompartitu");
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

		JButton btnErabiltzaile = SesioAldagaiak.jb;
		btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		contentPane.add(jListAbestiak);
		contentPane.add(btnErreproduzitu);
		contentPane.add(btnKompartitu);
		contentPane.add(btnEzabatu);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnErreproduzitu.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) {
				if (jListAbestiak.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu Abesti bat aukeratu ezabatzeko", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						int aukeraAbestia = jListAbestiak.getSelectedIndex();
						Musikaria musikaria = MusikariaDao.getMusikariaByAudio(abestiakList.get(aukeraAbestia));
						dispose();
						JFrameSortu.erreprodukzioaSortu(klasea,musikaria, abestiakList, aukeraAbestia, true,
								1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		btnEzabatu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int aukeraAbestia = jListAbestiak.getSelectedIndex();

					if (aukeraPlaylist.getIdPlayList() != 0) {
						PlayListakDao.abestiPlaylistEzabatu(aukeraPlaylist.getIdPlayList(),
								abestiakList.get(aukeraAbestia).getIdAudio());
					} else {
						AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(SesioAldagaiak.logErabiltzailea, abestiakList.get(aukeraAbestia));
						AbestiGuztokoaDao.abestiGuztokoaEzabatu(abestiGuztokoa);
					}

					dispose();
					JFrameSortu.playListAbestiakViewSortu(aukeraPlaylist);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.playListakViewSortu();
			}
		});

		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		btnKompartitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImportExportMetodoak.exportatuAbesti(abestiakList.get(jListAbestiak.getSelectedIndex()));
				JOptionPane.showMessageDialog(null, "Ondo partekatu da", "Partekatuta",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}