package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommerceRepository extends JpaRepository<Commerce, Long> {}
