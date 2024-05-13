package view.Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Audio;
import model.Musikaria;
import model.PlayListak;
import model.dao.MusikariaDao;
import model.dao.PlayListakDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewAdminMetodoak;

public class MusikaKudeatu extends KudeatuPlantilla {

	public MusikaKudeatu() {
		super();

		super.modeloList = ViewAdminMetodoak.getMusikariakList();
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
				
				JTextField izena = new JTextField(30);
				JTextField desk = new JTextField(30);
				JTextField irudia = new JTextField(30);
				
				JComboBox<String> cboEzaugarria = new JComboBox();
				cboEzaugarria.addItem("bakarlaria");
				cboEzaugarria.addItem("taldea");
				
				gbc.gridx = 0;
		        gbc.gridy = 0;
		        pan.add(new JLabel("Izena:"), gbc);
		        gbc.gridy++;
		        pan.add(new JLabel("Deskribapena:"), gbc);
		        gbc.gridy++;
		        pan.add(new JLabel("Irudia:"), gbc);
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

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Bete Datuak: ",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				
				if (opcion == JOptionPane.OK_OPTION) {
					
					Musikaria m = new Musikaria(izena.getText(),desk.getText(),irudia.getText(),(String)cboEzaugarria.getSelectedItem());
					MusikariaDao.gehituMusikaria(m);
					
				}else {

					
				}
				
				
				
				
				
			}
		});

	}

}
