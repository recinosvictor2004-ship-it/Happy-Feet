package com.mycompany.happyfeetveterinaria.strategy;

public class FacturacionNormal
        implements EstrategiaDescuento {

    @Override
    public double calcularTotal(double subtotal) {

        return subtotal;
    }
}