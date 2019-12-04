package edu.egg.RecetApp.Servicios;

import edu.egg.RecetApp.Entidades.Foto;
import edu.egg.RecetApp.Entidades.Receta;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.RecetaRepositorio;
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
    public void nuevaReceta(String nombre, Integer ccal, String tiempo, MultipartFile archivo, boolean vegetariano, boolean vegano, boolean celiaco) throws ErrorServicio{
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
