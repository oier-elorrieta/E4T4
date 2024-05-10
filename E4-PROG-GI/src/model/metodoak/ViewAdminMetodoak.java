package model.metodoak;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.Musikaria;
import model.dao.MusikariaDao;

public class ViewAdminMetodoak {

    
    
    
    public static DefaultListModel<String> getMusikariakList() {
        
        DefaultListModel<String> result = new DefaultListModel();
        ArrayList<Musikaria> musikariak = MusikariaDao.getMusikariakEntzunaldiak();
        for(Musikaria i : musikariak ) {
            result.addElement(i.getIzena());
        }
        
        return result;
    }
    
    
    
    
}