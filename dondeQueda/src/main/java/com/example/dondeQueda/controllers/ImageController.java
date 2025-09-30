package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.services.interfaces.IImageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagen")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveImage(@RequestBody ImageDto imageDto){
       imageService.saveImgage(imageDto);

       return ResponseEntity.status(HttpStatus.CREATED).body("Imagen guardada correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<Image>> getImages(){
        return ResponseEntity.ok(imageService.getImages());
    }

    @GetMapping("/traer/{idImage}")
    public ResponseEntity<?> getImageById(@PathVariable Long idImage){
        return ResponseEntity.ok(imageService.getImageById(idImage));
    }

    @PutMapping("/editar/{idImage}")
    public ResponseEntity<?> editImage(@PathVariable Long idImage,
                            @RequestBody ImageDto imageDto){
        imageService.editImage(idImage, imageDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idImage}")
    public ResponseEntity<?> deleteImage(@PathVariable Long idImage){
        imageService.deleteImageById(idImage);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen eliminada correctamente.");
    }
}
