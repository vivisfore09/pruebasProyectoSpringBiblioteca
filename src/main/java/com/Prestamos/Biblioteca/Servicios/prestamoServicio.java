package com.Prestamos.Biblioteca.Servicios;

import com.Prestamos.Biblioteca.Entidades.Libro;
import com.Prestamos.Biblioteca.Entidades.Prestamo;
import com.Prestamos.Biblioteca.Repositorio.estudianteRepositorio;
import com.Prestamos.Biblioteca.Repositorio.libroRepositorio;
import com.Prestamos.Biblioteca.Repositorio.prestamoRepositorio;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class prestamoServicio {

    private prestamoRepositorio repositorio;
    private libroRepositorio repositorioLib;
    private estudianteRepositorio repositorioEst;

    public prestamoServicio(prestamoRepositorio repositorio, libroRepositorio repositorioLib, estudianteRepositorio repositorioEst) {
        this.repositorio = repositorio;
        this.repositorioLib = repositorioLib;
        this.repositorioEst = repositorioEst;
    }

    public ArrayList<Prestamo> listarPorLibro(String isbn){
        ArrayList<Prestamo> lista=null;
        if(!this.repositorioLib.existsById(isbn)){
            return lista;
        }
        return repositorio.findByLibro(repositorioLib.findById(isbn).get());

    }
    public Prestamo agregarPrestamo(String isbn, String doc, Prestamo prestamo){

       /*return repositorioLib.findById(isbn)
                .map(libro->{
                    prestamo.setLibro(libro);
                    return repositorio.save(prestamo);
                }).get();*/

        repositorioLib.findById(isbn)
                .map(libro->{
                    prestamo.setLibro(libro);
                    return libro;
                   // return repositorio.save(prestamo);
                });
        return repositorioEst.findById(doc)
                .map(estudiante->{
                    prestamo.setEstudiante(estudiante);
                    //return libro;
                    return repositorio.save(prestamo);
                }).get();
    }
}
