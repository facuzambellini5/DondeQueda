package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.models.Commerce;


import java.util.List;

public interface ICommerceService {

    void saveCommerce(Commerce commerce);

    void saveCommerce(CommerceDto commerceDto);

    List<Commerce> getCommerces();

    Commerce getCommerceById(Long idCommerce);

    void editCommerce(Long idCommerce, CommerceDto commerceDto);

    void deleteCommerceById(Long idCommerce);

    void addCategoriesToCommerce(Long idCommerce, List<Long> idCategories);

    void removeCategoriesFromCommerce(Long idCommerce, List<Long> idCategories);

    void addTagsToCommerce(Long idCommerce, List<String> nameTags);

    void removeTagsFromCommerce(Long idCommerce, List<Long> tagIds);

    //TODO implementar este metodo
    List<Commerce> getCommercesByCategories(List<Category> categories);
}
