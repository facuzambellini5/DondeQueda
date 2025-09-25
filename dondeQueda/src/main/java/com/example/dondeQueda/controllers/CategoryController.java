package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/guardar")
    public String saveCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }

    @GetMapping("/traer")
    public List<CategoryDto> getCategoriesDto(){
        return categoryService.getCategoriesDto();
    }

    @GetMapping("/traer/{idCategory}")
    public Category getCategoryById(@PathVariable Long idCategory){
        return categoryService.getCategoryById(idCategory);
    }

    @PutMapping("/editar/{idCategory}")
    public String editCategory(@PathVariable Long idCategory,
                               @RequestBody CategoryDto categoryDto){
        return categoryService.editCategory(idCategory, categoryDto);
    }

    @DeleteMapping("/eliminar/{idCategory}")
    public String deleteCategoryById(@PathVariable Long idCategory){
        return categoryService.deleteCategoryById(idCategory);
    }

}
