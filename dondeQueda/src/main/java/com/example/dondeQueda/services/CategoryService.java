package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.repositories.ICategoryRepository;
import com.example.dondeQueda.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired private ICategoryRepository categoryRepo;
    @Autowired private IEntityValidatorService validatorService;

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
    return validatorService.validateCategory(idCategory);
    }

    @Override
    public String editCategory(Long idCategory, CategoryDto categoryDto) {

        Category category = this.getCategoryById(idCategory);

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);

        return "Categoría editada correctamente.";
    }

    @Override
    public String deleteCategoryById(Long idCategory) {

        Category category = this.getCategoryById(idCategory);
        categoryRepo.delete(category);

        return "Categoría eliminada correctamente.";
    }

    @Override
    public List<CategoryDto> getCategoriesDto() {

        List<Category> categories = this.getCategories();
        List<CategoryDto> categoriesDto = new ArrayList<>();

        for(Category category : categories){
            CategoryDto categoryDto = new CategoryDto(category.getName(), category.getDescription());
            categoriesDto.add(categoryDto);
        }
        return categoriesDto;
    }
}
