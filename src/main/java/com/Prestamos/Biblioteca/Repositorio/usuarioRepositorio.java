package com.Prestamos.Biblioteca.Repositorio;

import com.Prestamos.Biblioteca.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Map;


@Repository
public interface usuarioRepositorio extends JpaRepository<Usuario,Long> {

    Usuario findByEmail(String email);
}
