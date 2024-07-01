# ConversorDeMonedas

El código implementa un sistema de conversión de monedas en Java. El sistema permite al usuario convertir valores entre diferentes monedas y mantiene un historial de conversiones realizadas. Las principales funcionalidades del sistema incluyen:

# Menú Interactivo:
- Presenta un menú interactivo al usuario con opciones para convertir monedas, ver el historial de conversiones o salir del sistema.
Las opciones disponibles permiten convertir entre varias combinaciones de monedas como Dólar (USD), Peso argentino (ARS), Real brasileño (BRL), Peso colombiano (COP), y Euro (EUR).
Conversión de Monedas:
- Utiliza una API externa (exchangerate-api.com) para obtener las tasas de conversión actuales entre las monedas.
Permite al usuario ingresar un valor en una moneda base y convertirlo a otra moneda objetivo.

# Manejo de Errores:
- Maneja errores de entrada no válida mediante la captura de excepciones (InputMismatchException).
- Solicita al usuario que ingrese un número válido si se detecta una entrada no válida.
  
# Historial de Conversiones:
- Guarda el historial de conversiones realizadas, incluyendo la fecha y hora de cada conversión.
- Permite al usuario ver el historial de conversiones realizadas durante la sesión actual.
