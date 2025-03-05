package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCuentaBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear nueva cuenta");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Mostrar saldo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Ingrese el nombre del titular: ");
                    String titular = scanner.nextLine();
                    cuentas.add(new CuentaBancaria(numeroCuenta, titular));
                    System.out.println("Cuenta creada exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese número de cuenta: ");
                    numeroCuenta = scanner.nextLine();
                    CuentaBancaria cuentaDeposito = buscarCuenta(cuentas, numeroCuenta);
                    if (cuentaDeposito != null) {
                        System.out.print("Ingrese cantidad a depositar: ");
                        double cantidad = scanner.nextDouble();
                        cuentaDeposito.depositar(cantidad);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese número de cuenta: ");
                    numeroCuenta = scanner.nextLine();
                    CuentaBancaria cuentaRetiro = buscarCuenta(cuentas, numeroCuenta);
                    if (cuentaRetiro != null) {
                        System.out.print("Ingrese cantidad a retirar: ");
                        double cantidad = scanner.nextDouble();
                        cuentaRetiro.retirar(cantidad);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese número de cuenta: ");
                    numeroCuenta = scanner.nextLine();
                    CuentaBancaria cuentaSaldo = buscarCuenta(cuentas, numeroCuenta);
                    if (cuentaSaldo != null) {
                        cuentaSaldo.mostrarSaldo();
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static CuentaBancaria buscarCuenta(ArrayList<CuentaBancaria> cuentas, String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}
