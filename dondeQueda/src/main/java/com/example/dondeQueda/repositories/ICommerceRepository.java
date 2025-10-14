package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommerceRepository extends JpaRepository<Commerce, Long> {

    //Buscar commerces por usuario(dueño)
    List<Commerce> findByOwner(User owner);

}
