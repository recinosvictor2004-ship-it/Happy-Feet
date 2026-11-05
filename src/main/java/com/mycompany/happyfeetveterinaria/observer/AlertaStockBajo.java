package com.mycompany.happyfeetveterinaria.observer;

public class AlertaStockBajo
        implements ObservadorInventario {

    @Override
    public void actualizar(String mensaje) {

        System.out.println(
                "⚠ ALERTA DE INVENTARIO: "
                + mensaje);
    }
}