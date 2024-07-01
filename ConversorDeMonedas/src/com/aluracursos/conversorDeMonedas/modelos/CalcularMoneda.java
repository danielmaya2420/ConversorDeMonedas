package com.aluracursos.conversorDeMonedas.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class CalcularMoneda {
    // Creación de un objeto Gson para formatear JSON de manera legible
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // Creación de un objeto Scanner para leer la entrada del usuario
    Scanner lectura = new Scanner(System.in);

    // Método para calcular la conversión de una moneda
    public double calcularMoneda(String busqueda,
                                 String nombreMonedaBase,
                                 String monedaAConvertir,
                                 String nombreDeMonedaAConvertir) {
        String valorIngresado;

        // Creación de un objeto para consultar la API de tasas de conversión de monedas
        ConsultaApi consulta = new ConsultaApi();
        // Conversión del resultado de la API a un objeto JSON
        String valor = gson.toJson(consulta.buscaMonedas(busqueda));
        JsonObject jsonObject = gson.fromJson(valor, JsonObject.class);

        // Obtención del código de la moneda base seleccionada por el usuario
        String monedaSeleccionada = jsonObject.get("base_code").getAsString();

        // Obtención de las tasas de conversión del objeto JSON
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        // Obtención de la tasa de conversión específica para la moneda deseada
        double valorDeMonedaAconvertir = conversionRates.get(monedaAConvertir).getAsDouble();

        // Solicitud al usuario para ingresar la cantidad de la moneda base a convertir
        System.out.println("Ingresa el valor de " + monedaSeleccionada + " a convertir: ");
        valorIngresado = lectura.nextLine();
        valorIngresado.replace(".", ",");
        // Conversión de la entrada del usuario a un valor double
        Double valorIngresadoToDouble = Double.parseDouble(valorIngresado);

        // Validación de que el valor ingresado sea mayor que 0
        if (valorIngresadoToDouble <= 0) {
            System.out.println("Por favor ingresar un cantidad mayor a 0");
            valorIngresadoToDouble = lectura.nextDouble();
        } else if (valorIngresadoToDouble >= 1) {
            // Cálculo de la conversión
            double valorconvertido = valorIngresadoToDouble * valorDeMonedaAconvertir;
            // Formateo del resultado a dos decimales
            String valorCalculadoFormatoDecimal = String.format("%.2f", valorconvertido);
            // Impresión del resultado de la conversión
            System.out.println(valorIngresadoToDouble + " "
                    + nombreMonedaBase + " " + "====>" + " "
                    + valorCalculadoFormatoDecimal + " "
                    + nombreDeMonedaAConvertir);

            // Mensajes para el usuario sobre cómo continuar o salir
            System.out.println("\n*===============================================================");
            System.out.println("Presiona cero (0) para salir.");
            System.out.println("Presiona [1-8] para continuar con otra conversión.");
            System.out.println("===================================================================");

            return valorconvertido;
        }

        return 0.0; // En caso de que no haya conversión;
    }
}


