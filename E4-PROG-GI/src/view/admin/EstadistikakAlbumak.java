package view.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.Estadistika;
import model.dao.EstadistikaDao;

public class EstadistikakAlbumak extends EstadistikakTop {

    public EstadistikakAlbumak() {
        super();
        setTitle("Estadistikak Albumak Eguneakoa");
        SortuGenerikoa();
        AurkeztuEgunekoa();
    }
    
    public EstadistikakAlbumak(int Aukera) {
        super();
        SortuGenerikoa();
        if (Aukera == 2) {
            setTitle("Estadistikak Albumak Hilabetekoa");
            AurkeztuHilekoa();
        } else if (Aukera == 3){
            setTitle("Estadistikak Albumak Urtekoa");
            AurkeztuUrtekoa();
        }
    }
    
    private void AurkeztuEgunekoa() {
    	ArrayList<Estadistika> estadistika = EstadistikaDao.getAlbumakTopEguna();
    	for (int i = 0; i < estadistika.size(); i++)
    	model.addRow(new String[]{Integer.toString(i + 1), estadistika.get(i).getS1(), estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda())});
    }
    private void AurkeztuHilekoa() {
    	ArrayList<Estadistika> estadistika = EstadistikaDao.getAlbumakTopHilea();
    	for (int i = 0; i < estadistika.size(); i++)
    	model.addRow(new String[]{Integer.toString(i + 1), estadistika.get(i).getS1(), estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda())});
    }
    private void AurkeztuUrtekoa() {
    	ArrayList<Estadistika> estadistika = EstadistikaDao.getAlbumakTopUrtea();
    	for (int i = 0; i < estadistika.size(); i++)
    	model.addRow(new String[]{Integer.toString(i + 1), estadistika.get(i).getS1(), estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda())});
    }
    
    private void SortuGenerikoa() {
    	model.addColumn("Artista");
    	model.addColumn("Albuma");
    	model.addColumn("Entzunaldiak");
        super.btnAstea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAlbumak ea = new EstadistikakAlbumak();
                dispose();
                ea.setVisible(true);
            }
        });
        
        super.btnHilabetea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAlbumak ea = new EstadistikakAlbumak(2);
                dispose();
                ea.setVisible(true);
            }
        });
        
        super.btnUrtea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAlbumak ea = new EstadistikakAlbumak(3);
                dispose();
                ea.setVisible(true);
            }
        });
    }
    
}