package edu.egg.RecetApp.Entidades;

import javax.persistence.Lob;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Foto {
    
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid2")
    private String id;
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] contenido;

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
     * @return the contenido
     */
    public byte[] getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
    
    
}
