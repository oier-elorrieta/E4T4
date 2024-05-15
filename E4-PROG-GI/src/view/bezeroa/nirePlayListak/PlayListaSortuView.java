package view.bezeroa.nirePlayListak;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.dao.PlayListakDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class PlayListaSortuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PlayListaSortuView() {
		setBounds(400, 250, 900, 225);
		setTitle("Sortu PlayList - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(200, 60, 100, 47);
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Source Sans Pro Black", Font.BOLD, 20));
			
		JTextField txtIzena = new JTextField();
		txtIzena.setBounds(297, 64, 300, 47);
		txtIzena.setColumns(10);
		
		JButton btnSortuPlayList = new JButton("Sortu");
		btnSortuPlayList.setBackground(Color.BLACK);
		btnSortuPlayList.setForeground(Color.RED);
		btnSortuPlayList.setBounds(650, 57, 144, 50);
		btnSortuPlayList.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnSortuPlayList.setFocusPainted(false);
		
		// Aurreko pantallara joan
		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();
		
		contentPane.add(lblIzena);
		contentPane.add(txtIzena);
		contentPane.add(btnSortuPlayList);
		contentPane.add(btnAtzera);
		
		btnSortuPlayList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayListakDao.playlistGehitu(txtIzena.getText());
				dispose();
				JFrameSortu.playListakViewSortu();
			}
		});
		
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.playListakViewSortu();
			}
		});
		
	}
}
