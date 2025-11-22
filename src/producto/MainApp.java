package producto;

import java.util.Scanner;
import vista.MenuPrincipal;
import servicio.GestorAlmacenLifo;
import servicio.GestorCombos;

public class MainApp {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in); 
       
        MenuPrincipal menuVista = new MenuPrincipal();
        GestorAlmacenLifo gestorPilas = new GestorAlmacenLifo("SKU-PRO-001");
        GestorCombos listaEnlazada = new GestorCombos();

        boolean salir = false;
        String[] integrantes = {
            "Luis Gabriel Reyes Saravia", 
            "Jorge Martin Marroquin Rodriguez", 
            "Jesus David Rojas Levano",
            "Frank Matheus Morales Bermudez Lopez",
            "Ednilson Jesus Pinto Valentin"
        };

        while (!salir) {
            System.out.println("-------------------------------------");
            System.out.println("    SISTEMA DE GESTION DE VENTAS");
            System.out.println("--------------------------------------");
            System.out.println("Integrantes del grupo:");
            for (String nombre : integrantes) {
                System.out.println("- " + nombre);
            }
            System.out.println("\nMenu principal:");
            System.out.println("1. Arreglo de objetos (CRUD Productos)");
            System.out.println("2. Lista enlazada (Combos)");
            System.out.println("3. Pilas (Almacén LIFO)"); 
            System.out.println("4. Colas");
            System.out.println("5. Arboles");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = -1;

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); 
            } else {
                System.out.println("Error: Debe ingresar un número.");
                sc.next(); 
                continue; 
            }

            switch (opcion) {
                
                case 1 -> menuVista.mostrarMenu(sc); 
                
                case 2 -> listaEnlazada.menuCombos(sc);
                
                case 3 -> gestorPilas.menuPilas(sc);
                
                case 4 -> System.out.println("Elegiste... Colas (por implementar)");
                case 5 -> System.out.println("Elegiste... Arboles (por implementar)");
                case 6 -> {
                    salir = true;
                    System.out.println("SALIENDO DEL MENU...");
                }
                default -> System.out.println("Opcion incorrecta, intentalo de nuevo por favor.");
            }
            System.out.println();
        }
        
       
        sc.close();
        System.out.println("Programa finalizado.");
    }
}