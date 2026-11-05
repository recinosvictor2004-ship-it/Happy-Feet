package com.mycompany.happyfeetveterinaria.service;

import com.mycompany.happyfeetveterinaria.model.entities.Veterinario;
import com.mycompany.happyfeetveterinaria.repository.VeterinarioRepository;

import java.util.List;

public class VeterinarioService {

    private final VeterinarioRepository repository;

    public VeterinarioService() {
        repository = new VeterinarioRepository();
    }

    public boolean guardar(Veterinario veterinario) {
        return repository.guardar(veterinario);
    }

    public List<Veterinario> listarTodos() {
        return repository.listarTodos();
    }

    public Veterinario buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}