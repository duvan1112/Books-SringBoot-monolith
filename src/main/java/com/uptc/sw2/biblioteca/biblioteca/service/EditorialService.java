package com.uptc.sw2.biblioteca.biblioteca.service;

import com.uptc.sw2.biblioteca.biblioteca.domain.Editorial;
import com.uptc.sw2.biblioteca.biblioteca.domain.EditorialRep;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EditorialService {

    private final EditorialRep editorialRep;

    public EditorialService(EditorialRep editorialRep) {
        this.editorialRep = editorialRep;
    }

    public List<Editorial> buscarTodos() {
        return editorialRep.findAll();
    }
}
