package com.example.dondeQueda.repositories;

import com.example.dondeQueda.models.Commerce;
import com.example.dondeQueda.models.Event;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {

    @Query("""
    SELECT e
    FROM Event e
    WHERE e.endDate >= :now
    AND e.isActive = true
    ORDER BY e.startDate ASC
    """)
    List<Event> findActiveAndUpcomingEvents(@Param("now")LocalDateTime now);

    //Para el feed "para ti"
    @Query("""
    SELECT DISTINCT e
    FROM Event e
    JOIN e.commerces c
    WHERE c.idCommerce IN :commerceIds
    AND e.endDate >= :now
    AND e.isActive = true
    ORDER BY e.startDate ASC
    """)
    List<Event> findActiveAndUpcomingEventsByCommerces(@Param("commerceIds")List<Long> commerceIds,
                                                       @Param("now") LocalDateTime now);
}
