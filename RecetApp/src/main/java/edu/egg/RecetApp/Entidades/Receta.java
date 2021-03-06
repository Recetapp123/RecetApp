
package edu.egg.RecetApp.Entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
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
    private String tiempo;
    private boolean vegetariano;
    private boolean vegano;
    private boolean celiaco;
    private String descripcion;
    private String preparacion;
    
    @OneToOne
    private Foto foto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    
    @ManyToMany
    private List<Ingrediente> ingredienteentidad;
    
    @OneToMany
    private List<Voto> voto;
    

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

    public List<Ingrediente> getIngredienteentidad() {
        return ingredienteentidad;
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

    public List<Voto> getVoto() {
        return voto;
    }

    public void setVoto(List<Voto> voto) {
        this.voto = voto;
    }

    

    /**
     * @param ingredienteentidad the ingredienteentidad to set
     */
    public void setIngredienteentidad(List<Ingrediente> ingredienteentidad) {
        this.ingredienteentidad = ingredienteentidad;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the preparacion
     */
    public String getPreparacion() {
        return preparacion;
    }

    /**
     * @param preparacion the preparacion to set
     */
    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
    
    
}
