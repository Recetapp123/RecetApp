package edu.egg.RecetApp.Servicios;

import edu.egg.RecetApp.Entidades.Foto;
import edu.egg.RecetApp.Entidades.Usuario;
import edu.egg.RecetApp.Errores.ErrorServicio;
import edu.egg.RecetApp.Repositorios.UsuarioRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private FotoServicio fotoServicio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrar(MultipartFile archivo, String nombre, String apellido, String mail, String clave) throws ErrorServicio {
        validar(nombre, apellido, mail, clave);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        String encriptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(encriptada);
        Foto foto = fotoServicio.guardar(archivo);
        usuario.setFoto(foto);
        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void modificarUsuario(String id, MultipartFile archivo, String nombre, String apellido, String mail, String clave) throws ErrorServicio {
        validar(nombre, apellido, mail, clave);
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = usuarioRepositorio.findById(id).get();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setMail(mail);
            String encriptada = new BCryptPasswordEncoder().encode(clave);
            usuario.setClave(encriptada);
            Foto foto = fotoServicio.guardar(archivo);
            usuario.setFoto(foto);
            usuarioRepositorio.save(usuario);
        }else{
            throw new ErrorServicio("No se encuentra el usuario");
        }
    }
    
    @Transactional
    public void Inhabilitar (String id) throws ErrorServicio{
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = usuarioRepositorio.findById(id).get();
            usuario.setFechaBaja(new Date());
            usuarioRepositorio.save(usuario);
        }else{
            throw new ErrorServicio("No se encuentra el usuario");
        }
    }
    
    @Transactional
    public void HabilitarUsuario (String id) throws ErrorServicio{
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = usuarioRepositorio.findById(id).get();
            if (usuario.getFechaBaja() == null) {
                throw new ErrorServicio("El usuario ya está dado de alta");
            }else{
                usuario.setFechaBaja(null);
            }
        }else{
            throw new ErrorServicio("No se encuentra el usuario");
        }
    }

    public List<Usuario> buscarUsuario(String q) {
        return em.createQuery("SELECT c FROM Usuario c WHERE c.nombre LIKE :q OR c.apellido LIKE :q").setParameter("q", "%" + q + "%").getResultList();
    }

    public void validar(String nombre, String apellido, String mail, String clave) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del usuario no puede ser nulo.");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new ErrorServicio("El apellido del usuario no puede ser nulo.");
        }
        if (mail == null || mail.isEmpty()) {
            throw new ErrorServicio("El mail del usuario no puede ser nulo.");
        }
        if (clave == null || clave.isEmpty() || clave.length() <= 6) {
            throw new ErrorServicio("La clave del usuario no puede ser nula y tiene que tener mas de 6 digitos.");
        }
    }

}
