import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Audio;
import model.PlayListak;
import model.sql.Kone;

package model.metodoak;



/**
 * ImportExportMetodoak klasea, fitxategiak inportatzeko eta esportatzeko metodoak dituena.
 */
public class ImportExportMetodoak {
	
	/**
	 * Plaistlist bat inportatzen du.
	 * @param pl Inportatu nahi den PlayListak objektua.
	 */
	public static void importatuPlaylist(PlayListak pl) {
		
		ArrayList<Audio> abestiak = Kone.getPlayListAbestiak(pl);
		
		// Definir el nombre del archivo
		String nombreArchivo = "C:\\Users\\in1dm3-d\\Desktop\\4.Erronka\\E4T4\\E4-PROG-GI\\src\\Importazioak\\Playlist.txt";

		try {
			// Crear un objeto BufferedWriter
			BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

			// Escribir en el archivo
			writer.write();
			writer.newLine(); // Agregar una nueva línea
			writer.write("Este es un ejemplo de BufferedWriter en Java.");

			// Cerrar el BufferedWriter
			writer.close();

			System.out.println("Se ha escrito en el archivo correctamente.");
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
}
