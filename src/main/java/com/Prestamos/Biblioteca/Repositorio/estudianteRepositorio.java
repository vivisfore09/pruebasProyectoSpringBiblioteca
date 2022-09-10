package com.Prestamos.Biblioteca.Repositorio;

import com.Prestamos.Biblioteca.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface estudianteRepositorio extends JpaRepository<Estudiante,String> {
}
