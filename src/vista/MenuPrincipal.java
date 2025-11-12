package vista;

import java.util.Scanner;
import servicio.GestorProductos;
import servicio.GestorAlmacenLifo;

public class MenuPrincipal {
    

    
    private final GestorProductos gestor = new GestorProductos(50); 
    
  

    private final String[] integrantes = {
        "Luis Gabriel Reyes Saravia",
        "Jorge Martin Marroquin Rodriguez",
        "Jesus David Rojas Levano",
        "Frank Matheus Morales Bermudez Lopez",
        "Ednilson Jesus Pinto Valentin"
    };

 
    public void mostrarMenu(Scanner sc) {
        boolean salir = false;

        while (!salir) {
            System.out.println("-------------------------------------");
            System.out.println("    SISTEMA DE GESTION DE VENTAS - TAMBO");
            System.out.println("--------------------------------------");
            System.out.println("Integrantes del grupo:");
            for (String nombre : integrantes) {
                System.out.println("- " + nombre);
            }

            gestor.menuProductos(sc);
            
        
            salir = true; 
        }
        

    }
}