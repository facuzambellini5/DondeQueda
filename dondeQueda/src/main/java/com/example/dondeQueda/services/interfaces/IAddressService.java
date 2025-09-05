package com.example.dondeQueda.services.interfaces;


import com.example.dondeQueda.dtos.AddressDto;
import com.example.dondeQueda.models.Address;

import java.util.List;

public interface IAddressService {

    String saveAddress(AddressDto addressDto);

    List<Address> getAddresses();

    Address getAddressById(Long idAddress);

    String editAddress(Long idAddress, AddressDto addressDto);

    String deleteAddressById(Long idAddress);
}
