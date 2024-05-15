package view.admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.Album;
import model.Musikaria;
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
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
}
