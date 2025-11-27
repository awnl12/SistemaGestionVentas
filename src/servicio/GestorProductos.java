package servicio;

import java.util.Scanner;
import modelo.Producto;

// Clase encargada de gestionar los productos (CRUD con arreglos).
// Se usa en el menú principal para registrar, mostrar, eliminar o actualizar productos.
public class GestorProductos {
    private Producto[] productos;
    private int contador;

    public GestorProductos(int tamano) {
        productos = new Producto[tamano];
        contador = 0;
    }

    // Registrar un nuevo producto
    public void insertarProducto(Scanner sc) {
        if (contador >= productos.length) {
            System.out.println("No se pueden agregar más productos (arreglo lleno).");
            return;
        }
        System.out.print("Ingrese código del producto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese precio unitario: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese cantidad comprada: ");
        int cantidad = sc.nextInt();

        productos[contador] = new Producto(codigo, nombre, precio, cantidad);
        contador++;
        System.out.println("✅ Producto agregado correctamente.");
    }

    // Mostrar todos los productos registrados
    public void mostrarProductos() {
        if (contador == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(productos[i]);
        }
    }

    // Eliminar un producto por su código
    public void eliminarProducto(Scanner sc) {
        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigo = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo() == codigo) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[contador - 1] = null;
                contador--;
                encontrado = true;
                System.out.println(" Producto eliminado correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println(" Producto no encontrado.");
        }
    }

    // Actualizar cantidad de un producto
    public void actualizarCantidad(Scanner sc) {
        System.out.print("Ingrese el código del producto a actualizar: ");
        int codigo = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo() == codigo) {
                System.out.print("Ingrese nueva cantidad comprada: ");
                int nuevaCantidad = sc.nextInt();
                productos[i].setCantidadComprada(nuevaCantidad);
                System.out.println("===> Cantidad actualizada correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println(" X Producto no encontrado.");
        }
    }

    // Calcular total de ventas
    public void totalVentas() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getImporte();
        }
        System.out.println(" ==> Total de ventas: S/." + total);
    }

    // Submenú de productos
    public void menuProductos(Scanner sc) {
        boolean regresar = false;

        while (!regresar) {
            System.out.println("\n--- MENÚ DE ARREGLO DE OBJETOS (PRODUCTOS) ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Actualizar cantidad comprada");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Calcular total de ventas");
            System.out.println("6. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> insertarProducto(sc);
                case 2 -> mostrarProductos();
                case 3 -> actualizarCantidad(sc);
                case 4 -> eliminarProducto(sc);
                case 5 -> totalVentas();
                case 6 -> regresar = true;
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }
}
