package edu.egg.RecetApp.Controladores;

import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Servicios.IngredienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inicio")
public class PrincipalControlador {

    @Autowired
    private IngredienteServicio ingredienteServicio;
    
    @GetMapping("/")
    public String iniciosion() {
        return "indexNoLogueado";
    }

    @GetMapping("/indexLogueado")
    public String inicio(Model model) {
        model.addAttribute("usuario", null);
        return "indexLogueado";
    }

    @GetMapping("/buscar")
    public String buscador(@RequestParam(required = false) String q, @RequestParam(required = false) String error, ModelMap modelo) {
        List<Ingrediente> ingredientes;
        if (q != null) {
            ingredientes = ingredienteServicio.buscarIngredientes(q);
        }else{
            ingredientes = ingredienteServicio.buscarIngredientes();
        }
        modelo.put("q",q);
        modelo.put("ingredientes", ingredientes);
        modelo.put("error",error);
        return "indexNoLogueado";
    }
    @GetMapping(value = "/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable(value = "id") String id) {

        Ingrediente ingrediente = null;
        ingrediente = ingredienteServicio.buscarPorId(id);

        byte[] foto = ingrediente.getFoto().getContenido();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(foto, headers, HttpStatus.OK);

    }
}
