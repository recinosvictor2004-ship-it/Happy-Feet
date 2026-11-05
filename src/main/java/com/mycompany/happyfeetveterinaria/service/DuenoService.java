package com.mycompany.happyfeetveterinaria.service;

import com.mycompany.happyfeetveterinaria.model.entities.Dueno;
import com.mycompany.happyfeetveterinaria.repository.DuenoRepository;

import java.util.List;

public class DuenoService {

    private final DuenoRepository repository;

    public DuenoService() {
        repository = new DuenoRepository();
    }

    public boolean guardar(Dueno dueno) {
        return repository.guardar(dueno);
    }

    public List<Dueno> listarTodos() {
        return repository.listarTodos();
    }

    public Dueno buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}