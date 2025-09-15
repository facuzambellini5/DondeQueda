package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.models.Category;

import java.util.List;

public interface ICategoryService {

    String saveCategory(CategoryDto categoryDto);

    List<Category> getCategories();

    Category getCategoryById(Long idCategory);

    String editCategory(Long idCategory, CategoryDto categoryDto);

    String deleteCategoryById(Long idCategory);

    List<CategoryDto> getCategoriesDto();

}
