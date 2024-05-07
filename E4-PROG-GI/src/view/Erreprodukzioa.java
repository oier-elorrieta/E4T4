package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
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
import model.Audio;
import model.Podcast;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;
import model.metodoak.ErreproduzioSpeed;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class Erreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clip;
	private boolean erreproduzitzen;
	private long posicion = 0;

	public Erreprodukzioa(ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning, String izenaAlbum,
			float abiadura) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		erreproduzitzen = isrunning;
		String filepath = "src\\audioak\\" + abestiak.get(abestiAukera).getIzena() + ".wav";
		errepoduzituAudioa(filepath, abiadura, posicion, erreproduzitzen);

		JLabel lblIzenaAlbum = new JLabel(izenaAlbum);
		lblIzenaAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAlbum.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblIzenaAlbum.setBounds(10, 35, 870, 25);

		ImageIcon irudia = new ImageIcon(abestiak.get(abestiAukera).getIrudia().getBytes(1,
				(int) abestiak.get(abestiAukera).getIrudia().length()));
		JLabel lblIrudia = new JLabel();
		lblIrudia.setBounds(325, 71, 250, 250);
		lblIrudia.setIcon(irudia);

		JLabel lblIzenaAbesti = new JLabel(abestiak.get(abestiAukera).getIzena());
		lblIzenaAbesti.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
		lblIzenaAbesti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAbesti.setBounds(10, 350, 870, 25);

		JLabel lblIraupena = new JLabel(abestiak.get(abestiAukera).getIraupena() + "");
		lblIraupena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setBounds(10, 375, 870, 25);

		JButton btnMenua = new JButton("Menua");
		btnMenua.setBounds(150, 450, 150, 50);
		btnMenua.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnKompartitu = new JButton("Kompartitu");
		btnKompartitu.setBounds(150, 450, 150, 50);
		btnKompartitu.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnAurrekoa = new JButton("<-");
		btnAurrekoa.setBounds(325, 450, 50, 50);
		btnAurrekoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		
		
			AbestiaDao.setEntzunaldiak(abestiak.get(abestiAukera).getIdAudio());
		
		
		JButton btnPlay = new JButton();
		if (isrunning) {
			btnPlay.setText("Pause");
		} else {
			btnPlay.setText("Play");
		}
		btnPlay.setBounds(400, 450, 100, 50);
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnHurrengoa = new JButton("->");
		btnHurrengoa.setBounds(525, 450, 50, 50);
		btnHurrengoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnX05 = new JButton("x0.5");
		btnX05.setBounds(600, 450, 75, 50);
		btnX05.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnX05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abiadura != 0.5f) {
					posicion = clip.getMicrosecondPosition();
					clip.close();
					errepoduzituAudioa(filepath, 0.5f, posicion, erreproduzitzen);
				}
			}
		});

		JButton btnX1 = new JButton("x1");
		btnX1.setBounds(675, 450, 50, 50);
		btnX1.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnX1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicion = clip.getMicrosecondPosition();
				clip.close();
				errepoduzituAudioa(filepath, 1, posicion, erreproduzitzen);
			}
		});

		JButton btnX15 = new JButton("x1.5");
		btnX15.setBounds(725, 450, 75, 50);
		btnX15.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnX15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abiadura != 1.5f) {
					posicion = clip.getMicrosecondPosition();
					clip.close();
					errepoduzituAudioa(filepath, 1.5f, posicion, erreproduzitzen);
				}
			}
		});

		JButton btnErabiltzaile = SesioAldagaiak.jb;
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

		Abestia a = new Abestia();
		if (abestiak.get(abestiAukera).getClass().toString().equals(a.getClass().toString())) {
			boolean gustokoaDu = AbestiaDao.gustukoaKomprobatu(abestiak.get(abestiAukera));
			JButton btnGuztokoa = new JButton();
			if (gustokoaDu) {
				btnGuztokoa.setText("Gustokoetatik atera");
			} else {
				btnGuztokoa.setText("Gustokoan sartu");
			}
			btnGuztokoa.setBounds(600, 450, 150, 50);
			btnGuztokoa.setFont(new Font("SansSerif", Font.BOLD, 15));
			contentPane.add(btnGuztokoa);

			btnGuztokoa.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						if (gustokoaDu) {
							AbestiaDao.abestiGuztokoaEzabatu(abestiak.get(abestiAukera).getIdAudio());
							JOptionPane.showMessageDialog(null, "Gustoko listatik ondo kendu da", "Eginda!",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							AbestiaDao.abestiGustokoaGehitu(abestiak.get(abestiAukera));
							JOptionPane.showMessageDialog(null, "Gustoko listan ondo sartu da", "Eginda!",
									JOptionPane.INFORMATION_MESSAGE);
						}
						clip.close();
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukera, erreproduzitzen, izenaAlbum, abiadura);
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			});
			
		} else {
			contentPane.add(btnX05);
			contentPane.add(btnX1);
			contentPane.add(btnX15);
		}

		contentPane.add(lblIzenaAlbum);
		contentPane.add(lblIrudia);
		contentPane.add(lblIzenaAbesti);
		contentPane.add(lblIraupena);
		if (abestiak.get(abestiAukera).getClass().getName().equals("model.Abestia")) {
			contentPane.add(btnMenua);
		} else if (abestiak.get(abestiAukera).getClass().getName().equals("model.Podcast")) {
			contentPane.add(btnKompartitu);
		}
		contentPane.add(btnAurrekoa);
		contentPane.add(btnPlay);
		contentPane.add(btnHurrengoa);

		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnKompartitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		btnMenua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] aukerakMenu = { "Playlistean Sartu", "Kompartitu" };
				int menuAukera = JOptionPane.showOptionDialog(null, "Zer nahi duzu egin?", "Menu",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, aukerakMenu, aukerakMenu[0]);
				if (menuAukera == JOptionPane.YES_OPTION) {
					try {
						JFrameSortu.abestiaPlayListeanSartuSortu(abestiak.get(abestiAukera));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (menuAukera == JOptionPane.NO_OPTION) {
					System.out.println("kompa");
				}
			}
		});

		btnAurrekoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SesioAldagaiak.doSkip || SesioAldagaiak.erabiltzailePremium) {
					try {
						int abestiAukeraAux = abestiAukera;
						abestiAukeraAux--;

						if (abestiAukeraAux < 0) {
							abestiAukeraAux = abestiak.size() - 1;
						}
						clip.stop();


						SesioAldagaiak.doSkip = false;
						ViewMetodoak.skipBaimendu();


						
						if (!SesioAldagaiak.erabiltzailePremium) {
						SesioAldagaiak.doSkip = false;
						ViewMetodoak.skipBaimendu();
						}
						

						dispose();
						if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
								&& !SesioAldagaiak.erabiltzailePremium) {
							SesioAldagaiak.erreprodukzioKop = 0;
							JFrameSortu.iragarkiaErreproduzituSortu(abestiak, abestiAukeraAux, erreproduzitzen,
									izenaAlbum);
						} else {
							SesioAldagaiak.erreprodukzioKop++;
							JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, erreproduzitzen, izenaAlbum, 1);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ez dira pasatu 10 minuto", "Eginda!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (clip.isRunning()) {
					erreproduzitzen = false;
					clip.stop();
					btnPlay.setText("Play");
				} else {
					erreproduzitzen = true;
					clip.start();
					btnPlay.setText("Pause");
				}
			}
		});

		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (SesioAldagaiak.doSkip || SesioAldagaiak.erabiltzailePremium) {
					try {
						int abestiAukeraAux = abestiAukera;
						abestiAukeraAux++;

						if (abestiak.size() <= abestiAukeraAux) {
							abestiAukeraAux = 0;
						}
						clip.stop();
						if (!SesioAldagaiak.erabiltzailePremium) {
							SesioAldagaiak.doSkip = false;
							ViewMetodoak.skipBaimendu();
							}
						dispose();
						if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
								&& !SesioAldagaiak.erabiltzailePremium) {
							SesioAldagaiak.erreprodukzioKop = 0;
							JFrameSortu.iragarkiaErreproduzituSortu(abestiak, abestiAukeraAux, erreproduzitzen,
									izenaAlbum);
						} else {
							SesioAldagaiak.erreprodukzioKop++;
							JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, erreproduzitzen, izenaAlbum, 1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ez dira pasatu 10 minuto", "Eginda!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clip.close();
				dispose();
				JFrameSortu.menuNagusiaAukeraSortu();
			}
		});

		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SesioAldagaiak.erabiltzaileLogeatutaFree = null;
				SesioAldagaiak.erabiltzaileLogeatutaPremium = null;
				clip.close();
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});
	}

	private void errepoduzituAudioa(String filepath, float abiadura, long posizioa, boolean erreproduzitzen) {
		try {
			File f = new File(filepath);
			AudioInputStream aui;
			aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			AudioFormat format = aui.getFormat();
			float speed = abiadura;
			AudioFormat newFormat = new AudioFormat(format.getEncoding(), format.getSampleRate() * speed,
					format.getSampleSizeInBits(), format.getChannels(), format.getFrameSize(),
					format.getFrameRate() * speed, format.isBigEndian());
			clip = AudioSystem.getClip();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = aui.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}
			byte[] audioData = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(audioData);

			// Convertir el ByteArrayInputStream a AudioInputStream
			aui = new AudioInputStream(bais, newFormat, audioData.length / newFormat.getFrameSize());
			clip.open(aui);
			clip.setMicrosecondPosition(posizioa);
			if (erreproduzitzen) {
				clip.start();
			}
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}
}
