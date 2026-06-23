package com.ivana.controllers;

import java.util.List;

import com.ivana.services.ServicioCanciones;
import com.ivana.models.Cancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


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
}
