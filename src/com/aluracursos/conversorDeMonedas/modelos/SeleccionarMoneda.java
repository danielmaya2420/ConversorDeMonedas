package com.aluracursos.conversorDeMonedas.modelos;

import com.aluracursos.conversorDeMonedas.modelos.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SeleccionarMoneda {
    // Creación de instancias de Scanner, CalcularMoneda, Menu y HistorialDeMonedas
    private final Scanner scanner = new Scanner(System.in);
    private final CalcularMoneda calcularMoneda = new CalcularMoneda();
    private final Menu menu = new Menu();
    private final HistorialDeMonedas historial = new HistorialDeMonedas();

    // Método principal para manejar la selección de opciones del menú
    public void seleccionar() {
        int opcion = 0;
        // Muestra el menú al usuario
        menu.usarMenu();

        do {
            try {
                // Captura la opción ingresada por el usuario
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Maneja errores de entrada no válida
                System.out.println("Error: Por favor, ingresa un número válido.");
                scanner.next();
                continue;
            }

            // Procesa la opción seleccionada por el usuario
            switch (opcion) {
                case 0:
                    // Opción para salir del sistema
                    Menu salida = new Menu();
                    System.out.println(salida.getSalida());
                    break;
                case 1:
                    // Conversión de Dólar a Peso argentino
                    convertirMoneda("USD", "Dólar", "ARS", "Peso argentino");
                    break;
                case 2:
                    // Conversión de Peso argentino a Dólar
                    convertirMoneda("ARS", "Peso argentino", "USD", "Dólar");
                    break;
                case 3:
                    // Conversión de Dólar a Real brasileño
                    convertirMoneda("USD", "Dólar", "BRL", "Real brasileño");
                    break;
                case 4:
                    // Conversión de Real brasileño a Dólar
                    convertirMoneda("BRL", "Real brasileño", "USD", "Dólar");
                    break;
                case 5:
                    // Conversión de Dólar a Peso colombiano
                    convertirMoneda("USD", "Dólar", "COP", "Peso colombiano");
                    break;
                case 6:
                    // Conversión de Peso colombiano a Dólar
                    convertirMoneda("COP", "Peso colombiano", "USD", "Dólar");
                    break;
                case 7:
                    // Conversión de Dólar a Euro
                    convertirMoneda("USD", "Dólar", "EUR", "Euro");
                    break;
                case 8:
                    // Conversión de Euro a Dólar
                    convertirMoneda("EUR", "Euro", "USD", "Dólar");
                    break;
                case 9:
                    // Mostrar historial de conversiones
                    mostrarHistorial();
                    break;
                default:
                    // Maneja la entrada de opciones no válidas
                    System.out.println("Por favor, ingresa una opción válida");
            }
        } while (opcion != 0); // Repite hasta que la opción sea 0 (salir)
        scanner.close(); // Cierra el Scanner al terminar
    }

    // Método para manejar la conversión de monedas y agregar la conversión al historial
    private void convertirMoneda(String monedaBase,
                                 String nombreMonedaBase,
                                 String monedaAConvertir,
                                 String nombreDeMonedaAConvertir) {
        // Realiza la conversión de moneda
        double valorConvertido = calcularMoneda.calcularMoneda(monedaBase, nombreMonedaBase, monedaAConvertir, nombreDeMonedaAConvertir);

        // Formatea la conversión y agrega al historial
        String conversion = "Valor convertido de " + nombreMonedaBase + " a " + nombreDeMonedaAConvertir + ": " + valorConvertido + " " + monedaBase + " -----> " + monedaAConvertir;
        historial.agregarConversion(conversion);
    }

    // Método para mostrar el historial de conversiones
    private void mostrarHistorial() {
        historial.mostrarHistorial();
    }
}









