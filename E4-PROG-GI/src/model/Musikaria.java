package model;

<<<<<<< HEAD
import com.mysql.cj.jdbc.Blob;
=======
import java.sql.Blob;
>>>>>>> feb4441f893e8d9d7cd4b0f3ecffc5ee42e8a047

/**
 * Klase hau Musikaria klasea da, Artistak klasea heredatzen duena.
 * Musikariak izena, deskribapena eta irudia ditu.
 */
public class Musikaria extends Artista {

	

	//hau gero hobeto enum batera aldatzea
	private String ezaugarria;
	
	
	/**
	 * Musikariaren eraikitzailea.
	 * @param izena Musikariaren izena
	 * @param deskription Musikariaren deskribapena
	 * @param blob Musikariaren irudia
	 */
<<<<<<< HEAD
	public Musikaria(int idArtista ,String izena, String deskription, Blob irudia,String ezaugarria) {
		super(idArtista,izena, deskription, irudia);
		this.ezaugarria = ezaugarria;
		
=======
	public Musikaria(String izena, String deskription, Blob irudia) {
		super(izena, deskription, irudia);
>>>>>>> feb4441f893e8d9d7cd4b0f3ecffc5ee42e8a047
	}

	

	@Override
	public String toString() {
		return "Musikaria [ezaugarria=" + ezaugarria + ", idArtista=" + idArtista + ", izena=" + izena
				+ ", deskription=" + deskription + ", irudia=" + irudia + "]";
	}


	


	
	
	

}
