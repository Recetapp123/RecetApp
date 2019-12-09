package edu.egg.RecetApp.Repositorios;

import edu.egg.RecetApp.Entidades.Ingrediente;
import edu.egg.RecetApp.Entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepositorio extends JpaRepository<Receta, String> {
    
    @Query("SELECT c FROM Receta c WHERE c.nombre = :nombre")
    public Receta buscarPorNombre(@Param("nombre") String nombre);
    

    
}
