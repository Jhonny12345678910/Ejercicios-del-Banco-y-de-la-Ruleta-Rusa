package org.example;

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private String titular;

    public CuentaBancaria(String numeroCuenta, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double cantidad) {
        if (cantidad<=0) {
            System.out.println("Invalido");
        } else {
            this.saldo += cantidad;
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad>saldo) {
            System.out.println("Invalido");
        } else if (cantidad<=0) {
            System.out.println("Invalido");
        } else {
            this.saldo -= cantidad;
        }
        return false;
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual: " + saldo);
        System.out.println("Titular: " + titular);
    }
}
