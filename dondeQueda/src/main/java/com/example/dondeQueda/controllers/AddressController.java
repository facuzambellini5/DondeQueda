package com.example.dondeQueda.controllers;

import com.example.dondeQueda.dtos.AddressDto;
import com.example.dondeQueda.models.Address;
import com.example.dondeQueda.services.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccion")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/guardar")
    public ResponseEntity<?> saveAddress(@RequestBody AddressDto addressDto){

        addressService.saveAddress(addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dirección guardada correctamente.");
    }

    @GetMapping("/traer")
    public ResponseEntity<List<Address>> getAddresses(){
        return ResponseEntity.ok(addressService.getAddresses());
    }

    @GetMapping("/traer/{idAddress}")
    public ResponseEntity<?> getAddressById(@PathVariable Long idAddress){
        return ResponseEntity.ok(addressService.getAddressById(idAddress));
    }

    @PutMapping("/editar/{idAddress}")
    public ResponseEntity<?> editAddress(@PathVariable Long idAddress,
                              @RequestBody AddressDto addressDto){
        addressService.editAddress(idAddress, addressDto);
        return ResponseEntity.ok("Dirección editada correctamente.");
    }

    @DeleteMapping("/eliminar/{idAddress}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long idAddress){

        addressService.deleteAddressById(idAddress);

        return ResponseEntity.ok("Dirección eliminada correctamente.");
    }
}
