package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comercio")
public class CommerceController {

    @Autowired
    private ICommerceService commerceService;

    ResponseEntity<?> saveCommerce(CommerceDto commerceDto){
        commerceService.saveCommerce(commerceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comercio creado correctamente.");
    }

    ResponseEntity<List<Commerce>> getCommerces(){
        return ResponseEntity.ok(commerceService.getCommerces());
    }

    ResponseEntity<?> getCommerceById(Long idCommerce){
        return ResponseEntity.ok(commerceService.getCommerceById(idCommerce));
    }

    ResponseEntity<?> editCommerce(Long idCommerce, CommerceDto commerceDto){
        commerceService.editCommerce(idCommerce, commerceDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comercio editado correctamente.");
    }

    ResponseEntity<?> deleteCommerceById(Long idCommerce){
        commerceService.deleteCommerceById(idCommerce);
        return ResponseEntity.ok("Comercio eliminado correctamente.");
    }

    ResponseEntity<?> addCategoriesToCommerce(Long idCommerce, List<Long> idCategories){
        commerceService.addCategoriesToCommerce(idCommerce,idCategories);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría/s agregadas correctamente.");
    }

    ResponseEntity<?> removeCategoriesFromCommerce(Long idCommerce, List<Long> idCategories){
        commerceService.removeCategoriesFromCommerce(idCommerce,idCategories);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría/s eliminadas correctamente.");
    }

    ResponseEntity<?> addTagsToCommerce(Long idCommerce, List<String> nameTags){
        commerceService.addTagsToCommerce(idCommerce,nameTags);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Etiqueta/s agregadas correctamente.");
    }

    ResponseEntity<?> removeTagsFromCommerce(Long idCommerce, List<Long> tagIds){
        commerceService.removeTagsFromCommerce(idCommerce, tagIds);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Etiqueta/s eliminadas correctamente.");
    }

    //TODO implementar metodo para buscar commerces por categorias
}


