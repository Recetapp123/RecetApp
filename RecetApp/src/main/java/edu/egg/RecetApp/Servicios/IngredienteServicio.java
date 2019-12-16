package edu.egg.RecetApp.Servicios;

import edu.egg.RecetApp.Entidades.Foto;
import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.IngredienteRepositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IngredienteServicio {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IngredienteRepositorio ingredienteRepositorio;
    @Autowired
    private FotoServicio fotoServicio;

    @Transactional
    public void nuevoIngrediente(String nombre, MultipartFile archivo) throws ErrorServicio {
        validar(nombre);
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(nombre);
        Foto foto = fotoServicio.guardar(archivo);
        ingrediente.setFoto(foto);
        ingredienteRepositorio.save(ingrediente);
    }

    public void validar(String nombre) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del ingrediente no puede ser nulo.");
        }
    }
    
    public Ingrediente buscarPorId(String id){
        return em.find(Ingrediente.class, id);
    }

    public List<Ingrediente> buscarIngredientes(String q) {
        return em.createQuery("SELECT c FROM Ingrediente c WHERE c.nombre LIKE :q").setParameter("q", "%" + q + "%").getResultList();
    }
    public List<Ingrediente> buscarIngredientes() {
        return em.createQuery("SELECT c FROM Ingrediente c").getResultList();
    }
    
}
