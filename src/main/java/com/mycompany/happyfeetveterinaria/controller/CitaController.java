package com.mycompany.happyfeetveterinaria.controller;

import com.mycompany.happyfeetveterinaria.model.entities.Cita;
import com.mycompany.happyfeetveterinaria.service.CitaService;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitaController {

    private final CitaService service;

    public CitaController() {
        service = new CitaService();
    }

    public boolean guardar(Cita cita) {
        return service.guardar(cita);
    }
    
    
    
    
public LocalDateTime
buscarPrimerHorarioDisponible(
        LocalDate fecha) {
    
    
    return service
            .buscarPrimerHorarioDisponible(
                    fecha);
}  
}