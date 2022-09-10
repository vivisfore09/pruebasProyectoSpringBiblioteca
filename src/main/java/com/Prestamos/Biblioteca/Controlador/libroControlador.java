package com.Prestamos.Biblioteca.Controlador;

import com.Prestamos.Biblioteca.Entidades.Libro;
import com.Prestamos.Biblioteca.Servicios.libroServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class libroControlador {

    libroServicio servicio;

    public libroControlador(libroServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/AgregarLibro")
    public String agregarLibro(@RequestBody Libro libro){
        return this.servicio.agregarLibro(libro).toString();
    }

    @GetMapping("/ListarLibro")
    public List<Libro> listar(){
        return this.servicio.listarLibros();
    }

    @GetMapping("/BuscarLibro/{isbn}")
    public Optional<Libro> buscarLibro(@PathVariable("isbn") String isbn){
        return servicio.buscarLibro(isbn);
    }

    @GetMapping("/porAutor/{dato}")
    public ArrayList<Libro> porAutor(@PathVariable("dato") String autor){
       return servicio.buscarAutor(autor);
    }

    @PutMapping("/ActualizarLibro")
    public String actualizarLibro(@RequestBody Libro libro){
        return this.servicio.actualizarLibro(libro);
    }

    @PatchMapping("/ActualizarEdit/{cod}/{edit}")
    public String actualizarEditorial(@PathVariable("cod") String isbn, @PathVariable("edit") String editorial){
        return this.servicio.actualizarEditorial(isbn,editorial);
    }

    @DeleteMapping("/eliminarLibro/{isbn}")
    public String eliminarLibro(@PathVariable("isbn") String isbn){

        return servicio.eliminarLibro(isbn);
    }

}
