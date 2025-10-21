package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Category;
import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommerceRepository extends JpaRepository<Commerce, Long> {

  // Buscar commerces por usuario(dueño)
  List<Commerce> findByOwner(User owner);

  @Query(
      """
    SELECT c
    FROM Commerce c
    JOIN c.categories cat
    WHERE cat.idCategory IN :categoryIds
    """)
  List<Commerce> findByCategoryIds(@Param("categoryIds") List<Long> categoryIds);


  // Buscador principal de commerces
  @Query(
          value = """
    SELECT DISTINCT c.*
    FROM commerce c
    LEFT JOIN commerce_tag ct ON c.id_commerce = ct.id_commerce
    LEFT JOIN tag t ON ct.id_tag = t.id_tag
    WHERE c.name LIKE %:searchParam%
       OR t.name_tag LIKE %:searchParam%
    ORDER BY
        CASE
            WHEN c.name LIKE CONCAT(:searchParam, '%') THEN 1   -- nombre empieza con el texto
            WHEN c.name LIKE %:searchParam% THEN 2              -- nombre contiene el texto
            ELSE 3                                              -- coincide solo en tag
        END,
        c.name ASC
    LIMIT :limit OFFSET :offset
    """,
          nativeQuery = true)
  List<Commerce> searchByNameOrTag(@Param("searchParam") String searchParam,
                                 @Param("limit") int limit,
                                 @Param("offset") int offset);
}
