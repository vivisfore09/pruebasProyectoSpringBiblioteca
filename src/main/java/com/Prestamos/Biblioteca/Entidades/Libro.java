package com.Prestamos.Biblioteca.Entidades;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Libro")
public class Libro{
    @Id
    @Column(unique = true,length = 25)
    private String Isbn;
    @Column(nullable = false,length=50)
    private String titulo;
    @Column(nullable = false,length=50)
    private String editorial;
    @Column(nullable = false,length=50)
    private String autor;
    @Column(nullable = false)
    private int No_pag;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Prestamo> prestamos;

    public Libro(String isbn, String titulo, String editorial, String autor, int no_pag) {
        Isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        No_pag = no_pag;
    }

    public Libro() {
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNo_pag() {
        return No_pag;
    }

    public void setNo_pag(int no_pag) {
        No_pag = no_pag;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Isbn='" + Isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", autor='" + autor + '\'' +
                ", No_pag=" + No_pag +
                '}';
    }
}
