package com.napptilus.willywonka.reactive.repository;

import com.napptilus.willywonka.entity.OompaLoompa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Repository
 */
@Repository
public interface OompaLoompaRepository extends JpaRepository<OompaLoompa, Long> {

    /**
     * Find By Name Method
     * @param name name
     * @return OompaLoompa
     */
    Optional<OompaLoompa> findByName(String name);
}
