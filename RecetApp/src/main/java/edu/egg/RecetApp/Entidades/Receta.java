
package edu.egg.RecetApp.Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Receta {
    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    
    private String nombre;
    private Integer ccal;
    private String tiempo;
    private boolean vegetariano;
    private boolean vegano;
    private boolean celiaco;
    
    @OneToOne
    private Foto foto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    
    @OneToMany
    private Ingrediente ingredienteentidad;
    
    @OneToMany
    private Voto voto;
    

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
     * @return the foto
     */
    public Foto getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Foto foto) {
        this.foto = foto;
    }

  
    /**
     * @return the ingredienteentidad
     */
    public Ingrediente getIngredienteentidad() {
        return ingredienteentidad;
    }

    /**
     * @param ingredienteentidad the ingredienteentidad to set
     */
    public void setIngredienteentidad(Ingrediente ingredienteentidad) {
        this.ingredienteentidad = ingredienteentidad;
    }

    /**
     * @return the fechaBaja
     */
    public Date getFechaBaja() {
        return fechaBaja;
    }

    /**
     * @param fechaBaja the fechaBaja to set
     */
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    /**
     * @return the voto
     */
    public Voto getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(Voto voto) {
        this.voto = voto;
    }
    
    
}
