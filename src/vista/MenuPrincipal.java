package vista;

import java.util.Scanner;
import servicio.GestorProductos;

// Clase que representa el menú principal de la aplicación.
// Desde aquí se accede a todas las secciones del sistema.
public class MenuPrincipal {
    private final Scanner sc = new Scanner(System.in);
    private final GestorProductos gestor = new GestorProductos(50); // arreglo de 50 productos

    private final String[] integrantes = {
        "Luis Gabriel Reyes Saravia",
        "Jorge Martin Marroquin Rodriguez",
        "Jesus David Rojas Levano",
        "Frank Matheus Morales Bermudez Lopez",
        "Ednilson Jesus Pinto Valentin"
    };

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("-------------------------------------");
            System.out.println("   SISTEMA DE GESTION DE VENTAS - TAMBO");
            System.out.println("--------------------------------------");
            System.out.println("Integrantes del grupo:");
            for (String nombre : integrantes) {
                System.out.println("- " + nombre);
            }

            System.out.println("\nMENÚ PRINCIPAL:");
            System.out.println("1. Arreglo de objetos (CRUD de productos)");
            System.out.println("2. Lista enlazada");
            System.out.println("3. Pilas");
            System.out.println("4. Colas");
            System.out.println("5. Árboles");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> gestor.menuProductos(sc);
                case 2 -> System.out.println("Elegiste... Lista enlazada (por implementar)");
                case 3 -> System.out.println("Elegiste... Pilas (por implementar)");
                case 4 -> System.out.println("Elegiste... Colas (por implementar)");
                case 5 -> System.out.println("Elegiste... Árboles (por implementar)");
                case 6 -> {
                    salir = true;
                    System.out.println("👋 Saliendo del sistema...");
                }
                default -> System.out.println("Opción incorrecta, intente nuevamente.");
            }
        }
    }
}
