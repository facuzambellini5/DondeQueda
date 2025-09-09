package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.AddressDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.services.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccion")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/guardar")
    public String saveAddress(@RequestBody AddressDto addressDto){
        return addressService.saveAddress(addressDto);
    }

    @GetMapping("/traer")
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping("/traer/{idAddress}")
    public Address getAddressById(@PathVariable Long idAddress){
        return addressService.getAddressById(idAddress);
    }

    @PutMapping("/editar/{idAddress}")
    public String editAddress(@PathVariable Long idAddress,
                              @RequestBody AddressDto addressDto){
        return addressService.editAddress(idAddress, addressDto);
    }

    @DeleteMapping("/eliminar/{idAddress}")
    public String deleteAddressById(@PathVariable Long idAddress){
        return addressService.deleteAddressById(idAddress);
    }
}
