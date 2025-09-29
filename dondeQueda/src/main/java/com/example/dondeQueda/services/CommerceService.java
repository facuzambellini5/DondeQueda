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
    public void saveCommerce(Commerce commerce) {

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
    public void editCommerce(Long idCommerce, CommerceDto commerceDto) {

    }

    @Override
    public void deleteCommerceById(Long idCommerce) {

    }

    @Override
    public void deleteCommerce(Commerce commerce) {

    }
}
