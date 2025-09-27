package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.AddressDto;
import com.example.dondeQueda.models.Address;

import java.util.List;

public interface IAddressService {

    void saveAddress(AddressDto addressDto);

    List<Address> getAddresses();

    Address getAddressById(Long idAddress);

    void editAddress(Long idAddress, AddressDto addressDto);

    void deleteAddressById(Long idAddress);
}
