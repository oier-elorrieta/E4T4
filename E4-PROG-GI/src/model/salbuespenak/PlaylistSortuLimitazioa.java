package model.salbuespenak;

public class PlaylistSortuLimitazioa extends Exception {

	/**
	 * Klase honek Bezero free bezala, ezin dira playlist gehiago sortu funtzionalitatea ematen du.
	 */
	public PlaylistSortuLimitazioa() {
		super("Bezero free bezala, ezin dira playlist gehiago sortu.");
	}
}
