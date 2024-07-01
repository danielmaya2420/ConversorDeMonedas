package com.aluracursos.conversorDeMonedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


    //Generación de dirección para uso de API
    // "https://v6.exchangerate-api.com/v6/d18132b33f1d2d97e09fbd4c/latest/USD"

public class ConsultaApi {

    // Método que busca las tasas de cambio de monedas a través de una API
    public Monedas buscaMonedas(String busqueda) {
        // Clave de la API para acceder al servicio de tasas de cambio
        String APIKEY = "1802ee90ca46adaa408d9d1e";
        // URL de la API con la clave y el parámetro de búsqueda para la moneda base
        String URL = "https://v6.exchangerate-api.com/v6/" + APIKEY + "/latest/" + busqueda;

        // Creación de un cliente HTTP para enviar solicitudes
        HttpClient client = HttpClient.newHttpClient();
        // Construcción de una solicitud HTTP con la URL de la API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        // Declaración de la variable para la respuesta HTTP
        HttpResponse<String> response = null;
        try {
            // Envío de la solicitud y obtención de la respuesta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Conversión del cuerpo de la respuesta JSON a un objeto Monedas
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (IOException | InterruptedException e) {
            // Manejo de excepciones en caso de error en la solicitud
            throw new RuntimeException("Moneda no encontrada, por favor ingresa otra opción.");
        }
    }
}

