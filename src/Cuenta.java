/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
import java.util.HashMap;
import java.util.Scanner;

abstract class Cuenta {
private String numeroCuenta;
    private String titular;
    protected double saldo;
    private String nip;

    public Cuenta(String numeroCuenta, String titular, double saldo, String nip) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.nip = nip;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public boolean validarNIP(String nipIngresado) {
        return this.nip.equals(nipIngresado);
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("El monto debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Monto inválido o saldo insuficiente.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo);
    }

    public void pagarServicio(String servicio, double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Pago de " + servicio + " realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Monto inválido o saldo insuficiente para pagar " + servicio + ".");
        }
    }
}
