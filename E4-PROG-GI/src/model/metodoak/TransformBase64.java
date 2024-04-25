package model.metodoak;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class TransformBase64 {
    
	
	public static void Base64ToImage() {
        String base64Image = "/* Tu cadena Base64 aquí */";
        String imagePath = "imagen.jpg"; // Ruta donde deseas guardar la imagen

        try {
            // Decodificar la cadena Base64 a bytes
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // Guardar los bytes en un archivo de imagen
            try (FileOutputStream fos = new FileOutputStream(imagePath)) {
                fos.write(imageBytes);
            }

            System.out.println("Imagen decodificada y guardada exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la imagen: " + e.getMessage());
        }
    }
}
