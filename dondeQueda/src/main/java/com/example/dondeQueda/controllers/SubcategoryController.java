package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.SubcategoryDto;
import com.example.dondeQueda.models.Subcategory;
import com.example.dondeQueda.services.interfaces.ISubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategoria")
public class SubcategoryController {

    @Autowired
    private ISubcategoryService subcategoryService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveSubcategory(@RequestBody SubcategoryDto subcategoryDto){
        subcategoryService.saveSubcategory(subcategoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Subcategoría creada correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<Subcategory>> getSubcategories(){
        return ResponseEntity.ok(subcategoryService.getSubcategories());
    }

    @GetMapping("/traer/{idSubcategory}")
    public ResponseEntity<?> getSubcategoryById(@PathVariable Long idSubcategory){
        return ResponseEntity.ok(subcategoryService.getSubcategoryById(idSubcategory));
    }

    @PutMapping("/editar/{idSubcategory}")
    public ResponseEntity<?> editSubcategory(@PathVariable Long idSubcategory,
                                  @RequestBody SubcategoryDto subcategoryDto){
        subcategoryService.editSubcategory(idSubcategory, subcategoryDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Subcategoría editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idSubcategory}")
    public ResponseEntity<?> deleteSubcategoryById(@PathVariable Long idSubcategory){
        subcategoryService.deleteSubcategoryById(idSubcategory);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Subcategoría eliminada correctamente.");
    }
}
