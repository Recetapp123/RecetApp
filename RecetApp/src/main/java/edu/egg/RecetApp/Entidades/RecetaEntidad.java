
package edu.egg.RecetApp.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecetaEntidad {
    
    @Id
    private String id;
    
    private String nombre;
    private Integer ccal;
    private String tiempo;
    private boolean vegetariano;
    private boolean vegano;
    private boolean celiaco;
    private boolean carnivoro;

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

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the vegetariano
     */
    public boolean isVegetariano() {
        return vegetariano;
    }

    /**
     * @param vegetariano the vegetariano to set
     */
    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    /**
     * @return the vegano
     */
    public boolean isVegano() {
        return vegano;
    }

    /**
     * @param vegano the vegano to set
     */
    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    /**
     * @return the celiaco
     */
    public boolean isCeliaco() {
        return celiaco;
    }

    /**
     * @param celiaco the celiaco to set
     */
    public void setCeliaco(boolean celiaco) {
        this.celiaco = celiaco;
    }

    /**
     * @return the carnivoro
     */
    public boolean isCarnivoro() {
        return carnivoro;
    }

    /**
     * @param carnivoro the carnivoro to set
     */
    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }
    
    
}
