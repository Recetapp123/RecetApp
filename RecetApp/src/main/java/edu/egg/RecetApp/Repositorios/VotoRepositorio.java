package edu.egg.RecetApp.Repositorios;

import edu.egg.RecetApp.Entidades.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepositorio extends JpaRepository<Voto, String> {
    
    
    
}
