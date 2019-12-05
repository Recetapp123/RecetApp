package edu.egg.RecetApp.Servicios;

import edu.egg.RecetApp.Entidades.Voto;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.RecetaRepositorio;
import edu.egg.RecetApp.Repositorios.VotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoServicio {
    @Autowired
    VotoRepositorio votoRepositorio;
    @Autowired
    RecetaRepositorio recetaRepositorio;
    public void Votar(String idUsuario, String idReceta) throws ErrorServicio{
        Voto voto = new Voto();
    }
}
