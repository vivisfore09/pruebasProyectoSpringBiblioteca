package com.Prestamos.Biblioteca.Repositorio;

import com.Prestamos.Biblioteca.Entidades.Libro;
import com.Prestamos.Biblioteca.Entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface prestamoRepositorio extends JpaRepository<Prestamo, Integer> {

    ArrayList<Prestamo> findByLibro(Libro libro);
}
