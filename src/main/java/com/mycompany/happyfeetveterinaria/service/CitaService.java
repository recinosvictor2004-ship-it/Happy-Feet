package com.mycompany.happyfeetveterinaria.service;

import com.mycompany.happyfeetveterinaria.model.entities.Cita;
import com.mycompany.happyfeetveterinaria.repository.CitaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


public class CitaService {

    private final CitaRepository repository;

    public CitaService() {
        repository = new CitaRepository();
    }

    public boolean guardar(Cita cita) {
        return repository.guardar(cita);
    }
    
    
    
    
    
    
    
    public LocalDateTime buscarPrimerHorarioDisponible(
        LocalDate fecha) {
    List<Cita> citas =
            repository.obtenerCitasPorFecha(
                    fecha);
    LocalTime horaInicio =
            LocalTime.of(9, 0);
    LocalTime horaFin =
            LocalTime.of(17, 0);
    while (horaInicio.isBefore(horaFin)) {
        LocalDateTime posibleHorario =
                LocalDateTime.of(
                        fecha,
                        horaInicio);
        boolean ocupado = false;
        for (Cita cita : citas) {
            if (cita.getFechaHora()
                    .equals(posibleHorario)) {
                ocupado = true;
                break;
            }
        }
        if (!ocupado) {
            return posibleHorario;
        }
        horaInicio =
                horaInicio.plusMinutes(30);
    }
    return null;
}
}