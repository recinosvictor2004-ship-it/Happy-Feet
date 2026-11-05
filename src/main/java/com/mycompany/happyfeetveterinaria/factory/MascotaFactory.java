package com.mycompany.happyfeetveterinaria.factory;

import com.mycompany.happyfeetveterinaria.model.entities.Mascota;

public class MascotaFactory {

    private MascotaFactory() {
    }

    public static Mascota crearMascota() {

        Mascota mascota = new Mascota();

        mascota.setPesoActual(0.0);
        mascota.setAlergias("Ninguna");
        mascota.setCondicionesPreexistentes("Ninguna");

        return mascota;
    }
}