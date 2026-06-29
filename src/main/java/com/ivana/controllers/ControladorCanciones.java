package com.ivana.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivana.models.Artista;
import com.ivana.models.Cancion;
import com.ivana.services.ServicioArtistas;
import com.ivana.services.ServicioCanciones;

import jakarta.validation.Valid;


@Controller
public class ControladorCanciones {
    
    private final ServicioCanciones servicioCanciones;
    private final ServicioArtistas servicioArtistas;

    public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas servicioArtistas) {
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
    List<Cancion> canciones = this.servicioCanciones.obtenerTodasLasCanciones();
    modelo.addAttribute("canciones", canciones);
    return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    //Formulario para agregar canciones
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo) {
        modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        modelo.addAttribute("cancion", new Cancion());
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, @RequestParam Long artistaId, Model modelo) {
    
        if(resultado.hasErrors()){
            modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancion.setArtista(artista);
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    //Formulario
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model modelo){
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);

        modelo.addAttribute("cancion", cancion);
        modelo.addAttribute("idCancion", idCancion);
        modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "editarCancion";
    }

    //Editar cancion
    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, @RequestParam("artistaId") Long artistaId, Model modelo){

        if(resultado.hasErrors()) {
            modelo.addAttribute("idCancion", idCancion);
            modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }
        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        cancion.setId(idCancion);
        cancion.setArtista(artista);
        servicioCanciones.actualizarCancion(cancion);
        return "redirect:/canciones";
    }

    //Eliminar canción
    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion){
        this.servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
}
