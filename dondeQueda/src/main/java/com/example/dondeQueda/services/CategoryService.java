package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.repositories.ICategoryRepository;
import com.example.dondeQueda.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepo;

    @Override
    public String saveCategory(CategoryDto categoryDto) {
        Category category = new Category();

        category.setName(categoryDto.getName());

        category.setDescription(categoryDto.getDescription());

        categoryRepo.save(category);

        return "Categoria guardada correctamente.";
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long idCategory) {

        return categoryRepo.findById(idCategory).orElse(null);
    }

    @Override
    public String editCategory(Long idCategory, CategoryDto categoryDto) {

        Category category = this.getCategoryById(idCategory);

        if(category != null){
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            categoryRepo.save(category);
            return "Categoría editada correctamente.";

        } else {
            return "Categoría con ID: '" + idCategory +"' no encontrada.";
        }
    }

    @Override
    public String deleteCategoryById(Long idCategory) {

        Category category = this.getCategoryById(idCategory);

        if(category != null){
            categoryRepo.deleteById(idCategory);
            return "Categoría eliminada correctamente.";
        } else {
            return "Categoría con ID: '" + idCategory +"' no encontrada.";
        }
    }
}
