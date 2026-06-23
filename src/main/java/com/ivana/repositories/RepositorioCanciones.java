package com.ivana.repositories;

import java.util.List;

import com.ivana.models.Cancion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    List<Cancion> findAll();
}
