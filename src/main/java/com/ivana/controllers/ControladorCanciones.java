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
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivana.models.Cancion;
import com.ivana.services.ServicioCanciones;

import jakarta.validation.Valid;


@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioCanciones;

    @RequestMapping("/canciones")
    public String desplegarCanciones(Model model) {
    List<Cancion> canciones = servicioCanciones.obtenerTodasLasCanciones();
    model.addAttribute("canciones", canciones);
    return "canciones.jsp";
    }

    @RequestMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion.jsp";
    }

    //Formulario para agregar canciones
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado) {
        
        if(resultado.hasErrors()) {
            return "agregarCancion.jsp";
        }
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    //Formulario
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model model){
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);

        model.addAttribute("cancion", cancion);
        model.addAttribute("idCancion", idCancion);

        return "editarCancion.jsp";
    }

    //Editar cancion
    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable Long idCancion, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado, Model model){

        if(resultado.hasErrors()) {
            model.addAttribute("idCancion", idCancion);
            return "editarCancion.jsp";
        }

        cancion.setId(idCancion);
        servicioCanciones.actualizarCancion(cancion);
        return "redirect:/canciones";
    }
}
