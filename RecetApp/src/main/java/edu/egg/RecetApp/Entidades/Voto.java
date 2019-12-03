
package edu.egg.RecetApp.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Voto {
    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    
    @ManyToOne
    private RecetaEntidad recetaentidad;

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
     * @return the recetaentidad
     */
    public RecetaEntidad getRecetaentidad() {
        return recetaentidad;
    }

    /**
     * @param recetaentidad the recetaentidad to set
     */
    public void setRecetaentidad(RecetaEntidad recetaentidad) {
        this.recetaentidad = recetaentidad;
    }
    
    
}
