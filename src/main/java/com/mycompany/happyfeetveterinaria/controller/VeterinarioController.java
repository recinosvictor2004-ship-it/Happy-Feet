package com.mycompany.happyfeetveterinaria.controller;

import com.mycompany.happyfeetveterinaria.model.entities.Veterinario;
import com.mycompany.happyfeetveterinaria.service.VeterinarioService;

import java.util.List;

public class VeterinarioController {

    private final VeterinarioService service;

    public VeterinarioController() {
        service = new VeterinarioService();
    }

    public boolean guardar(Veterinario veterinario) {
        return service.guardar(veterinario);
    }

    public List<Veterinario> listarTodos() {
        return service.listarTodos();
    }

    public Veterinario buscarPorId(int id) {
        return service.buscarPorId(id);
    }
}