package edu.egg.RecetApp.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class PrincipalControlador {
    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("usuario", null);
        return "index";
    }
}
