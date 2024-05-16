package view.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.Estadistika;
import model.dao.EstadistikaDao;

public class EstadistikakEntzunda extends EstadistikakTop {
	public EstadistikakEntzunda() {
		super();
		setTitle("Estadistikak Entzunda Eguneakoa");
		SorreraGenerikoa();
		AurkeztuEgunekoa();
	}

	public EstadistikakEntzunda(int Aukera) {
		super();
		SorreraGenerikoa();
		if (Aukera == 2) {
			setTitle("Estadistikak Entzunda Hilabetekoa");
			AurkeztuHilekoa();
		} else if (Aukera == 3) {
			setTitle("Estadistikak Entzunda Urtekoa");
			AurkeztuUrtekoa();
		}
	}

	private void AurkeztuEgunekoa() {
		ArrayList<Estadistika> estadistika = EstadistikaDao.getTopEntzundaEgunean();
		if (estadistika.size() != 0) {
			for (int i = 0; i < estadistika.size(); i++)
				model.addRow(new String[] { Integer.toString(i + 1), estadistika.get(i).getS1(),
						estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda()) });
		}
	}

	private void AurkeztuHilekoa() {
		ArrayList<Estadistika> estadistika = EstadistikaDao.getTopEntzundaHilean();
		if (estadistika.size() != 0) {
			for (int i = 0; i < estadistika.size(); i++)
				model.addRow(new String[] { Integer.toString(i + 1), estadistika.get(i).getS1(),
						estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda()) });
		}
	}

	private void AurkeztuUrtekoa() {
		ArrayList<Estadistika> estadistika = EstadistikaDao.getTopEntzundaUrtean();
		if (estadistika.size() != 0) {
			for (int i = 0; i < estadistika.size(); i++)
				model.addRow(new String[] { Integer.toString(i + 1), estadistika.get(i).getS1(),
						estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda()) });
		}
	}

	private void SorreraGenerikoa() {
		model.addColumn("Izena");
		model.addColumn("Entzunaldiak");

		super.btnAstea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadistikakEntzunda ee = new EstadistikakEntzunda();
				dispose();
				ee.setVisible(true);
			}
		});

		super.btnHilabetea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadistikakEntzunda ee = new EstadistikakEntzunda(2);
				dispose();
				ee.setVisible(true);
			}
		});

		super.btnUrtea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadistikakEntzunda ee = new EstadistikakEntzunda(3);
				dispose();
				ee.setVisible(true);
			}
		});

	}
}
