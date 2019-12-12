/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.egg.RecetApp.Controladores;

import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Servicios.RecetaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/")
    public String nuevareceta() {
        return "nuevareceta";
    }

    @PostMapping("/nuevareceta")
    public String nuevareceta(@RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) String nombre, @RequestParam(required = false) Integer ccal, @RequestParam String tiempo, @RequestParam(required = false) boolean vegetariano, @RequestParam(required = false) boolean vegano, @RequestParam(required = false) boolean celiaco, @RequestParam(required = false) List<Ingrediente>ingredienteEntidad, @RequestParam(required = false)String descripcion, @RequestParam(required = false) String preparacion) {
        try {
            
//<<<<<<< HEAD
//            recetaServicio.nuevaReceta(nombre, ccal, tiempo, archivo, vegetariano, vegano, celiaco);
//=======
            recetaServicio.nuevaReceta(nombre, ccal, tiempo, archivo, vegetariano, vegano, celiaco, ingredienteEntidad, descripcion, preparacion);

//>>>>>>> 3ef552fa6dae8b06715c061e7186d4c8807e33b1
        } catch (Exception ex) {
            return "redirect:/receta/nuevareceta?id=" + nombre + "&error=" + ex.getMessage();
        }
        return "redirect:/";
    }

    @PostMapping("/modificarreceta")
    public String modificarreceta(@RequestParam(required = false) String id, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) String nombre, @RequestParam(required = false) Integer ccal, @RequestParam(required = false) String tiempo, @RequestParam(required = false) boolean vegetariano, @RequestParam(required = false) boolean vegano, @RequestParam(required = false) boolean celiaco, @RequestParam(required = false) List<Ingrediente>ingredienteEntidad, @RequestParam(required = false) String descripcion, @RequestParam(required = false) String preparacion) {
        try {
            recetaServicio.modificarReceta(id, nombre, ccal, tiempo, archivo, vegetariano, vegano, celiaco, ingredienteEntidad, descripcion, preparacion);
        } catch (Exception e) {
            return "redirect:/receta/modificarreceta?id=" + id + "&error=" + e.getMessage();
        }
        return "redirect:/";
    }

}
