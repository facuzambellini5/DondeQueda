package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByNameTag(String nameTag);
}
