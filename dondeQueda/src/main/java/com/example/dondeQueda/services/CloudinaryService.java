package com.example.dondeQueda.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.dondeQueda.services.interfaces.ICloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService implements ICloudinaryService {

    private Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    /**
     * Sube una imagen a Cloudinary
     *
     * @param file   - El archivo que viene del frontend (MultipartFile)
     * @param folder - La carpeta en Cloudinary donde guardar ("posts", "events", "commerces")
     * @return Map con información de la imagen subida (URL, public_id, dimensiones, etc.)
     */
    public Map<String,Object> uploadImage(MultipartFile file, String folder) throws IOException {

        //Verificar que el archivo no esté vacío
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede estar vacío");
        }

        //Verificar que sea una imagen
        if (!isValidImageType(file)) {
            throw new IllegalArgumentException("Solo se permiten imágenes (JPG, PNG, GIF, WebP)");
        }

        try {
            // PASO 1: Preparar parámetros para Cloudinary
            Map<String, Object> params = new HashMap<>();

            // Especificar en qué carpeta guardar
            params.put("folder", folder);

            // Indicar que es una imagen
            params.put("resource_type", "image");

            // Cloudinary optimizará la calidad automáticamente
            params.put("quality", "auto");

            // Cloudinary elegirá el mejor formato según el navegador
            params.put("fetch_format", "auto");

            // PASO 2: Subir a Cloudinary
            // file.getBytes() obtiene los bytes reales del archivo
            // cloudinary.uploader().upload() envía esos bytes a Cloudinary
            return cloudinary.uploader().upload(file.getBytes(), params);

        } catch (IOException e) {
            throw new IOException("Fallo al subir la imagen: " + e.getMessage());
        }
    }

    /**
     * Elimina una imagen de Cloudinary
     * @param publicId - El identificador único de la imagen en Cloudinary
     * @return true si se eliminó correctamente, false si hubo un error
     */
    public boolean deleteImage(String publicId) {
        try {
            // Llamar al metodo destroy de Cloudinary para eliminar la imagen
            Map<String, Object> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());

            // Cloudinary devuelve "result": "ok" si se eliminó correctamente
            String resultStatus = (String) result.get("result");
            boolean deleted = "ok".equals(resultStatus);

            return deleted;

        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Valida que el archivo sea una imagen válida
     */
    private boolean isValidImageType(MultipartFile file) {
        String contentType = file.getContentType();

        // Verificar que el tipo MIME sea de imagen
        return contentType != null && (
                contentType.equals("image/jpeg") ||
                        contentType.equals("image/png") ||
                        contentType.equals("image/webp")
        );
    }
}


