package com.mycompany.happyfeetveterinaria.controller;

import com.mycompany.happyfeetveterinaria.model.entities.Mascota;
import com.mycompany.happyfeetveterinaria.service.MascotaService;

import java.util.List;

public class MascotaController {

    private final MascotaService service;

    public MascotaController() {
        service = new MascotaService();
    }

    public boolean guardar(Mascota mascota) {
        return service.guardar(mascota);
    }

    public List<Mascota> listarTodos() {
        return service.listarTodos();
    }

    public Mascota buscarPorId(int id) {
        return service.buscarPorId(id);
    }
}
