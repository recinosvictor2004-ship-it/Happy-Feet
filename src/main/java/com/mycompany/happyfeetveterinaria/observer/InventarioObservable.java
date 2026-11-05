package com.mycompany.happyfeetveterinaria.observer;

import java.util.ArrayList;
import java.util.List;

public class InventarioObservable {

    private final List<ObservadorInventario>
            observadores = new ArrayList<>();

    public void agregarObservador(
            ObservadorInventario observador) {

        observadores.add(observador);
    }

    public void notificarObservadores(
            String mensaje) {

        for (ObservadorInventario observador
                : observadores) {

            observador.actualizar(mensaje);
        }
    }

    public void verificarStock(
            String producto,
            int cantidad,
            int minimo) {

        if (cantidad <= minimo) {

            notificarObservadores(
                    "El producto "
                    + producto
                    + " está por debajo del stock mínimo. "
                    + "Stock actual: "
                    + cantidad);
        }
    }
}