package com.uptc.sw2.biblioteca.biblioteca.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRep extends JpaRepository<Libro, Long> {

    @Query("select v from Libro v order by v.nombre")
    List<Libro> findAllOrderByNombre();

    @Query("from Libro v where v.editorial.id = ?1 order by v.nombre")
    List<Libro> findByEditorialOrderByNombre(Long id);

    @Query("from Libro l where l.nombre like %?1%")
    List<Libro> buscar(String consulta);



}
