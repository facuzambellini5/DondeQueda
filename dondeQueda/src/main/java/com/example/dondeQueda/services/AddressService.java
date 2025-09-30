package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.AddressDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.repositories.IAddressRepository;
import com.example.dondeQueda.services.interfaces.IAddressService;
import com.example.dondeQueda.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

  @Autowired private IAddressRepository addressRepo;

  @Override
  public void saveAddress(AddressDto addressDto) {

    Address address = new Address();

    address.setAddress(addressDto.getAddress());
    address.setStreet(addressDto.getStreet());
    address.setDistrict(addressDto.getDistrict());
    address.setLocation(addressDto.getLocation());

    addressRepo.save(address);
  }

  @Override
  public List<Address> getAddresses() {
    return addressRepo.findAll();
  }

  @Override
  public Address getAddressById(Long idAddress) {
    return ValidationUtils.validateEntity(addressRepo.findById(idAddress), "Dirección", idAddress);
  }

  @Override
  public void editAddress(Long idAddress, AddressDto addressDto) {

    Address address = this.getAddressById(idAddress);

    address.setAddress(addressDto.getAddress());
    address.setStreet(addressDto.getStreet());
    address.setDistrict(addressDto.getDistrict());
    address.setLocation(addressDto.getLocation());

    addressRepo.save(address);
  }

  @Override
  public void deleteAddressById(Long idAddress) {

    Address address = this.getAddressById(idAddress);
    addressRepo.delete(address);
  }
}
