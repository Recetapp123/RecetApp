package edu.egg.RecetApp.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredienteEntidad {
    
    @Id
    private String id;
    
    private String nombre;
    private Integer ccal;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ccal
     */
    public Integer getCcal() {
        return ccal;
    }

    /**
     * @param ccal the ccal to set
     */
    public void setCcal(Integer ccal) {
        this.ccal = ccal;
    }
    
    
}
