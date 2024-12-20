/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebas
 */
public class CuentaCorriente extends Cuenta{
    private double limiteDescubierto;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, String nip, double limiteDescubierto) {
        super(numeroCuenta, titular, saldo, nip);
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo + limiteDescubierto) {
            saldo -= monto;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Monto inválido o límite de descubierto excedido.");
        }
    }
}
