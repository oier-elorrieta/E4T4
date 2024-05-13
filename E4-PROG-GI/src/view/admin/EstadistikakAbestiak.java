package view.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.Estadistika;
import model.dao.EstadistikaDao;

public class EstadistikakAbestiak extends EstadistikakTop {

    public EstadistikakAbestiak() {
        super();
        setTitle("Estadistikak Eguneakoa");
        AurkeztuEgunekoa();
    }
    
    private void AurkeztuEgunekoa() {
    	ArrayList<Estadistika> estadistika = EstadistikaDao.getAbestiakTopEguna();
    	for (int i = 0; i < estadistika.size(); i++)
    	model.addRow(new String[]{Integer.toString(i + 1), estadistika.get(i).getS1(), estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda())});
    }
    private void AurkeztuHilekoa() {
    	ArrayList<Estadistika> estadistika = EstadistikaDao.getAbestiakTopHilea();
    	for (int i = 0; i < estadistika.size(); i++)
    	model.addRow(new String[]{Integer.toString(i + 1), estadistika.get(i).getS1(), estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda())});
    }
    private void AurkeztuUrtekoa() {
    	ArrayList<Estadistika> estadistika = EstadistikaDao.getAbestiakTopUrtea();
    	for (int i = 0; i < estadistika.size(); i++)
    	model.addRow(new String[]{Integer.toString(i + 1), estadistika.get(i).getS1(), estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda())});
    }
    
    
    public EstadistikakAbestiak(int Aukera) {
        super();
        if (Aukera == 2) {
            setTitle("Estadistikak Hilabetekoa");
            AurkeztuHilekoa();
        } else if (Aukera == 3){
            setTitle("Estadistikak Urtekoa");
            AurkeztuUrtekoa();
        }
    }
    private void SortuGenerikoa() {
    	model.addColumn("Musikaria");
    	model.addColumn("Abestia");
    	model.addColumn("Entzunaldiak");
        super.btnAstea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAbestiak ea = new EstadistikakAbestiak();
                dispose();
                ea.setVisible(true);
            }
        });
        
        super.btnHilabetea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAbestiak ea = new EstadistikakAbestiak(2);
                dispose();
                ea.setVisible(true);
            }
        });
        
        super.btnUrtea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAbestiak ea = new EstadistikakAbestiak(3);
                dispose();
                ea.setVisible(true);
            }
        });
    }
    /*
    private ArrayList<String> ezarriAbeztiakAstea() {
    	
    }*/
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EstadistikakAbestiak().setVisible(true);
            }
        });
    }
    
}