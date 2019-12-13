package edu.egg.RecetApp.Controladores;

import edu.egg.RecetApp.Entidades.Usuario;
import edu.egg.RecetApp.Servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String register() {
        return "register";
    }
//    @GetMapping("/lo")
//    public String login(){
//        return "login";
//    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "MAIL", required = false) String MAIL, @RequestParam(name="CLAVE",required = false) String CLAVE, @RequestParam(required = false) String error, ModelMap modelo) {
        Usuario usuario;
        if (MAIL != null && CLAVE != null) {            
            usuario = usuarioServicio.buscarUsuario(MAIL, CLAVE);
            modelo.put("usuario", usuario);
           
            if(usuario==null){
                return "login";
            }
            return "indexLogueado";
         
        }
//        try{
//            usuarioServicio.login(mail, clave);
//            
//        }catch (Exception ex){
//            return "redirect:/usuario/register?id=" + mail + "&error=" + ex.getMessage();
//        }
        return "login";
    }

    @PostMapping("/registrar")
    public String register(@RequestParam(required = false) String id, @RequestParam(required = false) MultipartFile archivo, @RequestParam(required = false) String nombre, @RequestParam(required = false) String apellido, @RequestParam String mail, @RequestParam(required = false) String clave) {
        try {
            usuarioServicio.registrar(archivo, nombre, apellido, mail, clave);

//            usuarioServicio.registrar(null, "Fabri", "Perez", "elo@hotmail.com", "12345678899");
        } catch (Exception ex) {
            return "redirect:/usuario/register?id=" + id + "&error=" + ex.getMessage();
        }
        return "redirect:/usuario/login";
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
