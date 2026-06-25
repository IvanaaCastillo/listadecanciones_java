package com.ivana.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ivana.models.Cancion;
import com.ivana.services.ServicioCanciones;

import jakarta.validation.Valid;


@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioCanciones;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
    List<Cancion> canciones = this.servicioCanciones.obtenerTodasLasCanciones();
    model.addAttribute("canciones", canciones);
    return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion";
    }

    //Formulario para agregar canciones
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado) {
        
        if(resultado.hasErrors()) {
            return "agregarCancion";
        } else {
            servicioCanciones.agregarCancion(cancion);
            return "redirect:/canciones";
        }
    }

    //Formulario
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model){
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);

        model.addAttribute("cancion", cancion);
        model.addAttribute("idCancion", idCancion);

        return "editarCancion";
    }

    //Editar cancion
    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, Model model){

        if(resultado.hasErrors()) {
            model.addAttribute("idCancion", idCancion);
            return "editarCancion";
        }

        cancion.setId(idCancion);
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
