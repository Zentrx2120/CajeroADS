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

public class CajeroAutomatico {
    private HashMap<String, Cuenta> cuentas = new HashMap<>();

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

    public Cuenta autenticarCuenta(String numeroCuenta, String nipIngresado) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarNIP(nipIngresado)) {
            return cuenta;
        } else {
            System.out.println("Cuenta no encontrada o NIP incorrecto.");
            return null;
        }
    }

    public void mostrarMenu(Cuenta cuenta) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Cajero Automático ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Pagar servicios (agua, gas, luz, tarjeta de crédito)");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    cuenta.depositar(montoDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    cuenta.retirar(montoRetiro);
                    break;
                case 4:
                    System.out.println("Servicios disponibles: agua, gas, luz, tarjeta de crédito");
                    System.out.print("Ingrese el servicio a pagar: ");
                    scanner.nextLine(); // Limpiar buffer
                    String servicio = scanner.nextLine();
                    System.out.print("Ingrese el monto a pagar: ");
                    double montoServicio = scanner.nextDouble();
                    cuenta.pagarServicio(servicio, montoServicio);
                    break;
                case 0:
                    System.out.println("Gracias por usar el cajero automático.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
