
package edu.egg.RecetApp.Servicios;

import edu.egg.RecetApp.Entidades.Foto;
import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.IngredienteRepositorio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IngredienteServicio {
    
    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;
    @Autowired
    private FotoServicio fotoServicio;
    
    @Transactional
    public void nuevoIngrediente(String nombre, Integer ccal, MultipartFile archivo) throws ErrorServicio{
        validar(nombre, ccal);
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(nombre);
        Foto foto = fotoServicio.guardar(archivo);
        ingrediente.setFoto(foto);
        ingredienteRepositorio.save(ingrediente);
    }
    public void validar(String nombre, Integer ccal) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del ingrediente no puede ser nulo.");
        }
        if (ccal == null){
            throw new ErrorServicio("Las calorias del ingrediente no pueden ser nulas ser nulo.");
        }
        
    }
}
