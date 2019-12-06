package edu.egg.RecetApp.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class PrincipalControlador {
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
}
