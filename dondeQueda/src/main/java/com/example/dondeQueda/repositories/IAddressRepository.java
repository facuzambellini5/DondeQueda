package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {}
