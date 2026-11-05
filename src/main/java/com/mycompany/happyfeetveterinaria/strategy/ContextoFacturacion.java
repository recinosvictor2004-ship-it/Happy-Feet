package com.mycompany.happyfeetveterinaria.strategy;

public class ContextoFacturacion {

    private EstrategiaDescuento estrategia;

    public ContextoFacturacion(
            EstrategiaDescuento estrategia) {

        this.estrategia = estrategia;
    }

    public double calcular(double subtotal) {

        return estrategia.calcularTotal(subtotal);
    }
}