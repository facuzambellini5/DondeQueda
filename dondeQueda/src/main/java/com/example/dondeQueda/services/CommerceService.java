package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CategoryDto;
import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceService implements ICommerceService {

    @Autowired
    private UserService userService;


    @Override
    public void saveCommerce(Commerce commerce) {

    }



    @Override
    public void saveCommerce(CommerceDto commerceDto) {

        Commerce commerce = new Commerce();
        User owner = userService.getUserById(commerceDto.getIdOwner());

        commerce.setName(commerceDto.getName());
        commerce.setDescription(commerceDto.getDescription());
        commerce.setPhone(commerceDto.getPhone());
        commerce.setLink(commerceDto.getLink());
        commerce.setEmail(commerceDto.getEmail());
        commerce.setBranchOf(commerceDto.getBranchOf());
        commerce.setOwner(owner);
    
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
