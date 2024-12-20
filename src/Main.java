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

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CajeroAutomatico cajero = new CajeroAutomatico();

        CuentaAhorros cuenta1 = new CuentaAhorros("12345", "Alice", 1000, "1234");
        CuentaCorriente cuenta2 = new CuentaCorriente("67890", "Bob", 500, "5678", 500);

        cajero.agregarCuenta(cuenta1);
        cajero.agregarCuenta(cuenta2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Cajero Automático");
        System.out.print("Ingrese su número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        System.out.print("Ingrese su NIP: ");
        String nip = scanner.nextLine();

        Cuenta cuenta = cajero.autenticarCuenta(numeroCuenta, nip);

        if (cuenta != null) {
            cajero.mostrarMenu(cuenta);
        }

        scanner.close();
    }
}
