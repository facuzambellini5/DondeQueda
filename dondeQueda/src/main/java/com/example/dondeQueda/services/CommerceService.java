package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceService implements ICommerceService {

    @Override
    public String saveCommerce(CategoryDto categoryDto) {
        return "";
    }

    @Override
    public String saveCommerce(Commerce commerce) {
        return "";
    }

    @Override
    public List<Commerce> getCommerces() {
        return List.of();
    }

    @Override
    public Commerce getCommerceById(Long idCommerce) {
        return null;
    }

    @Override
    public String editCommerce(Long idCommerce, CommerceDto commerceDto) {
        return "";
    }

    @Override
    public String deleteCommerceById(Long idCommerce) {
        return "";
    }

    @Override
    public String deleteCommerce(Commerce commerce) {
        return "";
    }
}
