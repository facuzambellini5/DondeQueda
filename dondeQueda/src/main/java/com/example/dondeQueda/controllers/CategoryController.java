package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://5pwhrv-5173.csb.app")
@RequestMapping("/categoria")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoría creada correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<CategoryDto>> getCategoriesDto(){
        return ResponseEntity.ok(categoryService.getCategoriesDto());
    }

    @GetMapping("/traer/{idCategory}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long idCategory){
        return ResponseEntity.ok(categoryService.getCategoryById(idCategory));
    }

    @PutMapping("/editar/{idCategory}")
    public ResponseEntity<?> editCategory(@PathVariable Long idCategory,
                               @RequestBody CategoryDto categoryDto){

        categoryService.editCategory(idCategory, categoryDto);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idCategory}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long idCategory){
        categoryService.deleteCategoryById(idCategory);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoría eliminada correctamente.");
    }

}
