package com.aluracursos.conversorDeMonedas.modelos;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialDeMonedas {

    // Listas para almacenar las conversiones y los registros de fecha y hora
    private List<String> conversiones;
    private List<LocalDateTime> registros;
    private DateTimeFormatter formato;

    // Constructor para inicializar las listas y el formateador de fecha y hora
    public HistorialDeMonedas() {
        this.conversiones = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }

    // Método para agregar una nueva conversión al historial
    public void agregarConversion(String conversion) {
        // Obtener la fecha y hora actual
        LocalDateTime registro = LocalDateTime.now();
        // Agregar la conversión y el registro de fecha y hora a las listas
        this.conversiones.add(conversion);
        registros.add(registro);
    }

    // Método para mostrar el historial de conversiones
    public void mostrarHistorial() {
        System.out.println("Historial de conversiones:");
        // Recorrer la lista de conversiones y mostrar cada una con su registro de fecha y hora
        for (int i = 0; i < conversiones.size(); i++) {
            // Formatear la fecha y hora del registro
            String formatoFecha = registros.get(i).format(formato);
            // Imprimir el número de la conversión, la conversión y la fecha y hora del registro
            System.out.println((i + 1) + ". " + conversiones.get(i) + " - Registro: " + formatoFecha);
        }
    }
}

