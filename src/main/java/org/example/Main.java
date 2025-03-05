package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RuletaRusa juego = new RuletaRusa();
        List<String> jugadores = new ArrayList<>();
        Random random = new Random();

        System.out.println(" ¡Bienvenido a la Ruleta Rusa!");

        // Solicitar número de jugadores
        System.out.print("Ingrese la cantidad de jugadores: ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Solicitar nombres de los jugadores
        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            jugadores.add(scanner.nextLine());
        }

        // Elegir aleatoriamente al jugador que comienza
        int turno = random.nextInt(numJugadores);
        System.out.println("\n Se ha elegido aleatoriamente a " + jugadores.get(turno) + " para comenzar el juego.");

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            String jugadorActual = jugadores.get(turno);
            System.out.println("\n Turno de " + jugadorActual);
            System.out.println("1. Disparar");
            System.out.println("2. Salir del juego");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                juegoTerminado = juego.disparar();
                if (juegoTerminado) {
                    System.out.println("Lo siento " + jugadorActual + " ha perdido el juego.");
                } else {
                    System.out.println("Felicidades " + jugadorActual + " ha sobrevivido.");
                    turno = (turno + 1) % numJugadores; // Pasar al siguiente jugador
                }
            } else if (opcion == 2) {
                System.out.println("Felicidades " + jugadorActual + " ha abandonado el juego.");
                jugadores.remove(turno);
                numJugadores--;

                if (numJugadores == 1) {
                    System.out.println("Ganador " + jugadores.get(0) + " es el ganador por ser el último en pie.");
                    juegoTerminado = true;
                }
            } else {
                System.out.println(" Opción inválida. Intenta de nuevo.");
            }
        }

        System.out.println(" ¡Juego terminado!");
        scanner.close();
    }
}


