package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Abestia;
import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AbestiaDao;
import model.dao.MusikariaDao;
import model.metodoak.ImportExportMetodoak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewAdminMetodoak;

public class AbestiakKudeatu extends KudeatuPlantilla {

	private DefaultListModel<Audio> modeloList;

	public AbestiakKudeatu(Album album) {
		super();
		
		ArrayList<Audio> abestiak = AbestiaDao.getAbestiakByAlbum(album);
		modeloList = new DefaultListModel();
		for (int i = 0; i < abestiak.size(); i++) {
			modeloList.addElement(abestiak.get(i));
		}
		
		super.list = new JList(modeloList);
		super.list.setForeground(new Color(0, 0, 0));
		super.list.setFont(new Font("SansSerif", Font.PLAIN, 23));
		super.scrollPane.setViewportView(list);

		super.lblArtistaKude.setText("Abestiak Kudeatu");
		super.btnGehitu.setText("Abestia Gehitu");
		super.btnJarraitu.setEnabled(false);
		super.btnJarraitu.setVisible(false);
		
		
		super.btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel pan = new JPanel(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(5, 5, 5, 5);

				JTextField izena = new JTextField(60);
				JTextField irudia = new JTextField(60);
				JTextField iraupena = new JTextField(60);
	

				gbc.gridx = 0;
				gbc.gridy = 0;
				pan.add(new JLabel("Izena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Iraupena:"), gbc);
				gbc.gridy++;
				pan.add(new JLabel("Irudia (Path):"), gbc);
				gbc.gridx = 1;
				gbc.gridy = 0;
				pan.add(izena, gbc);
				gbc.gridy++;
				pan.add(iraupena,gbc);
				gbc.gridy++;
				pan.add(irudia, gbc);
				

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Bete Datuak: ", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);
				
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date parsedDate = null;
				try {
					parsedDate = dateFormat.parse(iraupena.getText());
				} catch (ParseException e1) {
					System.out.println(e1.getMessage());
				}
                Time time = new Time(parsedDate.getTime());

				if (opcion == JOptionPane.OK_OPTION) {

					
					String insertatzekoIrudia = ImportExportMetodoak.inportatuIrudia(irudia.getText());
					
					Abestia a = new Abestia();
					a.setIzena(izena.getText());
					a.setIrudiaString(insertatzekoIrudia);
					a.setIraupena(time);
					AbestiaDao.gehituAbestia(a, album.getId());
					dispose();
					JFrameSortu.abestiakKudeatuAukeraSortu(album);

				} 
			}
		});
		

	}
}