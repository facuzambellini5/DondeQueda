package com.example.dondeQueda.services;

import com.example.dondeQueda.dtos.AddressDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.repositories.IAddressRepository;
import com.example.dondeQueda.services.interfaces.IAddressService;
import com.example.dondeQueda.services.interfaces.IEntityValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {

  @Autowired private IAddressRepository addressRepo;
  @Autowired private IEntityValidatorService validatorService;

  @Override
  public String saveAddress(AddressDto addressDto) {

    Address address = new Address();

    address.setAddress(addressDto.getAddress());
    address.setStreet(addressDto.getStreet());
    address.setDistrict(addressDto.getDistrict());
    address.setLocation(addressDto.getLocation());

    addressRepo.save(address);

    return "Dirección guardada correctamente.";
  }

  @Override
  public List<Address> getAddresses() {
    return addressRepo.findAll();
  }

  @Override
  public Address getAddressById(Long idAddress) {
    return validatorService.validateAddress(idAddress);
  }

  @Override
  public String editAddress(Long idAddress, AddressDto addressDto) {

    Address address = this.getAddressById(idAddress);

    address.setAddress(addressDto.getAddress());
    address.setStreet(addressDto.getStreet());
    address.setDistrict(addressDto.getDistrict());
    address.setLocation(addressDto.getLocation());

    addressRepo.save(address);

    return "Dirección editada correctamente.";
  }

  @Override
  public String deleteAddressById(Long idAddress) {

    Address address = this.getAddressById(idAddress);
    addressRepo.deleteById(idAddress);

    return "Dirección eliminada correctamente.";
  }
}
