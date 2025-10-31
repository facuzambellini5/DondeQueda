package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCommerce(Commerce commerce);


    @Query("""
            SELECT
            """)
    List<Post> findRecentPosts(@Param("cutOff") String cutOff);

    List<Post> findByCreatedAtOrderBy();

}
