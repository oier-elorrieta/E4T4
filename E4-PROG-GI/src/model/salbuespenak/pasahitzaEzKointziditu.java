package model.salbuespenak;

/**
 * Klase honek pasahitzak ez diren kointziditzen salbuespena definitzen du.
 */
public class pasahitzaEzKointziditu extends Exception {
	
	/**
	 * Konstruktorea. Pasahitzak ez diren kointziditzen salbuespena sortzen du.
	 */
	public pasahitzaEzKointziditu(){
		super("Pasahitzak ez dira kointziditzen");	
	}
}
