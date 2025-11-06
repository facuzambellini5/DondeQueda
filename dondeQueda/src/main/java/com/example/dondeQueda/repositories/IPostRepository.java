package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

  List<Post> findByCommerce(Commerce commerce);

  @Query("""
  SELECT p
  FROM Post p
  WHERE p.postedAt >= :since
  ORDER BY p.postedAt DESC
  """)
  List<Post> findRecentPosts(@Param("since") LocalDateTime since);


  //para el feed "para ti"
  @Query("""
  SELECT p
  FROM Post p
  WHERE p.commerce.idCommerce IN :commerceIds
  AND p.postedAt >= :since
  ORDER BY p.postedAt DESC
  """)
  List<Post> findRecentPostsByCommerces(@Param("commerceIds") List<Long> commerceIds,
                                        @Param("since") LocalDateTime since);
}
