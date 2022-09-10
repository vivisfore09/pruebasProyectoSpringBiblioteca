package com.Prestamos.Biblioteca.Controlador;

import com.Prestamos.Biblioteca.Entidades.Prestamo;
import com.Prestamos.Biblioteca.Servicios.prestamoServicio;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class prestamoControlador {

    prestamoServicio servicio;

    public prestamoControlador(prestamoServicio servicio) {
        this.servicio = servicio;
    }


/*@PostMapping("/AgregarPrestamo")
    public String agregarPrestamo(@RequestBody @Validated Prestamo prestamo){
        return this.servicio.agregarPrestamo(prestamo).toString();
    }*/

    @GetMapping("/ListarPrestamo/{isbn}")
    public ArrayList<Prestamo> porLibro(@PathVariable("isbn") String isbn){
        return servicio.listarPorLibro(isbn);
    }

    @PostMapping("/AgregarPrestamo/{isbn}/{est}")
    public Prestamo add(@PathVariable("isbn") String isbn, @PathVariable("est") String doc,@Validated @RequestBody Prestamo prestamo) {
        return servicio.agregarPrestamo(isbn,doc,prestamo);
    }

}
