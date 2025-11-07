
package producto;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String[] integrantes = {"Luis Gabriel Reyes Saravia", "Jorge Martin Marroquin Rodriguez ", "Jesus David Rojas Levano","Frank Matheus Morales Bermudez Lopez","Ednilson Jesus Pinto Valentin",};

        while (!salir) {
            System.out.println("-------------------------------------");
            System.out.println("   SISTEMA DE GESTION DE VENTAS");
            System.out.println("--------------------------------------");
            System.out.println("Integrantes del grupo:");
            for (String nombre : integrantes) {
                System.out.println("- " + nombre);
            }
            System.out.println("\nMenu principal:");
            System.out.println("1. Arreglo de objetos");
            System.out.println("2. Lista enlazada");
            System.out.println("3. Pilas");
            System.out.println("4. Colas");
            System.out.println("5. Arboles");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Elegiste... Arreglo de objetos");
                    break;
                case 2:
                    System.out.println("Elegiste... Lista enlazada");
                    break;
                case 3:
                    System.out.println("Elegiste... Pilas");
                    break;
                case 4:
                    System.out.println("Elegiste... Colas");
                    break;
                case 5:
                    System.out.println("Elegiste... Arboles");
                    break;
                case 6:
                    salir = true;
                    System.out.println("SALIENDO DEL MENU...");
                    break;
                default:
                    System.out.println("Opción incorrecta, intentalo de nuevo por favor.");
            }
            System.out.println();
        }
        sc.close();
    }
}
