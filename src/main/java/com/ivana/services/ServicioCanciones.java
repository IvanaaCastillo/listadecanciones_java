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

    //Obtener todas las canciones
    public List<Cancion> obtenerTodasLasCanciones() {
        return repositorioCanciones.findAll();
    }

    //Obtener una cancion por id
    public Cancion obtenerCancionPorId(Long id) {
        Optional<Cancion> resultado = repositorioCanciones.findById(id);
        return resultado.orElse(null);
    }
    
    //Agregar canciones
    public Cancion agregarCancion(Cancion cancion) {
        return repositorioCanciones.save(cancion);
    }

    //Actualizar canciones
    public Cancion actualizarCancion(Cancion cancion) {
        return repositorioCanciones.save(cancion);
    }

    //Eliminar canciones
    public void eliminaCancion(Long id) {
        repositorioCanciones.deleteById(id);
    }
}
