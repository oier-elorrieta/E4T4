package view.bezeroa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
import model.Artista;
import model.Audio;
import model.Iragarkia;
import model.Podcast;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;
import model.dao.IragarkiaDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class IragarkiaErreproduzitu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private Clip clip;

	public IragarkiaErreproduzitu(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak, int abestiAukera,
			boolean isrunning) throws SQLException {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Iragarki guztiak kargatu eta iragarki bat random aukeratu
		ArrayList<Iragarkia> iragarkiak = IragarkiaDao.getIragarkiak();
		int iragarkiaRandom = (int) (Math.random() * (iragarkiak.size()));

		// Iragarkiaren irudia sortu
		ImageIcon irudia = new ImageIcon(iragarkiak.get(iragarkiaRandom).getIrudia().getBytes(1,
				(int) iragarkiak.get(iragarkiaRandom).getIrudia().length()));
		JLabel lblIrudia = new JLabel();
		lblIrudia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIrudia.setBounds(285, 29, 324, 310);
		lblIrudia.setIcon(irudia);

		// Iragarkiaren izena lbl sortu
		JLabel lblIzenaAbesti = new JLabel(iragarkiak.get(iragarkiaRandom).getIzena());
		lblIzenaAbesti.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
		lblIzenaAbesti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAbesti.setBounds(10, 350, 870, 25);

		contentPane.add(lblIrudia);
		contentPane.add(lblIzenaAbesti);

		// Iragarkiaren audioa kargatu
		try {
			String filepath = "\\\\10.5.6.111\\audioak\\iragarkiak\\" + iragarkiak.get(iragarkiaRandom).getIzena()	+ ".wav";
			File f = new File(filepath);
			AudioInputStream aui;
			aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(aui);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		// Automatikoki iragarkia amaitzean, hurrengo abestira joateko metodoa
		hurrengoAudioaHasi(aurrekoKlasea, artista, abestiak, abestiAukera, isrunning);
	}

	
	public void hurrengoAudioaHasi(String aurrekoKlasea, Artista artista, ArrayList<Audio> abestiak, int abestiAukera,
			boolean isrunning) {
		long l = clip.getMicrosecondLength() / 1000;
		timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				try {
					clip.stop();
					dispose();
					JFrameSortu.erreprodukzioaSortu(aurrekoKlasea, artista, abestiak, abestiAukera, isrunning, 1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, l);
	}

}
