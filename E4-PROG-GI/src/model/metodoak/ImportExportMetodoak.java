
package model.metodoak;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Audio;
import model.PlayListak;
import model.dao.PlayListakDao;

/**
 * ImportExportMetodoak klasea, fitxategiak inportatzeko eta esportatzeko
 * metodoak dituena.
 */
public class ImportExportMetodoak {

	/**
	 * Plaistlist bat exportatzen du.
	 * 
	 * @param pl Inportatu nahi den PlayListak objektua.
	 */
	public static void exportatuPlaylist(PlayListak pl) {

		ArrayList<Audio> abestiak = PlayListakDao.getPlayListAbestiak(pl);

		// Definir el nombre del archivo
		String nombreArchivo = "src\\Importazioak\\Playlist.txt";

		try {
			// Crear un objeto BufferedWriter
			BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
			// limpio archivoSS
			writer.write("");
			// Escribir en el archivo
			writer.write(pl.getIzena());
			writer.write(";");
			for (Audio i : abestiak) {
				writer.write("" + i.getIdAudio());
				writer.write(";");
			}

			// Cerrar el BufferedWriter
			writer.close();

		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

	public static String[] importatuPlaylist() {

		String nombreArchivo = "src\\Importazioak\\Playlist.txt"; // Nombre del archivo a leer
		String[] playlist = null;
		try {

			BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while ((linea = br.readLine()) != null) {
				playlist = linea.split(";");
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return playlist;
	}

	public static void exportatuAbesti(Audio a) {

		String nombreArchivo = "src\\Importazioak\\Abestia.txt"; // Nombre del archivo a leer

		try {
			// Crear un objeto BufferedWriter
			BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
			// limpio archivoSS
			writer.write("");
			// Escribir en el archivo

			writer.write("Izena: " + a.getIzena() + "Iraupena: " + a.getIraupena());

			// Cerrar el BufferedWriter
			writer.close();

		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}

	}

	public static String inportatuIrudia(String ruta) {

		String nombreArchivo = ruta;
		String irudiaBase64 = "";
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(nombreArchivo));

		} catch (Exception e) {
			try {
				br = new BufferedReader(new FileReader("src\\DefaultImg\\defImg.txt"));
			} catch (Exception e1) {
				
			}
		}

		try {

			String linea;
			while ((linea = br.readLine()) != null) {
				irudiaBase64 = irudiaBase64 + linea;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return irudiaBase64.trim();
	}

}
