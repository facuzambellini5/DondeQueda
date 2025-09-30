package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.SubcategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.models.Subcategory;
import com.example.dondeQueda.repositories.ICategoryRepository;
import com.example.dondeQueda.repositories.ISubcategoryRepository;
import com.example.dondeQueda.services.interfaces.ICategoryService;
import com.example.dondeQueda.services.interfaces.ISubcategoryService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService implements ISubcategoryService {

  @Autowired private ISubcategoryRepository subcategoryRepo;
  @Autowired private ICategoryService categoryService;

  @Override
  public void saveSubcategory(SubcategoryDto subcategoryDto) {

    Subcategory subcategory = new Subcategory();
    Category category = categoryService.getCategoryById(subcategoryDto.getIdCategory());

    subcategory.setName(subcategoryDto.getName());
    subcategory.setDescription(subcategoryDto.getDescription());

    subcategory.setCategory(category);
    category.getSubcategories().add(subcategory);
    subcategoryRepo.save(subcategory);

    //categoryRepo.save(category); TODO: ver implementación de CASCADE
  }

  @Override
  public List<Subcategory> getSubcategories() {
    return subcategoryRepo.findAll();
  }

  @Override
  public Subcategory getSubcategoryById(Long idSubcategory) {
    return ValidationUtils.validateEntity(subcategoryRepo.findById(idSubcategory),"Subcategoría",idSubcategory);
  }

  @Override
  public void editSubcategory(Long idSubcategory, SubcategoryDto subcategoryDto) {

    Subcategory subcategory = this.getSubcategoryById(idSubcategory);

    subcategory.setName(subcategoryDto.getName());
    subcategory.setDescription(subcategoryDto.getDescription());

    if (!subcategory.getCategory().getIdCategory().equals(subcategoryDto.getIdCategory())) {

      Category previousCategory = subcategory.getCategory();
      Category newCategory = categoryService.getCategoryById(subcategoryDto.getIdCategory());

      subcategory.setCategory(newCategory);

      previousCategory.getSubcategories().remove(subcategory);
      newCategory.getSubcategories().add(subcategory);

      subcategoryRepo.save(subcategory);
      //categoryRepo.save(previousCategory); TODO: ver implementación de CASCADE
      //categoryRepo.save(newCategory); TODO: ver implementación de CASCADE
    }
  }

  @Override
  public void deleteSubcategoryById(Long idSubcategory) {

    Subcategory subcategory = this.getSubcategoryById(idSubcategory);
    subcategoryRepo.delete(subcategory);
  }
}
