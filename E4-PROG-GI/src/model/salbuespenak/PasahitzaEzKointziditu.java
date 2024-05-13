package model.salbuespenak;

/**
 * Klase honek pasahitzak ez diren kointziditzen salbuespena definitzen du.
 */
public class PasahitzaEzKointziditu extends Exception {
	
	/**
	 * Konstruktorea. Pasahitzak ez diren kointziditzen salbuespena sortzen du.
	 */
	public PasahitzaEzKointziditu(){
		super("Pasahitzak ez dira kointziditzen");	
	}
}
