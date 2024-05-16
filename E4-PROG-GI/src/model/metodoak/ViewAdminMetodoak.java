package model.metodoak;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.Musikaria;
import model.dao.MusikariaDao;

public class ViewAdminMetodoak {

    
    

    
    public static DefaultListModel<Musikaria> getMusikariakList() {

        
        DefaultListModel<Musikaria> result = new DefaultListModel();
        ArrayList<Musikaria> musikariak = MusikariaDao.getMusikariak();
        for(Musikaria i : musikariak ) {
            result.addElement(i);
        }
        
        return result;
    }
    
    
    
    
}