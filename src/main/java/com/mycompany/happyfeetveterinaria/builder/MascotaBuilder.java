package com.mycompany.happyfeetveterinaria.builder;

import com.mycompany.happyfeetveterinaria.model.entities.Mascota;

import java.time.LocalDate;

public class MascotaBuilder {

    private final Mascota mascota;

    public MascotaBuilder() {
        mascota = new Mascota();
    }

    public MascotaBuilder duenoId(int duenoId) {
        mascota.setDuenoId(duenoId);
        return this;
    }

    public MascotaBuilder razaId(int razaId) {
        mascota.setRazaId(razaId);
        return this;
    }

    public MascotaBuilder nombre(String nombre) {
        mascota.setNombre(nombre);
        return this;
    }

    public MascotaBuilder fechaNacimiento(LocalDate fechaNacimiento) {
        mascota.setFechaNacimiento(fechaNacimiento);
        return this;
    }

    public MascotaBuilder sexo(String sexo) {
        mascota.setSexo(sexo);
        return this;
    }

    public MascotaBuilder pesoActual(double peso) {
        mascota.setPesoActual(peso);
        return this;
    }

    public MascotaBuilder microchip(String microchip) {
        mascota.setMicrochip(microchip);
        return this;
    }

    public MascotaBuilder tatuaje(String tatuaje) {
        mascota.setTatuaje(tatuaje);
        return this;
    }

    public MascotaBuilder urlFoto(String urlFoto) {
        mascota.setUrlFoto(urlFoto);
        return this;
    }

    public MascotaBuilder alergias(String alergias) {
        mascota.setAlergias(alergias);
        return this;
    }

    public MascotaBuilder condiciones(String condiciones) {
        mascota.setCondicionesPreexistentes(condiciones);
        return this;
    }

    public Mascota build() {
        return mascota;
    }
}