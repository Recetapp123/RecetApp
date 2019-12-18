package edu.egg.RecetApp.Controladores;

import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Entidades.Usuario;
import edu.egg.RecetApp.Servicios.IngredienteServicio;
import edu.egg.RecetApp.Servicios.UsuarioServicio;
import java.util.List;
import java.util.Optional;
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
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String iniciosion() {
        return "indexNoLogueado";
    }

    @GetMapping("/prueba")
    public String prueba() {
        return "index";
    }

    @GetMapping("/indexLogueado")
    public String inicio(Model model) {
        model.addAttribute("usuario", null);
        return "indexLogueado";
    }

    @GetMapping("/buscarNoLogueado")
    public String buscador(@RequestParam(required = false) String q, @RequestParam(required = false) String error, ModelMap modelo) {
        List<Ingrediente> ingredientes;
        if (q != null) {
            ingredientes = ingredienteServicio.buscarIngredientes(q);
        } else {
            ingredientes = ingredienteServicio.buscarIngredientes();
        }
        modelo.put("q", q);
        modelo.put("ingredientes", ingredientes);
        modelo.put("error", error);
        return "indexNoLogueado";
    }

    @GetMapping("/buscarLogueado")
    public String buscadorLogueado(@RequestParam(required = false) String q, @RequestParam(required = false) String error, ModelMap model,@RequestParam(name = "MAIL", required = false) String MAIL, @RequestParam(name = "CLAVE", required = false) String CLAVE) {
        List<Ingrediente> ingredientes;
        Usuario usuario= usuarioServicio.buscarUsuario(MAIL, CLAVE);
        if (q != null) {
            ingredientes = ingredienteServicio.buscarIngredientes(q);
        } else {
            ingredientes = ingredienteServicio.buscarIngredientes();
        }
        model.put("q",q);
        model.put("ingredientes", ingredientes);
        model.put("error",error);
        model.addAttribute("usuario", usuario);
        return "indexLogueado";
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
