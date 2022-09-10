package com.Prestamos.Biblioteca.Repositorio;

import com.Prestamos.Biblioteca.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface libroRepositorio extends JpaRepository<Libro,String> {

    /*@Query("select * from libro where autor=:aut")
    public ArrayList<Libro> buscarAutor(String aut);*/

    ArrayList<Libro> findByAutor(String autor);
}
