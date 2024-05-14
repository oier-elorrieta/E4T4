package view.bezeroa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
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

import model.AbestiGuztokoa;
import model.Abestia;
import model.Album;
import model.Artista;
import model.Audio;
import model.Musikaria;
import model.Podcasterra;
import model.SesioAldagaiak;
import model.dao.AbestiGuztokoaDao;
import model.dao.AlbumDao;
import model.dao.AudioDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;

public class Erreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clip;
	private boolean erreproduzitzen;
	private long posicion = 0;
	private int iraupena = 0;
	private JFrame frame = this;

	private Timer timer;
	private TimerTask task;

	public Erreprodukzioa(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak, int abestiAukera,
			boolean isrunning, float abiadura) throws SQLException {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		erreproduzitzen = isrunning;
		// String filepath = "\\\\10.5.6.111\\audioak\\" +
		// abestiak.get(abestiAukera).getIzena() + ".wav";
		String filepath = "C:\\Users\\Ekapro\\Desktop\\audioak\\" + abestiak.get(abestiAukera).getIzena() + ".wav";
		errepoduzituAudioa(filepath, abiadura, posicion, erreproduzitzen);

		if (erreproduzitzen) {
			hurrengoAudioAutomatikoki(aurrekoKlasea, artista, abestiak, abestiAukera, posicion);
		}

		Album album = null;
		if (artista.getClass().getSimpleName().equals("Musikaria")) {
			album = AlbumDao.getAlbumByAbesti(abestiak.get(abestiAukera));
			JLabel lblIzenaAlbum = new JLabel(album.getIzenburua());
			lblIzenaAlbum.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzenaAlbum.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
			lblIzenaAlbum.setBounds(10, 35, 870, 25);
			contentPane.add(lblIzenaAlbum);
		}

		ImageIcon irudia = new ImageIcon(abestiak.get(abestiAukera).getIrudia().getBytes(1,
				(int) abestiak.get(abestiAukera).getIrudia().length()));
		JLabel lblIrudia = new JLabel();
		lblIrudia.setBounds(325, 71, 250, 250);
		lblIrudia.setIcon(irudia);

		JLabel lblIzenaAbesti = new JLabel(abestiak.get(abestiAukera).getIzena());
		lblIzenaAbesti.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblIzenaAbesti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAbesti.setBounds(10, 340, 870, 25);

		JLabel lblIzenaArtista = new JLabel(artista.getIzena());
		lblIzenaArtista.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblIzenaArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaArtista.setBounds(10, 370, 870, 25);

		JLabel lblIraupena = new JLabel(abestiak.get(abestiAukera).getIraupena() + "");

		lblIraupena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setBounds(10, 400, 870, 25);

		JButton btnMenua = new JButton("Menua");
		btnMenua.setBounds(150, 450, 150, 50);
		btnMenua.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnKompartitu = new JButton("Kompartitu");
		btnKompartitu.setBounds(150, 450, 150, 50);
		btnKompartitu.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnAurrekoa = new JButton("<-");
		btnAurrekoa.setBounds(325, 450, 50, 50);
		btnAurrekoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		if (clip.isRunning() && clip.getFramePosition() == 0) {
			AudioDao.erregistratuErreprodukzioa(abestiak.get(abestiAukera));
		}

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

		// JButton btnErabiltzaile = SesioAldagaiak.jb;

		// ActionListener[] li = btnErabiltzaile.getActionListeners();
		// for (ActionListener i : li) {
		// btnErabiltzaile.removeActionListener(i);
		// }

		// btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);

		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();
		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlay.setText("Play");
				erreproduzitzen = false;
				timer.cancel();
				posicion = clip.getMicrosecondPosition();
				clip.stop();
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		Abestia a = new Abestia();
		if (abestiak.get(abestiAukera).getClass().toString().equals(a.getClass().toString())) {
			AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(SesioAldagaiak.logErabiltzailea,
					abestiak.get(abestiAukera));
			boolean gustokoaDu = AbestiGuztokoaDao.abestiGuztokoaKonprobatu(abestiGuztokoa);
			JButton btnGuztokoa = new JButton();
			if (gustokoaDu) {
				btnGuztokoa.setText("♥");
			} else {
				btnGuztokoa.setText("♡");
			}
			btnGuztokoa.setBounds(600, 450, 150, 50);
			btnGuztokoa.setFont(new Font("SansSerif", Font.BOLD, 15));
			contentPane.add(btnGuztokoa);

			btnGuztokoa.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(SesioAldagaiak.logErabiltzailea,
								abestiak.get(abestiAukera));
						if (gustokoaDu) {
							AbestiGuztokoaDao.abestiGuztokoaEzabatu(abestiGuztokoa);
							JOptionPane.showMessageDialog(null, "Gustoko listatik ondo kendu da", "Eginda!",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							AbestiGuztokoaDao.abestiGustokoaGehitu(abestiGuztokoa);
							JOptionPane.showMessageDialog(null, "Gustoko listan ondo sartu da", "Eginda!",
									JOptionPane.INFORMATION_MESSAGE);
						}
						timer.cancel();
						clip.close();
						dispose();
						JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, abestiak, abestiAukera, erreproduzitzen,
								abiadura);
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
		contentPane.add(lblIrudia);
		contentPane.add(lblIzenaAbesti);
		contentPane.add(lblIzenaArtista);
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
						JFrameSortu.menuErreprodukzioaSortu(abestiak.get(abestiAukera));
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
				// if (SesioAldagaiak.doSkip || SesioAldagaiak.erabiltzailePremium) {
				if (SesioAldagaiak.doSkip
						|| SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzailePremium")) {
					try {
						int abestiAukeraAux = abestiAukera;
						abestiAukeraAux--;

						if (abestiAukeraAux < 0) {
							abestiAukeraAux = abestiak.size() - 1;
						}
						clip.stop();
						timer.cancel();
						SesioAldagaiak.doSkip = false;
						ViewMetodoak.skipBaimendu();

						// if (!SesioAldagaiak.erabiltzailePremium) {
						if (SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzaileFree")) {
							SesioAldagaiak.doSkip = false;
							ViewMetodoak.skipBaimendu();
						}

						dispose();
						// if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
						// && !SesioAldagaiak.erabiltzailePremium) {
						if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
								&& SesioAldagaiak.logErabiltzailea.getClass().getSimpleName()
										.equals("ErabiltzaileFree")) {
							SesioAldagaiak.erreprodukzioKop = 0;
							JFrameSortu.iragarkiaErreproduzituSortu(aurrekoKlasea, artista, abestiak, abestiAukeraAux,
									erreproduzitzen);
						} else {
							SesioAldagaiak.erreprodukzioKop++;
							JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, abestiak, abestiAukeraAux,
									erreproduzitzen, 1);
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

					timer.cancel();
					posicion = clip.getMicrosecondPosition();
					int segunduak = (int) posicion / 1000000;
					String iraupena = ViewMetodoak.kalkulatuIraupena(segunduak);
					lblIraupena.setText(iraupena);

					erreproduzitzen = false;
					clip.stop();
					btnPlay.setText("Play");
				} else {
					if (clip.getFramePosition() == 0) {
						AudioDao.erregistratuErreprodukzioa(abestiak.get(abestiAukera));
					}
					hurrengoAudioAutomatikoki(aurrekoKlasea, artista, abestiak, abestiAukera, posicion);
					erreproduzitzen = true;
					clip.start();
					btnPlay.setText("Pause");
				}
			}
		});

		btnHurrengoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (SesioAldagaiak.doSkip
						|| SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzailePremium")) {
					try {
						int abestiAukeraAux = abestiAukera;
						abestiAukeraAux++;

						if (abestiak.size() <= abestiAukeraAux) {
							abestiAukeraAux = 0;
						}
						timer.cancel();
						clip.stop();
						if (SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzaileFree")) {
							SesioAldagaiak.doSkip = false;
							ViewMetodoak.skipBaimendu();
						}
						dispose();
						if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
								&& SesioAldagaiak.logErabiltzailea.getClass().getSimpleName()
										.equals("ErabiltzaileFree")) {
							SesioAldagaiak.erreprodukzioKop = 0;
							JFrameSortu.iragarkiaErreproduzituSortu(aurrekoKlasea, artista, abestiak, abestiAukeraAux,
									erreproduzitzen);
						} else {
							SesioAldagaiak.erreprodukzioKop++;
							JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, abestiak, abestiAukeraAux,
									erreproduzitzen, 1);
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

		Album newAlbum = album;
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timer.cancel();
				clip.close();
				dispose();
				// JFrameSortu.menuNagusiaAukeraSortu();

				switch (aurrekoKlasea) {
				case "AbestiakView":
					JFrameSortu.abestiakViewSortu((Musikaria) artista, newAlbum);
					break;
				case "PodcastakView":
					JFrameSortu.podcastakViewSortu((Podcasterra) artista);
					break;
				// COMO HAGO ETO
				case "PlayListAbestiakView":
					JFrameSortu.playListakViewSortu();
					break;
				}
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

	private void hurrengoAudioAutomatikoki(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak,
			int abestiAukera, long posicion) {
		long tiempo = clip.getMicrosecondLength() - posicion;
		tiempo = tiempo / 1000;
		timer = new Timer();
		task = new TimerTask() {
			public void run() {
				try {
					int abestiAukeraAux = abestiAukera;
					abestiAukeraAux++;

					if (abestiak.size() <= abestiAukeraAux) {
						abestiAukeraAux = 0;
					}
					clip.stop();
					if (SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzaileFree")) {
						SesioAldagaiak.doSkip = false;
						ViewMetodoak.skipBaimendu();
					}
					dispose();
					if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
							&& SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzaileFree")) {
						SesioAldagaiak.erreprodukzioKop = 0;
						JFrameSortu.iragarkiaErreproduzituSortu(aurrekoKlasea, artista, abestiak, abestiAukeraAux,
								erreproduzitzen);
					} else {
						SesioAldagaiak.erreprodukzioKop++;
						JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, abestiak, abestiAukeraAux,
								erreproduzitzen, 1);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		};
		timer.schedule(task, tiempo);
	}
}
