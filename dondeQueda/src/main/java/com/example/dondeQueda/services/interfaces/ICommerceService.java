package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Commerce;


import java.util.List;

public interface ICommerceService {

    void saveCommerce(Commerce commerce);

    void saveCommerce(CommerceDto commerceDto);

    List<Commerce> getCommerces();

    Commerce getCommerceById(Long idCommerce);

    void editCommerce(Long idCommerce, CommerceDto commerceDto);

    void deleteCommerceById(Long idCommerce);

    void deleteCommerce(Commerce commerce);
}
