package vista;

import servicio.GestionVentas;
import java.util.Scanner;

/*
    Clase: TamboVentasApp
    Ubicación: package vista/
    Función:
        el es menu tipo voucher pero que usa el CRUD 
*/

public class TamboVentasApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionVentas gestion = new GestionVentas();

        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE VENTAS - TAMBO =====");
            System.out.println("1. Insertar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Actualizar cantidad comprada");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Calcular total de ventas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> gestion.insertarProducto();
                case 2 -> gestion.eliminarProducto();
                case 3 -> gestion.actualizarCantidad();
                case 4 -> gestion.mostrarProductos();
                case 5 -> gestion.calcularTotalVentas();
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }

        } while (opcion != 6);
    }
}
