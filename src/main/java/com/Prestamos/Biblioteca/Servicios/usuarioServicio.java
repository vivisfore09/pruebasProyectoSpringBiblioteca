package com.Prestamos.Biblioteca.Servicios;

import com.Prestamos.Biblioteca.Entidades.Usuario;
import com.Prestamos.Biblioteca.Repositorio.usuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class usuarioServicio {

    private usuarioRepositorio repositorio;

    public usuarioServicio(usuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public Usuario crear(Usuario usuario){
        return repositorio.save(usuario);
    }

    public Usuario buscarEmail(String email){
        return  this.repositorio.findByEmail(email);
    }
    public Usuario getCrearUsuario(Map<String, Object> dataUser){

        String email= (String) dataUser.get("email");
        Usuario user=buscarEmail(email); //Si ya existe solo lo retorna
        if(user==null) {
            String name = (String) dataUser.get("nickname");
            String imag = (String) dataUser.get("picture");
            String auth_id = (String) dataUser.get("sub");
            Usuario nuevo = new Usuario(email, name, imag, auth_id);
            return crear(nuevo);
        }else{
            return user;
        }


    }
}
