package model.metodoak;

import javax.swing.WindowConstants;
import view.Erregistroa;
import view.Login;

public class JFrameSortu {

	public static void loginAukeraSortu() {
		Login loginAukera = new Login();
		loginAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loginAukera.setVisible(true);
	}
	
	public static void erregistroAukeraSortu(){
		Erregistroa erregistroAukera = new Erregistroa();
		erregistroAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		erregistroAukera.setVisible(true);
	}
}
