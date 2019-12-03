package edu.egg.RecetApp.Entidades;

import javax.persistence.Lob;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class Foto {
    
    @Id
    String id;
    
    private String nombre;
    
    @Lob @Basic(fetch = FetchType.LAZY)
    byte[] contenido;
}
