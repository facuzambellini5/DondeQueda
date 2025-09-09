package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.ImageDto;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.services.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagen")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @PostMapping("/guardar")
    public String saveImage(@RequestBody ImageDto imageDto){
        return imageService.saveImgage(imageDto);
    }

    @GetMapping("/traer")
    public List<Image> getImages(){
        return imageService.getImages();
    }

    @GetMapping("/traer/{idImage}")
    public Image getImageById(@PathVariable Long idImage){
        return imageService.getImageById(idImage);
    }

    @PutMapping("/editar/{idImage}")
    public String editImage(@PathVariable Long idImage,
                            @RequestBody ImageDto imageDto){
        return imageService.editImage(idImage, imageDto);
    }

    @DeleteMapping("/eliminar/{idImage}")
    public String deleteImage(@PathVariable Long idImage){
        return imageService.deleteImageById(idImage);
    }
}
