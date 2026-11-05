package com.mycompany.happyfeetveterinaria.service;

import com.mycompany.happyfeetveterinaria.model.entities.Mascota;
import com.mycompany.happyfeetveterinaria.repository.MascotaRepository;

import java.util.List;

public class MascotaService {

    private final MascotaRepository repository;

    public MascotaService() {
        repository = new MascotaRepository();
    }

    public boolean guardar(Mascota mascota) {
        return repository.guardar(mascota);
    }

    public List<Mascota> listarTodos() {
        return repository.listarTodos();
    }

    public Mascota buscarPorId(int id) {
        return repository.buscarPorId(id);
    }
}