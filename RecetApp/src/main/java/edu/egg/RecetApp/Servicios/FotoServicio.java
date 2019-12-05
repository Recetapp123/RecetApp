package edu.egg.RecetApp.Servicios;

import org.springframework.stereotype.Service;
import edu.egg.RecetApp.Entidades.Foto;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.FotoRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
class FotoServicio {

    @Autowired
    private FotoRepositorio fotoRepositorio;

    @Transactional
    public Foto guardar(MultipartFile archivo) throws ErrorServicio {
        if (archivo != null) {
            try {
                Foto foto = new Foto();
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    @Transactional
    public Foto actualizar(String idFoto, MultipartFile archivo) throws ErrorServicio {
        if (archivo != null) {
            try {
                Foto foto = new Foto();
                if(idFoto != null){
                    Optional<Foto> respuesta = fotoRepositorio.findById(idFoto);
                    if(respuesta.isPresent()){
                        foto = respuesta.get();
                    }
                }
                
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                
                return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;

    }
}
