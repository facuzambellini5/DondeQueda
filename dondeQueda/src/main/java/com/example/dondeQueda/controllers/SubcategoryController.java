package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.SubcategoryDto;
import com.example.dondeQueda.models.Subcategory;
import com.example.dondeQueda.services.interfaces.ISubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategoria")
public class SubcategoryController {

    @Autowired
    private ISubcategoryService subcategoryService;

    @PostMapping("/guardar")
    public String saveSubcategory(@RequestBody SubcategoryDto subcategoryDto){
        return subcategoryService.saveSubcategory(subcategoryDto);
    }

    @GetMapping("/traer")
    public List<Subcategory> getSubcategories(){
        return subcategoryService.getSubcategories();
    }

    @GetMapping("/traer/{idSubcategory}")
    public Subcategory getSubcategoryById(@PathVariable Long idSubcategory){
        return subcategoryService.getSubcategoryById(idSubcategory);
    }

    @PutMapping("/editar/{idSubcategory}")
    public String editSubcategory(@PathVariable Long idSubcategory,
                                  @RequestBody SubcategoryDto subcategoryDto){
        return subcategoryService.editSubcategory(idSubcategory, subcategoryDto);
    }

    @DeleteMapping("/eliminar/{idSubcategory}")
    public String deleteSubcategoryById(@PathVariable Long idSubcategory){
        return subcategoryService.deleteSubcategoryById(idSubcategory);
    }

}
