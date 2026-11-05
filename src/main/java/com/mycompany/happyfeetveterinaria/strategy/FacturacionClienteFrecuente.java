package com.mycompany.happyfeetveterinaria.strategy;

public class FacturacionClienteFrecuente
        implements EstrategiaDescuento {

    @Override
    public double calcularTotal(double subtotal) {

        return subtotal * 0.90;
    }
}