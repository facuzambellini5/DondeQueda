package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Commerce;


import java.util.List;

public interface ICommerceService {

    String saveCommerce(CategoryDto categoryDto);

    String saveCommerce(Commerce commerce);

    List<Commerce> getCommerces();

    Commerce getCommerceById(Long idCommerce);

    String editCommerce(Long idCommerce, CommerceDto commerceDto);

    String deleteCommerceById(Long idCommerce);

    String deleteCommerce(Commerce commerce);
}
