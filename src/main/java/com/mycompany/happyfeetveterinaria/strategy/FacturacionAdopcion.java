package com.mycompany.happyfeetveterinaria.strategy;

public class FacturacionAdopcion
        implements EstrategiaDescuento {

    @Override
    public double calcularTotal(double subtotal) {

        return subtotal * 0.85;
    }
}