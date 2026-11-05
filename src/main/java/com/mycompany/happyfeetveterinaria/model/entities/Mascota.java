package com.mycompany.happyfeetveterinaria.model.entities;

import java.time.LocalDate;

public class Mascota {

    private int id;
    private int duenoId;
    private int razaId;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String sexo;
    private double pesoActual;
    private String microchip;
    private String tatuaje;
    private String urlFoto;
    private String alergias;
    private String condicionesPreexistentes;
    private boolean activo;

    public Mascota() {
    }

    public Mascota(int id, int duenoId, int razaId, String nombre,
            LocalDate fechaNacimiento, String sexo,
            double pesoActual, String microchip,
            String tatuaje, String urlFoto,
            String alergias, String condicionesPreexistentes,
            boolean activo) {

        this.id = id;
        this.duenoId = duenoId;
        this.razaId = razaId;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.pesoActual = pesoActual;
        this.microchip = microchip;
        this.tatuaje = tatuaje;
        this.urlFoto = urlFoto;
        this.alergias = alergias;
        this.condicionesPreexistentes = condicionesPreexistentes;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(int duenoId) {
        this.duenoId = duenoId;
    }

    public int getRazaId() {
        return razaId;
    }

    public void setRazaId(int razaId) {
        this.razaId = razaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getTatuaje() {
        return tatuaje;
    }

    public void setTatuaje(String tatuaje) {
        this.tatuaje = tatuaje;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCondicionesPreexistentes() {
        return condicionesPreexistentes;
    }

    public void setCondicionesPreexistentes(String condicionesPreexistentes) {
        this.condicionesPreexistentes = condicionesPreexistentes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}