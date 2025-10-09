package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.CommerceDto;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.User;
import com.example.dondeQueda.repositories.ICommerceRepository;
import com.example.dondeQueda.services.interfaces.ICommerceService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommerceService implements ICommerceService {

    @Autowired
    private ICommerceRepository commerceRepo;
    @Autowired
    private UserService userService;


    @Override
    public void saveCommerce(Commerce commerce) {
        commerceRepo.save(commerce);
    }

    @Override
    public void saveCommerce(CommerceDto commerceDto) {

        Commerce commerce = new Commerce();
        Optional<Commerce> mainCommerceOptional = commerceRepo.findById(commerceDto.getBranchOf());

        User owner = userService.getUserById(commerceDto.getIdOwner());

        commerce.setName(commerceDto.getName());
        commerce.setDescription(commerceDto.getDescription());
        commerce.setPhone(commerceDto.getPhone());
        commerce.setLink(commerceDto.getLink());
        commerce.setEmail(commerceDto.getEmail());

        if(mainCommerceOptional.isPresent()) {
            Commerce mainCommerce = this.getCommerceById(commerce.getIdCommerce());
            commerce.setBranchOf(mainCommerce);
        }
        commerce.setOwner(owner);
    }

    @Override
    public List<Commerce> getCommerces() {
        return commerceRepo.findAll();
    }

    @Override
    public Commerce getCommerceById(Long idCommerce) {
        return ValidationUtils.validateEntity(commerceRepo.findById(idCommerce), "Comercio", idCommerce);
    }

    @Override
    public void editCommerce(Long idCommerce, CommerceDto commerceDto) {

        Commerce commerce = this.getCommerceById(idCommerce);

        if(commerceDto.getName() != null) {
            commerce.setName(commerceDto.getName());
        }

        if(commerceDto.getDescription() != null) {
            commerce.setDescription(commerceDto.getDescription());
        }

        if(commerceDto.getPhone() != null) {
            commerce.setPhone(commerceDto.getPhone());
        }

        if(commerceDto.getLink() != null) {
            commerce.setLink(commerceDto.getLink());
        }

        if(commerceDto.getEmail() != null) {
            commerce.setEmail(commerceDto.getEmail());
        }

    }

    @Override
    public void deleteCommerceById(Long idCommerce) {

    }

    @Override
    public void deleteCommerce(Commerce commerce) {

    }
}
