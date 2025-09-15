package com.example.dondeQueda.repositories;

import com.example.dondeQueda.enums.EntityType;
import com.example.dondeQueda.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByEntityTypeAndIdEntityOrderByImageOrder(EntityType entityType, Long idEntity);

}
