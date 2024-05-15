package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Audio;
import model.Musikaria;
import model.PlayListak;
import model.dao.MusikariaDao;
import model.dao.PlayListakDao;
import model.metodoak.ImportExportMetodoak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewAdminMetodoak;
import model.metodoak.ViewMetodoak;

public class MusikaKudeatu extends KudeatuPlantilla {

	private DefaultListModel<Musikaria> modeloList;

	public MusikaKudeatu() {
		super();

		modeloList = ViewAdminMetodoak.getMusikariakList();
		super.list = new JList(modeloList);
		super.list.setForeground(new Color(0, 0, 0));
		super.list.setFont(new Font("SansSerif", Font.PLAIN, 23));
		super.scrollPane.setViewportView(list);

		super.lblArtistaKude.setText("Aristak Kudeatu");
		super.btnGehitu.setText("Artista Gehitu");
		super.btnJarraitu.setText("Albumak ikusi");

		super.btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel pan = new JPanel(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);

				JTextField izena = new JTextField(60);
				JTextField desk = new JTextField(60);
				JTextField irudia = new JTextField(60);

				JComboBox<String> cboEzaugarria = new JComboBox();
				cboEzaugarria.addItem("bakarlaria");
				cboEzaugarria.addItem("taldea");

				gbc.gridx = 0;
				gbc.gridy = 0;
				pan.add(new JLabel("Izena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Deskribapena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Irudia (Path):"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Ezaugarria:"), gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				pan.add(izena, gbc);
				gbc.gridy++;
				pan.add(desk, gbc);
				gbc.gridy++;
				pan.add(irudia, gbc);
				gbc.gridy++;
				pan.add(cboEzaugarria, gbc);

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Bete Datuak: ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {

					String insertatzekoIrudia = ImportExportMetodoak.inportatuIrudia(irudia.getText());
					Musikaria m = new Musikaria(izena.getText(), desk.getText(), insertatzekoIrudia,
							(String) cboEzaugarria.getSelectedItem());
					MusikariaDao.gehituMusikaria(m);
					dispose();
					JFrameSortu.musikaKudeatuAukeraSortu();

				} else {

				}

			}
		});

		super.btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MusikariaDao.ezabatuMusikaria(((Musikaria) list.getSelectedValue()).getIzena());
				dispose();
				JFrameSortu.musikaKudeatuAukeraSortu();

			}
		});

		///////////////////////////////////////////////////////////////////////////

		super.btnDatuakAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Musikaria select = (Musikaria) list.getSelectedValue();

				JPanel pan = new JPanel(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);

				JTextField izena = new JTextField(40);
				izena.setText(select.getIzena());
				JTextField desk = new JTextField(40);
				desk.setText(select.getDeskription());
				JTextField irudia = new JTextField(60);
				irudia.setText("src\\Importazioak\\irudia.txt");

				JComboBox<String> cboEzaugarria = new JComboBox();
				cboEzaugarria.addItem("bakarlaria");
				cboEzaugarria.addItem("taldea");

				JButton img = new JButton();
				ImageIcon icono = null;
				try {

					icono = new ImageIcon(select.getIrudia().getBytes(1, (int) select.getIrudia().length()));

				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}

				img.setIcon(icono);

				gbc.gridx = 0;
				gbc.gridy = 0;
				pan.add(new JLabel("Izena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Deskribapena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Irudia (Path):"), gbc);
				gbc.gridy++;
				gbc.gridy++;
				pan.add(new JLabel("Ezaugarria:"), gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				pan.add(izena, gbc);
				gbc.gridy++;
				pan.add(desk, gbc);
				gbc.gridy++;
				pan.add(irudia, gbc);
				gbc.gridy++;
				pan.add(img, gbc);
				gbc.gridy++;
				pan.add(cboEzaugarria, gbc);

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Aldatu datuak: ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {
					String insertatzekoIrudia = ImportExportMetodoak.inportatuIrudia(irudia.getText());
					select.setIzena(izena.getText());
					select.setDeskription(desk.getText());
					select.setIrudiaString(insertatzekoIrudia);
					select.setEzaugarria((String) cboEzaugarria.getSelectedItem());
					MusikariaDao.aldatuMusikaria(select);
				} else {

				}

			}
		});

		super.btnJarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AlbumakKudeatu ak = new AlbumakKudeatu(((Musikaria) list.getSelectedValue()).getIzena());
				ak.setVisible(true);
				dispose();
				
			}
		});

	}

}
