package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.SubcategoryDto;
import com.example.dondeQueda.models.Subcategory;

import java.util.List;

public interface ISubcategoryService {

    String saveSubcategory(SubcategoryDto subcategoryDto);

    List<Subcategory> getSubcategories();

    Subcategory getSubcategoryById(Long idSubcategory);

    String editSubcategory(Long idSubcategory, SubcategoryDto subcategoryDto);

    String deleteSubcategoryById(Long idSubcategory);
}
