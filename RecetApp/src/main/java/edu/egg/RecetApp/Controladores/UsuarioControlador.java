package edu.egg.RecetApp.Controladores;

import edu.egg.RecetApp.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/register")
    public String registrar(@RequestParam(required = false) String id, @RequestParam MultipartFile archivo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String mail, @RequestParam String clave) {
        try{
            usuarioServicio.registrar(archivo, nombre, apellido, mail, clave);
        } catch (Exception ex){
            return "redirect:/usuario/register?id=" + id + "&error=" + ex.getMessage();
        }
        return "redirect:/pagina_principal";
    }
//    @PostMapping("/actualizar")
//    public String actualizar(@RequestParam(required = false) String id, @RequestParam String nombre, @RequestParam String apellido, ModelMap modelo) {
//
//        try {
//            autorService.actualizarAutor(id, nombre, apellido);
//        } catch (Exception ex) {
//            return "redirect:/autor/actualizacion?id=" + id + "&error=" + ex.getMessage();
//        }
//
//        return "redirect:/autor/listado";

}
