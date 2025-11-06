package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.dtos.CommerceResponseDto;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/comercio")
public class CommerceController {

    @Autowired
    private ICommerceService commerceService;

    @PostMapping("/guardar")
    ResponseEntity<?> saveCommerce(@RequestBody CommerceDto commerceDto){
        CommerceResponseDto commerceResponseDto = commerceService.saveCommerce(commerceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commerceResponseDto);
    }

    @GetMapping("/traer")
    ResponseEntity<List<CommerceResponseDto>> getCommerces(){
        return ResponseEntity.ok(commerceService.getCommerces());
    }

    @GetMapping("/traer/{idCommerce}")
    ResponseEntity<?> getCommerceResponseDtoById(@PathVariable Long idCommerce){
        return ResponseEntity.ok(commerceService.getCommerceResponseById(idCommerce));
    }

    @GetMapping("/traer/usuario/{idOwner}")
    ResponseEntity<?> getCommercesByOwner(@PathVariable Long idOwner){
        return ResponseEntity.ok(commerceService.getCommercesByOwner(idOwner));
    }

    @PutMapping("/editar/{idCommerce}")
    ResponseEntity<?> editCommerce(@PathVariable Long idCommerce,
                                   @RequestBody CommerceDto commerceDto){
        commerceService.editCommerce(idCommerce, commerceDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio editado correctamente.");
    }

    @DeleteMapping("/eliminar/{idCommerce}")
    ResponseEntity<?> deleteCommerceById(@PathVariable Long idCommerce){
        commerceService.deleteCommerceById(idCommerce);
        return ResponseEntity.ok("Comercio eliminado correctamente.");
    }

    @PostMapping("/agregar/categorias/{idCommerce}")
    ResponseEntity<?> addCategoriesToCommerce(@PathVariable Long idCommerce,
                                              @RequestBody List<Long> idCategories){
        commerceService.addCategoriesToCommerce(idCommerce,idCategories);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría/s agregadas correctamente.");
    }

    @PostMapping("/eliminar/categorias/{idCommerce}")
    ResponseEntity<?> removeCategoriesFromCommerce(@PathVariable Long idCommerce,
                                                   @RequestBody List<Long> idCategories){
        commerceService.removeCategoriesFromCommerce(idCommerce,idCategories);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría/s eliminadas correctamente.");
    }

    @GetMapping("/traer/por/categorias")
    ResponseEntity<?> getCommercesByCategories(@RequestBody List<Long> categoryIds){
        return ResponseEntity.ok(commerceService.getCommercesByCategories(categoryIds));
    }

    @PostMapping("/agregar/etiquetas/{idCommerce}")
    ResponseEntity<?> addTagsToCommerce(@PathVariable Long idCommerce,
                                        @RequestBody List<String> nameTags){
        commerceService.addTagsToCommerce(idCommerce,nameTags);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Etiqueta/s agregadas correctamente.");
    }

    @PostMapping("/eliminar/etiquetas/{idCommerce}")
    ResponseEntity<?> removeTagsFromCommerce(@PathVariable Long idCommerce,
                                             @RequestBody List<Long> tagIds){
        commerceService.removeTagsFromCommerce(idCommerce, tagIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Etiqueta/s eliminadas correctamente.");
    }

    @PostMapping("/agregar/imagenes/galeria/{idCommerce}")
    ResponseEntity<?> addGalleryImagesToCommerce(@PathVariable Long idCommerce,
                                                 @RequestParam List<MultipartFile> images) throws IOException {
        commerceService.addGalleryImagesToCommerce(idCommerce, images);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen/es agregadas correctamente.");
    }

    @PostMapping("/establecer/imagen/perfil/{idCommerce}")
    ResponseEntity<?> setProfileImageToCommerce(@PathVariable Long idCommerce,
                                                @RequestParam MultipartFile image) throws IOException {
        commerceService.setProfileImageToCommerce(idCommerce, image);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen de perfil establecida correctamente.");
    }

    @PostMapping("/establecer/imagen/portada/{idCommerce}")
    ResponseEntity<?> setCoverImageToCommerce(@PathVariable Long idCommerce,
                                              @RequestParam MultipartFile image) throws IOException {
        commerceService.setCoverImageToCommerce(idCommerce, image);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Imagen de portada establecida correctamente.");
    }

    @DeleteMapping("/eliminar/imagen/{idCommerce}")
    ResponseEntity<?> removeImagesFromCommerce(@PathVariable Long idCommerce,
                                               @RequestParam List<Long> imageIds) throws IOException {
        commerceService.removeImagesFromCommerce(idCommerce, imageIds);
        return ResponseEntity.ok("Imagen/es eliminadas correctamente.");
    }

    @GetMapping("/buscar")
    ResponseEntity<?> searchCommercesByNameOrTag(@RequestParam String searchParam,
                                                 @RequestParam int limit,
                                                 @RequestParam int offset){
        return ResponseEntity.ok(commerceService.searchCommercesByNameOrTag(searchParam, limit, offset));
    }
}


