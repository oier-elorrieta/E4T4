package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Album;
import model.Musikaria;
import model.dao.AlbumDao;
import model.dao.MusikariaDao;
import model.metodoak.ImportExportMetodoak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewAdminMetodoak;
import model.metodoak.ViewMetodoak;



public class AlbumakKudeatu extends KudeatuPlantilla {


	private DefaultListModel<Album> modeloList;
	
	
	public AlbumakKudeatu(String izenaM) {
		super();
		
		
		
		
		
		modeloList = ViewMetodoak.getMusikariAlbumak(izenaM);
		super.list = new JList(modeloList);
		super.list.setForeground(new Color(0, 0, 0));
		super.list.setFont(new Font("SansSerif", Font.PLAIN, 23));
		super.scrollPane.setViewportView(list);

		super.lblArtistaKude.setText("Albumak Kudeatu");
		super.btnGehitu.setText("Albuma Gehitu");
		super.btnJarraitu.setText("Abestiak ikusi");
		
		
		super.btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel pan = new JPanel(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);

				JTextField izena = new JTextField(60);
				JTextField urtea = new JTextField(60);
				JTextField irudia = new JTextField(60);
				JTextField generoa = new JTextField(60);
			
				
		

				gbc.gridx = 0;
				gbc.gridy = 0;
				pan.add(new JLabel("Izena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Urtea:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Irudia (Path):"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Generoa:"), gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				pan.add(izena, gbc);
				gbc.gridy++;
				pan.add(urtea, gbc);
				gbc.gridy++;
				pan.add(irudia, gbc);
				gbc.gridy++;
				pan.add(generoa, gbc);

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Bete Datuak: ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {

					String insertatzekoIrudia = ImportExportMetodoak.inportatuIrudia(irudia.getText());
					

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					
					Date d = new Date();
					try {
						d = dateFormat.parse(urtea.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					Album a = new Album(izena.getText(),generoa.getText(),insertatzekoIrudia, d);
					Musikaria m = MusikariaDao.getMusikaria(izenaM);
					AlbumDao.gehituAlbum(a, m.getIdArtista());
					dispose();
					JFrameSortu.albumakKudeatuAukeraSortu(izenaM);
				}

			}
		});
		
		
		
		super.btnDatuakAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Album select = (Album)list.getSelectedValue();
				JPanel pan = new JPanel(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);

				JTextField izena = new JTextField(60);
				izena.setText(select.getIzenburua());
				JTextField urtea = new JTextField(60);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String urteaString = sdf.format(select.getUrtea());
				urtea.setText(urteaString);
				JTextField irudia = new JTextField(60);
				irudia.setText("src\\Importazioak\\irudia.txt");
				JTextField generoa = new JTextField(60);
				generoa.setText(select.getGeneroa());
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				pan.add(new JLabel("Izena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Urtea:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Irudia (Path):"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Generoa:"), gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				pan.add(izena, gbc);
				gbc.gridy++;
				pan.add(urtea, gbc);
				gbc.gridy++;
				pan.add(irudia, gbc);
				gbc.gridy++;
				pan.add(generoa, gbc);

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Bete Datuak: ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {

					String insertatzekoIrudia = ImportExportMetodoak.inportatuIrudia(irudia.getText());
					

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					
					Date d = new Date();
					try {
						d = dateFormat.parse(urtea.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					Album a = new Album(izena.getText(),generoa.getText(),insertatzekoIrudia, d);
					AlbumDao.aldatuAlbum(a);
					dispose();
					JFrameSortu.albumakKudeatuAukeraSortu(izenaM);
				}

			}
		});
		
		
		
		
		
			
	
	}

	
}
