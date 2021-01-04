package com.napptilus.willywonka.reactive.service;

import com.napptilus.willywonka.entity.OompaLoompa;
import com.napptilus.willywonka.reactive.repository.OompaLoompaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * OompaLoompa Service Implementation
 */
@Service
@Slf4j
public class OompaLoompaService implements IOompaLoompaService {

    /**
     * Property OL Repository Object
     */
    private final OompaLoompaRepository oompaLoompaRepository;

    /**
     * Constructor
     * @param oompaLoompaRepository oompaLoompaRepository
     */
    public OompaLoompaService(@Autowired OompaLoompaRepository oompaLoompaRepository) {
        this.oompaLoompaRepository = oompaLoompaRepository;
    }

    /**
     * Save Method
     * @param oompaLoompa object
     * @return object
     */
    @Override
    public Mono<OompaLoompa> save(OompaLoompa oompaLoompa) {
        LOG.info("Save Oompa Loompa Object {}", oompaLoompa);
        return Mono.create(oompaLoompaMono -> {
            OompaLoompa olObj = oompaLoompaRepository.save(oompaLoompa);
            oompaLoompaMono.success(olObj);
        });
    }

    /**
     * Save All Method
     * @param oompaLoompas list of object
     * @return Objects
     */
    @Override
    public Flux<OompaLoompa> saveAll(List<OompaLoompa> oompaLoompas) {
        LOG.info("Save all Oompa Loompa Objects - total size {}", oompaLoompas.size());
        return Flux.fromIterable(oompaLoompaRepository.saveAll(oompaLoompas));
    }

    /**
     * Find By Id Method
     * @param id Long
     * @return Object
     */
    @Override
    public Mono<OompaLoompa> findById(Long id) {
        LOG.info("Find Oompa Loompa Object by ID {}", id);
        return Mono.create(oompaLoompaMono -> {
            Optional<OompaLoompa> oompaLoompaOptional = oompaLoompaRepository.findById(id);
            oompaLoompaMono.success(oompaLoompaOptional.get());
        });
    }

    /**
     * Find All Method
     * @return list of Objects
     */
    @Override
    public Flux<OompaLoompa> findAll() {
        LOG.info("Find Oompa Loompa Objects");
        return Flux.fromIterable(oompaLoompaRepository.findAll());
    }

    /**
     * Find By Name Method
     * @param name name
     * @return OompaLoompa
     */
    @Override
    public Mono<OompaLoompa> findByName(String name) {
        return Mono.create(oompaLoompaMonoSink -> {
            Optional<OompaLoompa> oompaLoompaOptional = oompaLoompaRepository.findByName(name);
            oompaLoompaMonoSink.success(oompaLoompaOptional.get());
        });
    }
}
