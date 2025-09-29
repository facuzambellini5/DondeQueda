package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.SubcategoryDto;
import com.example.dondeQueda.models.Subcategory;

import java.util.List;

public interface ISubcategoryService {

    void saveSubcategory(SubcategoryDto subcategoryDto);

    List<Subcategory> getSubcategories();

    Subcategory getSubcategoryById(Long idSubcategory);

    void editSubcategory(Long idSubcategory, SubcategoryDto subcategoryDto);

    void deleteSubcategoryById(Long idSubcategory);
}
