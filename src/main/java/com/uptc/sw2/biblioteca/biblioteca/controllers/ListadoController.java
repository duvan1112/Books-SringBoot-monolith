package com.uptc.sw2.biblioteca.biblioteca.controllers;

import com.uptc.sw2.biblioteca.biblioteca.domain.Libro;
import com.uptc.sw2.biblioteca.biblioteca.service.EditorialService;
import com.uptc.sw2.biblioteca.biblioteca.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListadoController {

    private LibroService libroService;

    private EditorialService editorialService;

    public ListadoController(LibroService libroService, EditorialService editorialService) {
        this.libroService = libroService;
        this.editorialService = editorialService;
    }

    @RequestMapping({"", "/", "/listado"})
    public String ListarLibros(Model model) {
        List<Libro> destacados = libroService.buscarDestacados();
        model.addAttribute("libros", destacados);
        return "listado";
    }

    @RequestMapping("/librosPorEditorial")
    public String ListarLibrosPorEditorial(Model model, Long id) {
        List<Libro> libros = libroService.buscarPorEditorial(id);
        model.addAttribute("libros", libros);
        return "listado";
    }


    @RequestMapping("/buscar")
    public String buscar(Model model, String consulta) {
        List<Libro> libros = libroService.buscar(consulta);
        model.addAttribute("libros", libros);
        return "listado";
    }

    @RequestMapping("/libros/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("editoriales", editorialService.buscarTodos());
        model.addAttribute("libro", new Libro());
        return "formLibro";
    }


    @PostMapping("/libros/guardar")
    public String guardar(Libro libro) {
        libroService.guardar(libro);
        return "redirect:/";
    }

}
