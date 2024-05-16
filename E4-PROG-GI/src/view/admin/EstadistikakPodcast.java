package view.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.Estadistika;
import model.dao.EstadistikaDao;

public class EstadistikakPodcast extends EstadistikakTop {
	public EstadistikakPodcast() {
		super();
		setTitle("Estadistikak Podcast Eguneakoa");
		SorreraGenerikoa();
		AurkeztuEgunekoa();
	}

	public EstadistikakPodcast(int Aukera) {
		super();
		SorreraGenerikoa();
		if (Aukera == 2) {
			setTitle("Estadistikak Podcast Hilabetekoa");
			AurkeztuHilekoa();
		} else if (Aukera == 3) {
			setTitle("Estadistikak Podcast Urtekoa");
			AurkeztuUrtekoa();
		}
	}

	private void AurkeztuEgunekoa() {
		ArrayList<Estadistika> estadistika = EstadistikaDao.getPodcastTopEguna();
		if (estadistika.size() != 0) {
			for (int i = 0; i < estadistika.size(); i++)
				model.addRow(new String[] { Integer.toString(i + 1), estadistika.get(i).getS1(),
						estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda()) });
		}
	}

	private void AurkeztuHilekoa() {
		ArrayList<Estadistika> estadistika = EstadistikaDao.getPodcastTopHilea();
		if (estadistika.size() != 0) {
			for (int i = 0; i < estadistika.size(); i++)
				model.addRow(new String[] { Integer.toString(i + 1), estadistika.get(i).getS1(),
						estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda()) });
		}
	}

	private void AurkeztuUrtekoa() {
		ArrayList<Estadistika> estadistika = EstadistikaDao.getPodcastTopUrtea();
		if (estadistika.size() != 0) {
			for (int i = 0; i < estadistika.size(); i++)
				model.addRow(new String[] { Integer.toString(i + 1), estadistika.get(i).getS1(),
						estadistika.get(i).getS2(), Integer.toString(estadistika.get(i).getEntzunda()) });
		}
	}

	private void SorreraGenerikoa() {
		model.addColumn("Musikaria");
		model.addColumn("Abestia");
		model.addColumn("Entzunaldiak");

		super.btnAstea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadistikakPodcast ea = new EstadistikakPodcast();
				dispose();
				ea.setVisible(true);
			}
		});

		super.btnHilabetea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadistikakPodcast ea = new EstadistikakPodcast(2);
				dispose();
				ea.setVisible(true);
			}
		});

		super.btnUrtea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadistikakPodcast ea = new EstadistikakPodcast(3);
				dispose();
				ea.setVisible(true);
			}
		});

	}
}
