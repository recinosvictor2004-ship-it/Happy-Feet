package com.mycompany.happyfeetveterinaria.service;

import com.mycompany.happyfeetveterinaria.model.entities.Cita;
import com.mycompany.happyfeetveterinaria.repository.CitaRepository;

public class CitaService {

    private final CitaRepository repository;

    public CitaService() {
        repository = new CitaRepository();
    }

    public boolean guardar(Cita cita) {
        return repository.guardar(cita);
    }
}