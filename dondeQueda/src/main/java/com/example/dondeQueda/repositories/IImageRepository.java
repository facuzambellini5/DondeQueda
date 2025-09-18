package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import com.example.dondeQueda.models.Image;
import com.example.dondeQueda.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByCommerceOrderByImageOrder(Commerce commerce);

    List<Image> findByEventOrderByImageOrder(Event event);

    List<Image> findByPostOrderByImageOrder(Post post);



}
