package com.uptc.sw2.biblioteca.biblioteca.service;

import com.uptc.sw2.biblioteca.biblioteca.domain.Libro;
import com.uptc.sw2.biblioteca.biblioteca.domain.LibroRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRep libroRep;

    public LibroService(LibroRep libroRep) {
        this.libroRep = libroRep;
    }

    public List<Libro> buscarDestacados() {
        return libroRep.findAllOrderByNombre();
    }

    public List<Libro> buscarPorEditorial(Long id) {
        return libroRep.findByEditorialOrderByNombre(id);
    }


    public List<Libro> buscar(String consulta) {
        return libroRep.buscar(consulta);
    }

    public Libro guardar(Libro libro) {
        return libroRep.save(libro);
    }

//    public List<Libro> buscarDestacados() {
//        return libroRep.findAll();
//    }

//    public List<Libro> buscarDestacados() {
//        List<Libro> destacados = new ArrayList<>();
//        Libro libro = new Libro();
//
//        libro.setNombre("El principito");
//        libro.setDescripcion("El principito es un cuento infantil escrito por Antoine de Saint-Exupéry, publicado en 1943. Es una de las obras más traducidas y vendidas de la literatura francesa. La obra fue escrita en francés, pero se ha traducido a más de 180 idiomas.");
//        libro.setImgUrl("https://estaticos-cdn.elperiodico.com/clip/0ee81a9a-086b-42ac-afed-8b78635e896e_alta-libre-aspect-ratio_default_0.jpg");
//
//        destacados.add(libro);
//
//        return destacados;
//    }
}
