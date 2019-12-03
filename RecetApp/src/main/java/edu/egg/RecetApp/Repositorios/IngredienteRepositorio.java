package edu.egg.RecetApp.Repositorios;

import edu.egg.RecetApp.Entidades.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepositorio extends JpaRepository<Ingrediente, String>{
    
    @Query("SELECT c FROM Ingrediente c WHERE c.nombre = :nombre")
    public Ingrediente buscarPorNombre(@Param("nombre") String nombre);
    
}
