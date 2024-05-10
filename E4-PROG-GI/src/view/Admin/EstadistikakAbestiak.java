package view.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class EstadistikakAbestiak extends EstadistikakTop {

	public EstadistikakAbestiak() {
		super();
		setTitle("Estadistikak Astekoa");
		
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
	
	public EstadistikakAbestiak(int Aukera) {
		super();
		
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
		
		if (Aukera == 2) {
			setTitle("Estadistikak Hilabetekoa");
		} else {
			setTitle("Estadistikak Urtekoa");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EstadistikakAbestiak().setVisible(true);
			}
		});
	}
}

