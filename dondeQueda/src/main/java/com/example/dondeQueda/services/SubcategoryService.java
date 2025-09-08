package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.SubcategoryDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.models.Subcategory;
import com.example.dondeQueda.repositories.ICategoryRepository;
import com.example.dondeQueda.repositories.ISubcategoryRepository;
import com.example.dondeQueda.services.interfaces.IEntityValidatorService;
import com.example.dondeQueda.services.interfaces.ISubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService implements ISubcategoryService {

  @Autowired private ISubcategoryRepository subcategoryRepo;
  @Autowired private ICategoryRepository categoryRepo;
  @Autowired private IEntityValidatorService validatorService;

  @Override
  public String saveSubcategory(SubcategoryDto subcategoryDto) {

    Subcategory subcategory = new Subcategory();
    Category category = validatorService.validateCategory(subcategoryDto.getIdCategory());

    subcategory.setName(subcategoryDto.getName());
    subcategory.setDescription(subcategoryDto.getDescription());

    subcategory.setCategory(category);
    category.getSubcategories().add(subcategory);
    subcategoryRepo.save(subcategory);
    categoryRepo.save(category);

    return "Subcateogía guardada correctamente.";
  }

  @Override
  public List<Subcategory> getSubcategories() {
    return subcategoryRepo.findAll();
  }

  @Override
  public Subcategory getSubcategoryById(Long idSubcategory) {
    return validatorService.validateSubcategory(idSubcategory);
  }

  @Override
  public String editSubcategory(Long idSubcategory, SubcategoryDto subcategoryDto) {

    Subcategory subcategory = this.getSubcategoryById(idSubcategory);

    subcategory.setName(subcategoryDto.getName());
    subcategory.setDescription(subcategoryDto.getDescription());

    if (!subcategory.getCategory().getIdCategory().equals(subcategoryDto.getIdCategory())) {

      Category previousCategory = subcategory.getCategory();
      Category newCategory = validatorService.validateCategory(subcategoryDto.getIdCategory());

      subcategory.setCategory(newCategory);

      previousCategory.getSubcategories().remove(subcategory);
      newCategory.getSubcategories().add(subcategory);

      subcategoryRepo.save(subcategory);
      categoryRepo.save(previousCategory);
      categoryRepo.save(newCategory);
    }
    return "Subcategoría editada correctamente.";
  }

  @Override
  public String deleteSubcategoryById(Long idSubcategory) {

    Subcategory subcategory = this.getSubcategoryById(idSubcategory);
    subcategoryRepo.delete(subcategory);

    return "Subcategoría eliminada correctamente.";
  }
}
