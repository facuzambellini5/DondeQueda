package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.repositories.ICategoryRepository;
import com.example.dondeQueda.services.interfaces.ICategoryService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired private ICategoryRepository categoryRepo;

    @Override
    public void saveCategory(CategoryDto categoryDto) {

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        categoryRepo.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long idCategory) {
        return ValidationUtils.validateEntity(categoryRepo.findById(idCategory),"Categoría", idCategory);
    }

    @Override
    public void editCategory(Long idCategory, CategoryDto categoryDto) {

        Category category = this.getCategoryById(idCategory);

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategoryById(Long idCategory) {

        Category category = this.getCategoryById(idCategory);
        categoryRepo.delete(category);
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
