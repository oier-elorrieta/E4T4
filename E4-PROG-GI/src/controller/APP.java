package controller;

import javax.swing.WindowConstants;

import view.Login;

public class APP {

	public static void main(String[] args) {
			Login loginAukera = new Login();
			loginAukera.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			loginAukera.setVisible(true);
	}

}
