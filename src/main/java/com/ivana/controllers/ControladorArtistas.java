package com.ivana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ivana.models.Artista;
import com.ivana.services.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
    
    @Autowired
    private ServicioArtistas servicioArtistas;


    //VER TODOS LOS ARTISTAS
    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo) {
        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
        return "artistas";
    }

    //DETALLE
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista, Model modelo){
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        modelo.addAttribute("artista", artista);
        return "detalleArtista";
    }

        //FORMULARIO PARA AGREGAR ARTISTA
    @GetMapping({"/artistas/formulario/agregar", "/artistas/formulario/agregar/{idArtista}"})
    public String formularioAgregarArtista(@PathVariable(value = "idArtista", required = false) Long idArtista, @ModelAttribute("artista") Artista artista) {
        return "agregarArtista";
    }

    //PROCESO AGREGAR ARTISTA
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult resultado) {
            
            if(resultado.hasErrors()) {
                return "agregarArtista";
            } else {
                servicioArtistas.agregarArtista(artista);
                return "redirect:/artistas";
            }
        }
}

