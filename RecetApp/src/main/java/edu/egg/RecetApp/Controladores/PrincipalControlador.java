package edu.egg.RecetApp.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class PrincipalControlador {
    @GetMapping("/")
    public String iniciosion(){
        return "indexNoLogueado";
    }
    
    @GetMapping("/indexLogueado")
    public String inicio(Model model){
        model.addAttribute("usuario", null);
        return "indexLogueado";
    }
}
