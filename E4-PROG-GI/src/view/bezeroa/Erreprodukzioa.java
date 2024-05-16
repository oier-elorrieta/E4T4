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
import model.Interfazeak.IAtzeraIzan;
import model.Interfazeak.IProfilaIzan;
import model.dao.AbestiGuztokoaDao;
import model.dao.AlbumDao;
import model.dao.AudioDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;

public class Erreprodukzioa extends JFrame implements IAtzeraIzan, IProfilaIzan{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clip clip;
	private boolean erreproduzitzen;
	private long posicion = 0;
	private JFrame frame = this;

	private Timer timer;
	private TimerTask task;

	public Erreprodukzioa(String aurrekoKlasea, Artista artista, ArrayList<Audio> audioak, int audioAukera,
			boolean isrunning, float abiadura) throws SQLException {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		erreproduzitzen = isrunning;
		
		// Audioa kargatuko da eta erreproduzitzen hasiko da lehen erreprodukzioa bada edo aurreko erreprodukzioan, erreproduzitzen hari baizen.
		//String filepath = "\\\\10.5.6.111\\audioak\\" + audioak.get(audioAukera).getIzena() + ".wav";
		String filepath = "C:\\Users\\Ekapro\\Desktop\\audioak\\" + audioak.get(audioAukera).getIzena() + ".wav";
		errepoduzituAudioa(filepath, abiadura, posicion, erreproduzitzen);
		
		// Hasiko da timer bat audioa amaitzen, automatikoki hurrengo audiora joango da
		if (erreproduzitzen) {
			hurrengoAudioAutomatikoki(aurrekoKlasea, artista, audioak, audioAukera, posicion);
		}
	
		//Musikari bat pasatu badut, Albumaren izena lbl sortuko da.
		Album album = null;
		if (artista.getClass().getSimpleName().equals("Musikaria")) {
			album = AlbumDao.getAlbumByAbesti(audioak.get(audioAukera));
			JLabel lblIzenaAlbum = new JLabel(album.getIzenburua());
			lblIzenaAlbum.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzenaAlbum.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
			lblIzenaAlbum.setBounds(10, 35, 870, 25);
			contentPane.add(lblIzenaAlbum);
		}
		
		// Audioaren irudia kargartu
		ImageIcon irudia = new ImageIcon(audioak.get(audioAukera).getIrudia().getBytes(1,
				(int) audioak.get(audioAukera).getIrudia().length()));
		JLabel lblIrudia = new JLabel();
		lblIrudia.setBounds(325, 71, 250, 250);
		lblIrudia.setIcon(irudia);

		// Audioaren izena lbl sortu
		JLabel lblIzenaAbesti = new JLabel(audioak.get(audioAukera).getIzena());
		lblIzenaAbesti.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblIzenaAbesti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAbesti.setBounds(10, 340, 870, 25);

		// Artistaren izena lbl sortu
		JLabel lblIzenaArtista = new JLabel(artista.getIzena());
		lblIzenaArtista.setFont(new Font("Arial Black", Font.ITALIC, 16));
		lblIzenaArtista.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaArtista.setBounds(10, 370, 870, 25);

		// Audioaren iraupena lbl sortu
		JLabel lblIraupena = new JLabel(audioak.get(audioAukera).getIraupena() + "");
		lblIraupena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setBounds(10, 400, 870, 25);

		// Menu botoia sortu
		JButton btnMenua = new JButton("Menua");
		btnMenua.setBounds(150, 450, 150, 50);
		btnMenua.setFont(new Font("SansSerif", Font.BOLD, 15));

		// Kompartitu botoia sortu
		JButton btnKompartitu = new JButton("Kompartitu");
		btnKompartitu.setBounds(150, 450, 150, 50);
		btnKompartitu.setFont(new Font("SansSerif", Font.BOLD, 15));

		// Aurreko audiora joateko botoia sortu
		JButton btnAurrekoa = new JButton("<-");
		btnAurrekoa.setBounds(325, 450, 50, 50);
		btnAurrekoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		if (clip.isRunning() && clip.getFramePosition() == 0) {
			AudioDao.erregistratuErreprodukzioa(audioak.get(audioAukera));
		}

		// Play/Pause botoia sortu, audio erreproduzitzen badago komprobatuta
		JButton btnPlay = new JButton();
		if (erreproduzitzen) {
			btnPlay.setText("Pause");
		} else {
			btnPlay.setText("Play");
		}
		btnPlay.setBounds(400, 450, 100, 50);
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 15));

		// Hurrengora joateko botoia sortu
		JButton btnHurrengoa = new JButton("->");
		btnHurrengoa.setBounds(525, 450, 50, 50);
		btnHurrengoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		// Podcastarako x0.5 botoia sortu
		JButton btnX05 = new JButton("x0.5");
		btnX05.setBounds(600, 450, 75, 50);
		btnX05.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnX05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					posicion = clip.getMicrosecondPosition();
					clip.close();
					errepoduzituAudioa(filepath, 0.5f, posicion, erreproduzitzen);
			}
		});

		// Podcastarako x1 botoia sortu
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

		// Podcastarako x1.5 botoia sortu
		JButton btnX15 = new JButton("x1.5");
		btnX15.setBounds(725, 450, 75, 50);
		btnX15.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnX15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					posicion = clip.getMicrosecondPosition();
					clip.close();
					errepoduzituAudioa(filepath, 1.5f, posicion, erreproduzitzen);
			}
		});

		
		

		Abestia a = new Abestia();
		if (audioak.get(audioAukera).getClass().toString().equals(a.getClass().toString())) {
			AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(SesioAldagaiak.logErabiltzailea,
					audioak.get(audioAukera));
			
			JButton btnGuztokoa = new JButton();
			if (AbestiGuztokoaDao.abestiGuztokoaKonprobatu(abestiGuztokoa)) {
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
						boolean gustokoaDu = AbestiGuztokoaDao.abestiGuztokoaKonprobatu(abestiGuztokoa);
						AbestiGuztokoa abestiGuztokoa = new AbestiGuztokoa(SesioAldagaiak.logErabiltzailea,
								audioak.get(audioAukera));
						if (gustokoaDu) {
							AbestiGuztokoaDao.abestiGuztokoaEzabatu(abestiGuztokoa);	
							btnGuztokoa.setText("♡");
						} else {
							AbestiGuztokoaDao.abestiGustokoaGehitu(abestiGuztokoa);
							btnGuztokoa.setText("♥");
						}
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
		
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();
		

		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();
		contentPane.add(lblIrudia);
		contentPane.add(lblIzenaAbesti);
		contentPane.add(lblIzenaArtista);
		contentPane.add(lblIraupena);
		if (audioak.get(audioAukera).getClass().getName().equals("model.Abestia")) {
			contentPane.add(btnMenua);
		} else if (audioak.get(audioAukera).getClass().getName().equals("model.Podcast")) {
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
						JFrameSortu.menuErreprodukzioaSortu(audioak.get(audioAukera));
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
				if (SesioAldagaiak.doSkip
						|| SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzailePremium")) {
					try {
						int abestiAukeraAux = audioAukera;
						abestiAukeraAux--;

						if (abestiAukeraAux < 0) {
							abestiAukeraAux = audioak.size() - 1;
						}
						clip.stop();
						timer.cancel();
						SesioAldagaiak.doSkip = false;
						ViewMetodoak.skipBaimendu();

						
						if (SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzaileFree")) {
							SesioAldagaiak.doSkip = false;
							ViewMetodoak.skipBaimendu();
						}

						dispose();
						if ((SesioAldagaiak.iragarkiaAtera && SesioAldagaiak.erreprodukzioKop >= 1)
								&& SesioAldagaiak.logErabiltzailea.getClass().getSimpleName()
										.equals("ErabiltzaileFree")) {
							SesioAldagaiak.erreprodukzioKop = 0;
							JFrameSortu.iragarkiaErreproduzituSortu(aurrekoKlasea, artista, audioak, abestiAukeraAux,
									erreproduzitzen);
						} else {
							SesioAldagaiak.erreprodukzioKop++;
							JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, audioak, abestiAukeraAux,
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
						AudioDao.erregistratuErreprodukzioa(audioak.get(audioAukera));
					}
					hurrengoAudioAutomatikoki(aurrekoKlasea, artista, audioak, audioAukera, posicion);
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
						int abestiAukeraAux = audioAukera;
						abestiAukeraAux++;

						if (audioak.size() <= abestiAukeraAux) {
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
							JFrameSortu.iragarkiaErreproduzituSortu(aurrekoKlasea, artista, audioak, abestiAukeraAux,
									erreproduzitzen);
						} else {
							SesioAldagaiak.erreprodukzioKop++;
							JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, audioak, abestiAukeraAux,
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
		
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timer.cancel();
				clip.close();
				dispose();
				switch (aurrekoKlasea) {
				case "AbestiakView":
					JFrameSortu.abestiakViewSortu((Musikaria) artista, newAlbum);
					break;
				case "PodcastakView":
					JFrameSortu.podcastakViewSortu((Podcasterra) artista);
					break;
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

	private void hurrengoAudioAutomatikoki(String aurrekoKlasea, Artista artista, ArrayList<Audio> audioak,
			int audioAukera, long posicion) {
		long tiempo = clip.getMicrosecondLength() - posicion;
		tiempo = tiempo / 1000;
		timer = new Timer();
		task = new TimerTask() {
			public void run() {
				try {
					int abestiAukeraAux = audioAukera;
					abestiAukeraAux++;

					if (audioak.size() <= abestiAukeraAux) {
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
						JFrameSortu.iragarkiaErreproduzituSortu(aurrekoKlasea, artista, audioak, abestiAukeraAux,
								erreproduzitzen);
					} else {
						SesioAldagaiak.erreprodukzioKop++;
						JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, audioak, abestiAukeraAux,
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
