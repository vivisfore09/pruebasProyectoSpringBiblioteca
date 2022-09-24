package com.Prestamos.Biblioteca.Servicios;

import com.Prestamos.Biblioteca.Entidades.Libro;
import com.Prestamos.Biblioteca.Repositorio.libroRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class libroServicio {

    private libroRepositorio repositorio;

    public libroServicio(libroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    //Consultar Todos los registros de la Tabla
    public List<Libro> listarLibros(){
        return  repositorio.findAll();
    }


    public Libro buscarLibro(String isbn){

        return repositorio.findById(isbn).get();
    }

    public ArrayList<Libro> buscarAutor(String autor){
        return repositorio.findByAutor(autor);
    }

    public boolean agregarLibro(Libro libro){

        if(repositorio.findById(libro.getIsbn()).isPresent()) {
            return false;
        }else {
            repositorio.save(libro);
            return true;
        }

        }



    /*public String actualizarLibro(Libro libro){
        if(buscarLibro(libro.getIsbn()).isPresent()){
            repositorio.save(libro);
            return "Libro Actualizado Exitosamente";
        }else{
            return "El Libro a modificar no existe";
        }
    }*/

    public Libro actualizarLibro(Libro libro){
        return repositorio.save(libro);
    }

    public String actualizarEditorial(String isbn, String editorial){

        if(repositorio.findById(isbn).isPresent()){
            Libro libro=repositorio.findById(isbn).get();
            libro.setEditorial(editorial);
            repositorio.save(libro);
            //return new ResponseEntity<Libro>(repositorio.save(libro), HttpStatus.OK);
           return "Editorial actualizada";
        }else{
           // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return "Error al actualizar";
        }
    }

    /*public String eliminarLibro(String isbn){
        if(buscarLibro(isbn).isPresent()){
            repositorio.deleteById(isbn);
            return "Libro Eliminado Exitosamente";
        }else{
            return "El Libro a eliminar no existe";
        }
    }*/
    public void eliminarLibro(String isbn){
        repositorio.deleteById(isbn);

    }

}
