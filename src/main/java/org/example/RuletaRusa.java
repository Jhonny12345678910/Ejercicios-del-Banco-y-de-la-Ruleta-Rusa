package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
    private List<Integer> tambor;
    private int bala;
    private int posicionActual;
    private Random random;

    // Constructor
    public RuletaRusa() {
        random = new Random();
        tambor = new ArrayList<>();

        // Inicializa el tambor con posiciones 0-5
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }

        // Asigna aleatoriamente la posición de la bala
        bala = random.nextInt(6);
        posicionActual = 0; // Se inicia en la primera posición
    }

    // Método disparar()
    public boolean disparar() {
        System.out.println("\nDisparando en la posición: " + posicionActual);

        if (posicionActual == bala) {
            System.out.println("¡La bala fue disparada! Perdiste.");
            return true;
        } else {
            System.out.println(" Sobreviviste esta vez...");
            avanzarTambor();
            return false;
        }
    }

    // Método para avanzar el tambor
    private void avanzarTambor() {
        posicionActual = (posicionActual + 1) % tambor.size(); // Avanza en forma circular
    }

    // Método reiniciarJuego()
    public void reiniciarJuego() {
        bala = random.nextInt(6); // Nueva posición de la bala
        posicionActual = 0; // Reinicia la posición del tambor
        System.out.println("\n ¡Juego reiniciado!");
    }
}

