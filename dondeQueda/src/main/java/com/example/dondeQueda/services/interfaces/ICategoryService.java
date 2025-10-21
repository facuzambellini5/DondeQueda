package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;

import java.util.List;

public interface ICategoryService {

    void saveCategory(CategoryDto categoryDto);

    List<Category> getCategories();

    Category getCategoryById(Long idCategory);

    void editCategory(Long idCategory, CategoryDto categoryDto);

    void deleteCategoryById(Long idCategory);

    List<CategoryDto> getCategoryDtos();

}
