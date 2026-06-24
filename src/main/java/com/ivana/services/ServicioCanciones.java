package com.ivana.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivana.models.Cancion;
import com.ivana.repositories.RepositorioCanciones;

@Service
public class ServicioCanciones {
    
    @Autowired
    private RepositorioCanciones repositorioCanciones;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repositorioCanciones.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> resultado = repositorioCanciones.findById(id);
        return resultado.orElse(null);
    }
    
    //Agregar canciones
    public Cancion agregarCancion(Cancion cancion) {
        return repositorioCanciones.save(cancion);
    }
}
