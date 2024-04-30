package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Abestia;
import model.Podcast;
import model.SesioAldagaiak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class Erreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Clip clip;

<<<<<<< HEAD
	public Erreprodukzioa(ArrayList<Abestia> abestiak, int abestiAukera, String albumIzena) throws SQLException {
=======
	
	
	
	
	
	
	public Erreprodukzioa(ArrayList<Podcast> podcastak, int podcastAukera,String mota) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon irudia = new ImageIcon(podcastak.get(podcastAukera).getIrudia().getBytes(1,
				(int) podcastak.get(podcastAukera).getIrudia().length()));
		JLabel lblIrudia = new JLabel();
		lblIrudia.setBounds(325, 50, 250, 250);
		lblIrudia.setIcon(irudia);

		JButton btnMenua = new JButton("Menua");
		btnMenua.setBounds(150, 325, 150, 50);
		btnMenua.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnAurrekoa = new JButton("<-");
		btnAurrekoa.setBounds(325, 325, 50, 50);
		btnAurrekoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(400, 325, 100, 50);
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnHurrengoa = new JButton("->");
		btnHurrengoa.setBounds(525, 325, 50, 50);
		btnHurrengoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		boolean gustokoaDu = Kone.gustukoaKomprobatu(podcastak.get(podcastAukera));
		JButton btnGuztokoa = new JButton();
		if (gustokoaDu) {
			btnGuztokoa.setText("Gustokoetatik atera");
		} else {
			btnGuztokoa.setText("Gustokoan sartu");
		}
		btnGuztokoa.setBounds(600, 325, 150, 50);
		btnGuztokoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		JButton btnErabiltzaile = SesioAldagaiak.jb;

		contentPane.add(lblIrudia);
		contentPane.add(btnMenua);
		contentPane.add(btnAurrekoa);
		contentPane.add(btnPlay);
		contentPane.add(btnHurrengoa);
		contentPane.add(btnGuztokoa);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		String filepath = "src\\audioak\\" + podcastak.get(podcastAukera).getIzena() + ".wav";
		File f = new File(filepath);
		AudioInputStream aui;
		try {
			aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(aui);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}

		btnMenua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] aukerakMenu = { "Gorde", "Kompartitu" };
				int menuAukera = JOptionPane.showOptionDialog(null, "Zer nahi duzu egin?", "Menu",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, aukerakMenu, aukerakMenu[0]);
				if (menuAukera == JOptionPane.YES_OPTION) {
					System.out.println("go");
				} else if (menuAukera == JOptionPane.NO_OPTION) {
					System.out.println("kompa");
				}
			}
		});

		btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int abestiAukeraAux = podcastAukera;
					abestiAukeraAux--;

					if (abestiAukeraAux >= 0) {
						clip.stop();
						dispose();
						JFrameSortu.erreprodukzioaSortu(podcastak, abestiAukeraAux);
					} else {
						clip.stop();
						abestiAukeraAux = podcastak.size() - 1;
						dispose();
						JFrameSortu.erreprodukzioaSortu(podcastak, abestiAukeraAux);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (clip.isRunning()) {
					clip.stop();
					btnPlay.setText("Play");
				} else {
					clip.start();
					btnPlay.setText("Pause");
				}
			}
		});

		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int abestiAukeraAux = podcastAukera;
					abestiAukeraAux++;

					if (podcastak.size() > abestiAukeraAux) {
						clip.stop();
						dispose();
						JFrameSortu.erreprodukzioaSortu(podcastak, abestiAukeraAux);
					} else {
						clip.stop();
						abestiAukeraAux = 0;
						dispose();
						JFrameSortu.erreprodukzioaSortu(podcastak, abestiAukeraAux);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnGuztokoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (gustokoaDu) {
						Kone.abestiGuztokoaEzabatu(podcastak.get(podcastAukera).getIdAudio());
						JOptionPane.showMessageDialog(null, "Gustoko listatik ondo kendu da", "Eginda!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						Kone.abestiGustokoaGehitu(podcastak.get(podcastAukera));
						JOptionPane.showMessageDialog(null, "Gustoko listan ondo sartu da", "Eginda!", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.menuNagusiaAukeraSortu();
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
	}
	
	
	
	
	public Erreprodukzioa(ArrayList<Abestia> abestiak, int abestiAukera) throws SQLException {
>>>>>>> 7b34e9514d009cd73725ea67baffd08c0709c658
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon irudia = new ImageIcon(abestiak.get(abestiAukera).getIrudia().getBytes(1,
				(int) abestiak.get(abestiAukera).getIrudia().length()));
		JLabel lblIrudia = new JLabel();
		lblIrudia.setBounds(325, 89, 250, 250);
		lblIrudia.setIcon(irudia);

		JButton btnMenua = new JButton("Menua");
		btnMenua.setBounds(150, 450, 150, 50);
		btnMenua.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnAurrekoa = new JButton("<-");
		btnAurrekoa.setBounds(325, 450, 50, 50);
		btnAurrekoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(400, 450, 100, 50);
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnHurrengoa = new JButton("->");
		btnHurrengoa.setBounds(525, 450, 50, 50);
		btnHurrengoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		boolean gustokoaDu = Kone.gustukoaKomprobatu(abestiak.get(abestiAukera));
		JButton btnGuztokoa = new JButton();
		if (gustokoaDu) {
			btnGuztokoa.setText("Gustokoetatik atera");
		} else {
			btnGuztokoa.setText("Gustokoan sartu");
		}
		btnGuztokoa.setBounds(600, 450, 150, 50);
		btnGuztokoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		JButton btnErabiltzaile = SesioAldagaiak.jb;

		contentPane.add(lblIrudia);
		contentPane.add(btnMenua);
		contentPane.add(btnAurrekoa);
		contentPane.add(btnPlay);
		contentPane.add(btnHurrengoa);
		contentPane.add(btnGuztokoa);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);
		
		JLabel lblIzenaAbesti = new JLabel(abestiak.get(abestiAukera).getIzena());
		lblIzenaAbesti.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
		lblIzenaAbesti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAbesti.setBounds(10, 350, 870 , 25);
		contentPane.add(lblIzenaAbesti);
		
		String filepath = "src\\audioak\\" + abestiak.get(abestiAukera).getIzena() + ".wav";
		File f = new File(filepath);
		AudioInputStream aui;
		try {
			aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(aui);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}

		btnMenua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] aukerakMenu = { "Gorde", "Kompartitu" };
				int menuAukera = JOptionPane.showOptionDialog(null, "Zer nahi duzu egin?", "Menu",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, aukerakMenu, aukerakMenu[0]);
				if (menuAukera == JOptionPane.YES_OPTION) {
					System.out.println("go");
				} else if (menuAukera == JOptionPane.NO_OPTION) {
					System.out.println("kompa");
				}
			}
		});

		btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int abestiAukeraAux = abestiAukera;
					abestiAukeraAux--;

					if (abestiAukeraAux >= 0) {
						clip.stop();
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, albumIzena);
					} else {
						clip.stop();
						abestiAukeraAux = abestiak.size() - 1;
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, albumIzena);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (clip.isRunning()) {
					clip.stop();
					btnPlay.setText("Play");
				} else {
					clip.start();
					btnPlay.setText("Pause");
				}
			}
		});

		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int abestiAukeraAux = abestiAukera;
					abestiAukeraAux++;

					if (abestiak.size() > abestiAukeraAux) {
						clip.stop();
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, albumIzena);
					} else {
						clip.stop();
						abestiAukeraAux = 0;
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, albumIzena);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnGuztokoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (gustokoaDu) {
						Kone.abestiGuztokoaEzabatu(abestiak.get(abestiAukera).getIdAudio());
						JOptionPane.showMessageDialog(null, "Gustoko listatik ondo kendu da", "Eginda!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						Kone.abestiGustokoaGehitu(abestiak.get(abestiAukera));
						JOptionPane.showMessageDialog(null, "Gustoko listan ondo sartu da", "Eginda!", JOptionPane.INFORMATION_MESSAGE);
					}
					dispose();
					JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukera, albumIzena);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.menuNagusiaAukeraSortu();
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
	}
}
