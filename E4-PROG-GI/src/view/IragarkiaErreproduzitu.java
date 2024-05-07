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
import model.Podcast;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class IragarkiaErreproduzitu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
private Timer timer;
	private Clip clip;

	public IragarkiaErreproduzitu(Artista artista, ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning, String izenaAlbum) throws SQLException {
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
		lblIrudia.setBounds(325, 71, 250, 250);
		lblIrudia.setIcon(irudia);

		JLabel lblIzenaAbesti = new JLabel("Nocilla");
		lblIzenaAbesti.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 17));
		lblIzenaAbesti.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzenaAbesti.setBounds(10, 350, 870, 25);

		contentPane.add(lblIrudia);
		contentPane.add(lblIzenaAbesti);

		String filepath = "src\\audioak\\iragarkiak\\nocilla.wav";
		File f = new File(filepath);
		AudioInputStream aui;

		try {
			aui = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(aui);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}

		long l = clip.getMicrosecondLength() / 1000;
		hurrengoAudioaHasi(artista, abestiak, abestiAukera, isrunning, izenaAlbum, l);
	}

	public void hurrengoAudioaHasi(Artista artista, ArrayList<Audio> abestiak, int abestiAukera, boolean isrunning, String izenaAlbum, Long l) {
		timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				try {
					clip.stop();
					dispose();
					JFrameSortu.erreprodukzioaSortu(artista,abestiak, abestiAukera, isrunning, izenaAlbum, 1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		timer.schedule(task, l);
	}
}
