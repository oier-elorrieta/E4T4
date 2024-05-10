package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Album;
import model.Audio;
import model.PlayListak;
import model.dao.PlayListakDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewAdminMetodoak;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ArtistakKudeatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtistakKudeatu frame = new ArtistakKudeatu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ArtistakKudeatu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 124, 840, 420);
		contentPane.add(scrollPane);
		
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);
		contentPane.add(btnAtzera);
		
		
		
		
		DefaultListModel<String> modeloList = ViewAdminMetodoak.getMusikariakList();
		JList list = new JList(modeloList);
		list.setForeground(new Color(0, 0, 0));
		list.setFont(new Font("SansSerif", Font.PLAIN, 23));
		scrollPane.setViewportView(list);
		
		JLabel lblArtistaKude = new JLabel("Aukeratu artista bat:");
		lblArtistaKude.setFont(new Font("SansSerif", Font.PLAIN, 37));
		lblArtistaKude.setBounds(290, 60, 370, 53);
		contentPane.add(lblArtistaKude);
		
	
		
		
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				
				JPanel pan = new JPanel(new BorderLayout());
				JButton deskubritu = new JButton("Gehiago deskubritu");
				JButton kudeatu = new JButton("Kudeatu");
				pan.add(deskubritu, BorderLayout.CENTER);
				pan.add(kudeatu,BorderLayout.CENTER);
				
				int opcion = JOptionPane.showConfirmDialog(null, pan, "Mesedez, Sartu PlayListaren Izen Berria:",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {
					
					
				} else {

				
				}
				
			}});
		
		
		
		

		
		
		
		
		
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.menuAdminAukeraSortu();
			}
		});
		
		
	}
}
