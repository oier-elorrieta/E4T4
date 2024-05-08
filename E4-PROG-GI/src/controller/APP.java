package controller;

import javax.swing.WindowConstants;

import model.metodoak.JFrameSortu;
import model.sql.Kone;
import view.Login;

public class APP {

	public static void main(String[] args) {
			JFrameSortu.loginAukeraSortu();
			
			//registrar erabiltzailes duplicados (comprobar con select si existe)
			//deja poner qie he nacido en 3000-20-1
			//alerta en pasahitza ez kointziditu
			// Si clickas fuera del jlist, entra a uno (mirar si se puede hacer algo)
	}

}
