/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.RecetApp.Controladores;

import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Servicios.IngredienteServicio;
import edu.egg.RecetApp.Servicios.RecetaServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author maria
 */
@Controller
@RequestMapping("/receta")
public class RecetaControlador {

    @Autowired
    RecetaServicio recetaServicio;

    @Autowired
    IngredienteServicio ingredienteServicio;

    @GetMapping("/crearing")
    public String nuevoIng() {
        return "crearingrediente";
    }

    @PostMapping("/crear")
    public String nuevoIngrediente(@RequestParam MultipartFile archivo, @RequestParam(required = false) String nombre) {
        try {
            ingredienteServicio.nuevoIngrediente(nombre, archivo);
        } catch (Exception ex) {
            return "redirect:/receta/nuevareceta?id=" + nombre + "&error=" + ex.getMessage();
        }
        return "/crearingrediente";
    }

    @GetMapping("/")
    public String nuevareceta() {
        return "nuevareceta";
    }

    @PostMapping("/nuevarecetaCrear")
    public String nuevareceta(ModelMap modelo,@RequestParam(required = false) String error, @RequestParam(required = false) String q, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) Ingrediente i1, @RequestParam(required = false) Ingrediente i2, @RequestParam(required = false) Ingrediente i3, @RequestParam(required = false) Ingrediente i4, @RequestParam(required = false) Ingrediente i5, @RequestParam(required = false) Ingrediente i6, @RequestParam(required = false) Ingrediente i7, @RequestParam(required = false) Ingrediente i8, @RequestParam(required = false) Ingrediente i9, @RequestParam(required = false) Ingrediente i10, @RequestParam(required = false) String nombre, @RequestParam(required = false) Integer ccal, @RequestParam String tiempo, @RequestParam(required = false) boolean vegetariano, @RequestParam(required = false) boolean vegano, @RequestParam(required = false) boolean celiaco, @RequestParam(required = false) List<Ingrediente> ingredienteEntidad, @RequestParam(required = false) String descripcion) throws ErrorServicio {
        List<Ingrediente> ingredientes;
        if (q != null) {
            ingredientes = ingredienteServicio.buscarIngredientes(q);
        } else {
            ingredientes = ingredienteServicio.buscarIngredientes();
        }
        ingredientes.add(i1);
        ingredientes.add(i2);
        ingredientes.add(i3);
        ingredientes.add(i4);
        ingredientes.add(i5);
        ingredientes.add(i6);
        ingredientes.add(i7);
        ingredientes.add(i8);
        ingredientes.add(i9);
        ingredientes.add(i10);
        recetaServicio.nuevaReceta(nombre, tiempo, archivo, vegetariano, vegano, celiaco, ingredientes, descripcion);

        modelo.put("q", q);
        modelo.put("ingredientes", ingredientes);
        modelo.put("error", error);
        return "redirect:/";
    }

    @PostMapping("/modificarreceta")
    public String modificarreceta(@RequestParam(required = false) String id, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) String nombre, @RequestParam(required = false) Integer ccal, @RequestParam(required = false) String tiempo, @RequestParam(required = false) boolean vegetariano, @RequestParam(required = false) boolean vegano, @RequestParam(required = false) boolean celiaco, @RequestParam(required = false) List<Ingrediente> ingredienteEntidad, @RequestParam(required = false) String descripcion, @RequestParam(required = false) String preparacion) {
        try {
            recetaServicio.modificarReceta(id, nombre, ccal, tiempo, archivo, vegetariano, vegano, celiaco, ingredienteEntidad, descripcion, preparacion);
        } catch (Exception e) {
            return "redirect:/receta/modificarreceta?id=" + id + "&error=" + e.getMessage();
        }
        return "redirect:/";
    }

}
