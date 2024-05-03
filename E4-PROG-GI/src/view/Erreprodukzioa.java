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
	

	public Erreprodukzioa(ArrayList<Audio> abestiak, int abestiAukera, String izenaAlbum) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JButton btnAurrekoa = new JButton("<-");
		btnAurrekoa.setBounds(325, 450, 50, 50);
		btnAurrekoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(400, 450, 100, 50);
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 15));

		JButton btnHurrengoa = new JButton("->");
		btnHurrengoa.setBounds(525, 450, 50, 50);
		btnHurrengoa.setFont(new Font("SansSerif", Font.BOLD, 15));

		String filepath = "src\\audioak\\" + abestiak.get(abestiAukera).getIzena() + ".wav";
		File f = new File(filepath);
		AudioInputStream aui;

		try {
			aui = AudioSystem.getAudioInputStream(f);

			// Crear un nuevo formato de audio con velocidad x2
            AudioFormat format = aui.getFormat();
            
            float speed = 2.0f;
            
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
            AudioInputStream audioInputStream = new AudioInputStream(bais, newFormat, audioData.length / newFormat.getFrameSize());

            // Abrir el Clip con el AudioInputStream
            clip.open(audioInputStream);
		
			//clip = AudioSystem.getClip();
			//clip.open(aui);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}

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
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukera, izenaAlbum);
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			});
			// en este else va ir todo lo de la velocidad de reproduccion
		} else {

			JButton btnX2 = new JButton("X 2");
			btnX2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					

				}
			});
			btnX2.setBounds(603, 454, 69, 46);
			contentPane.add(btnX2);

			JButton btnX15 = new JButton("X 1.5");
			btnX15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			btnX15.setBounds(677, 450, 57, 50);
			contentPane.add(btnX15);

		}

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		JButton btnErabiltzaile = SesioAldagaiak.jb;

		contentPane.add(lblIzenaAlbum);
		contentPane.add(lblIrudia);
		contentPane.add(lblIzenaAbesti);
		contentPane.add(lblIraupena);
		contentPane.add(btnMenua);
		contentPane.add(btnAurrekoa);
		contentPane.add(btnPlay);
		contentPane.add(btnHurrengoa);

		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

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
				try {
					int abestiAukeraAux = abestiAukera;
					abestiAukeraAux--;

					if (abestiAukeraAux >= 0) {
						clip.stop();
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, izenaAlbum);
					} else {
						clip.stop();
						abestiAukeraAux = abestiak.size() - 1;
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, izenaAlbum);
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
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, izenaAlbum);
					} else {
						clip.stop();
						abestiAukeraAux = 0;
						dispose();
						JFrameSortu.erreprodukzioaSortu(abestiak, abestiAukeraAux, izenaAlbum);
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
}
