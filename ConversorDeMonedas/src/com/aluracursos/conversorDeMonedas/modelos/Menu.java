package com.aluracursos.conversorDeMonedas.modelos;

public class Menu {
    // Definición de variables para el contenido del menú

    // Submenú que contiene las instrucciones y opciones de conversión
    private String subMenu = """
            =================================================================
                            <     Conversor de Moneda    >
            =================================================================
            
                        Bienvenidos a la interfáz de conversión de monedas
            Instrucciones:
            
            A. Elegir una opción para convertir (1 a 8)
            B. Ingresar un valor a convertir
            C. Para salir del sistema presiona cero (0)
            D. Historial de conversiones (9)
            
            ************************************************************************
            
            1   -   Dólar [$USD]            ====>   peso argentino [$ARS]
            
            2   -   Peso argentino [$ARS]   ====>   Dólar [$USD]
            
            3   -   Dólar [$USD]            ====>   Real brasileño [$BRL]
            
            4   -   Real brasileño [$BRL]   ====>   Dólar [$USD]
            
            5   -   Dólar [$USD]            ====>   Peso colombiano [$COP]
            
            6   -   Peso colombiano [$COP]  ====>   Dólar [$USD]
            
            7   -   Dólar  [$USD]           ====>   Euro [€ EUR]
            
            8   -   Euro [€ EUR]            ====>   Dólar  [$USD] 
            
            ==========================================================================
            """;

    // Mensaje de salida al usuario cuando decide salir del sistema
    private String salida = """
            ==========================================================================
            =======================   ¡Hasta la próxima!  ============================
            ==========================================================================
            """;

    // Método para mostrar el menú y pedir una opción al usuario
    public void usarMenu() {
        System.out.println(subMenu);
        System.out.println("Escoja una opción \uD83D\uDCB1: ");
    }

    // Getters y Setters para las variables involucradas

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
}
