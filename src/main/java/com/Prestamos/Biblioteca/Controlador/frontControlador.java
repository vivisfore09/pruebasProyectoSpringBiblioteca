package com.Prestamos.Biblioteca.Controlador;

import com.Prestamos.Biblioteca.Entidades.Libro;
import com.Prestamos.Biblioteca.Entidades.Usuario;
import com.Prestamos.Biblioteca.Servicios.libroServicio;
import com.Prestamos.Biblioteca.Servicios.usuarioServicio;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class frontControlador {

    libroServicio servicio;
    usuarioServicio userServicio;

    public frontControlador(libroServicio servicio, usuarioServicio userServicio) {
        this.servicio = servicio;
        this.userServicio = userServicio;
    }

    /*@GetMapping("/") //Ruta Raiz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        return "index";
    }*/

    @GetMapping("/") //Ruta Raiz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            Usuario user = this.userServicio.getCrearUsuario(principal.getClaims());
            System.out.println(user.getNick());
            model.addAttribute("user",user);
            //System.out.println(principal.getClaims());//Trae informacion del usuario de inicio de sesion
        }
        return "index";
    }

    @GetMapping("/Libros")
    public String listar(Model model){
        List<Libro> lista=this.servicio.listarLibros();
        model.addAttribute("lista",lista);
        return "pruebas";
    }

   @GetMapping("/Libro/Registrar") //Para enlazar el formulario en otra pagina
    public String formularioregistroLibro(Model modelo){
        modelo.addAttribute("libro", new Libro());
        return "insertarLibro";
    }

    @PostMapping("/Libros/Insertar")
    public String agregarLibro(@Validated @ModelAttribute("libro") Libro libro,Model model,RedirectAttributes attributes){
        if(this.servicio.agregarLibro(libro)){
            attributes.addFlashAttribute("ok","Libro Registrado Exitosamente");
        }else{
            attributes.addFlashAttribute("error","Libro ya existe");
        }

        return "redirect:/Libros";
    }

    @GetMapping("/Libros/Editar/{isbn}")
    public String agregarLibro(@PathVariable("isbn") String isbn,Model model){
        model.addAttribute("libro",servicio.buscarLibro(isbn));
        return "editarLibro";
    }

    @PostMapping("/guardarEditado/{isbn}")
    public String actualizarLibro(@PathVariable("isbn") String isbn,@ModelAttribute("libro") Libro libro, Model model){
        Libro lib=servicio.buscarLibro(isbn);
        lib.setTitulo(libro.getTitulo());
        lib.setAutor(libro.getAutor());
        lib.setEditorial(libro.getEditorial());
        lib.setNo_pag(libro.getNo_pag());
        servicio.actualizarLibro(lib);
        return "redirect:/Libros";
    }

    @GetMapping("/Libros/Eliminar/{isbn}")
    public String eliminarLibro(@PathVariable("isbn") String isbn,Model model){
        servicio.eliminarLibro(isbn);
        //JOptionPane.showMessageDialog(null,"Prueba");
        return "redirect:/Libros";
    }
}
