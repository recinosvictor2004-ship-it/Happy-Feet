package com.mycompany.happyfeetveterinaria.controller;

import com.mycompany.happyfeetveterinaria.model.entities.Dueno;
import com.mycompany.happyfeetveterinaria.service.DuenoService;

import java.util.List;

public class DuenoController {

    private final DuenoService service;

    public DuenoController() {
        service = new DuenoService();
    }

    public boolean guardar(Dueno dueno) {
        return service.guardar(dueno);
    }

    public List<Dueno> listarTodos() {
        return service.listarTodos();
    }

    public Dueno buscarPorId(int id) {
        return service.buscarPorId(id);
    }
}