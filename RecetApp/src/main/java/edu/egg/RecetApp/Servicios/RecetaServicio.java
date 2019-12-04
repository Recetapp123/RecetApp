package edu.egg.RecetApp.Servicios;

import edu.egg.RecetApp.Entidades.Foto;
import edu.egg.RecetApp.Entidades.Receta;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.RecetaRepositorio;
import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RecetaServicio {

    @Autowired
    RecetaRepositorio recetaRepositorio;
    @Autowired
    FotoServicio fotoServicio;

    @Transactional
    public void nuevaReceta(String nombre, Integer ccal, String tiempo, MultipartFile archivo, boolean vegetariano, boolean vegano, boolean celiaco) throws ErrorServicio {
        validar(nombre, ccal, tiempo);
        Receta receta = new Receta();
        receta.setNombre(nombre);
        receta.setTiempo(tiempo);
        receta.setVegano(vegano);
        receta.setVegetariano(vegetariano);
        receta.setCeliaco(celiaco);
        Foto foto = fotoServicio.guardar(archivo);
        receta.setFoto(foto);
        recetaRepositorio.save(receta);
    }

    @Transactional
    public void modificarReceta(String id, String nombre, Integer ccal, String tiempo, MultipartFile archivo, boolean vegetariano, boolean vegano, boolean celiaco) throws ErrorServicio {
        validar(nombre, ccal, tiempo);
        Optional<Receta> respuesta = recetaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Receta receta = recetaRepositorio.findById(id).get();
            receta.setNombre(nombre);
            receta.setTiempo(tiempo);
            receta.setVegano(vegano);
            receta.setVegetariano(vegetariano);
            receta.setCeliaco(celiaco);
            Foto foto = fotoServicio.guardar(archivo);
            receta.setFoto(foto);
            recetaRepositorio.save(receta);
        } else {
            throw new ErrorServicio("No se ha encontrado la receta");
        }
    }

    @Transactional
    public void InhabilitarReceta(String id) throws ErrorServicio {
        Optional<Receta> respuesta = recetaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Receta receta = recetaRepositorio.findById(id).get();
            receta.setFechaBaja(new Date());
            recetaRepositorio.save(receta);
        } else {
            throw new ErrorServicio("No se encuentra la receta");
        }
    }

    @Transactional
    public void HabilitarReceta(String id) throws ErrorServicio {
        Optional<Receta> respuesta = recetaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Receta receta = recetaRepositorio.findById(id).get();
            if (receta.getFechaBaja() == null) {
                throw new ErrorServicio("La receta ya está dada de alta");
            } else {
                receta.setFechaBaja(null);
                recetaRepositorio.save(receta);
            }
        } else {
            throw new ErrorServicio("No se encuentra la receta");
        }
    }

    public void validar(String nombre, Integer ccal, String tiempo) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre de la receta no puede ser nulo.");
        }
        if (ccal == null) {
            throw new ErrorServicio("Las calorias no pueden ser nulas.");
        }
        if (tiempo == null || tiempo.isEmpty()) {
            throw new ErrorServicio("El tiempo de cocción no puede ser nulo.");
        }
    }
}
