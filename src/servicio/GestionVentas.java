package servicio;

import modelo.Producto;
import java.util.Scanner;

/*
    Clase: GestionVentas
    Ubicación: package servicio/
    Función:
        bueno aqui usamos el crud pero a base de puro arreglo , ya que no quieren con array , etc
        que es el CRUD es esto que esta abajo :
            - Insertar producto
            - Eliminar producto
            - Actualizar cantidad
            - Mostrar productos
            - Calcular total de ventas
*/

public class GestionVentas {

    private Scanner sc = new Scanner(System.in);
    private Producto[] productos = new Producto[100];  // Arreglo  productos
    private int contador = 0;                          // Control de cantidad XD  , (cantidad de prosuctos)

    // Insertar producto nuevo
    public void insertarProducto() {
        if (contador >= productos.length) {
            System.out.println("Límite alcanzado. No se pueden agregar más productos.");
            return;
        }

        System.out.print("Ingrese código del producto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        // Verificar si el código ya existe
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                System.out.println("El código ya existe. No se puede duplicar.");
                return;
            }
        }

        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese precio unitario: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese cantidad comprada: ");
        int cantidad = sc.nextInt();

        productos[contador] = new Producto(codigo, nombre, precio, cantidad);
        contador++;
        System.out.println("Producto agregado correctamente.");
    }

    // Eliminar producto por código
    public void eliminarProducto() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigo = sc.nextInt();

        int pos = buscarProducto(codigo);
        if (pos == -1) {
            System.out.println("Producto no encontrado.");
            return;
        }

        // Desplazar los elementos a la izquierda
        for (int i = pos; i < contador - 1; i++) {
            productos[i] = productos[i + 1];
        }
        productos[contador - 1] = null;
        contador--;
        System.out.println("Producto eliminado correctamente.");
    }

    // Actualizar cantidad comprada
    public void actualizarCantidad() {
        System.out.print("Ingrese el código del producto a actualizar: ");
        int codigo = sc.nextInt();

        int pos = buscarProducto(codigo);
        if (pos == -1) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese nueva cantidad comprada: ");
        int nuevaCantidad = sc.nextInt();
        productos[pos].cantidadComprada = nuevaCantidad;
        System.out.println("Cantidad actualizada correctamente.");
    }

    // Mostrar todos los productos registrados
    public void mostrarProductos() {
        if (contador == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\nListado de productos comprados:");
        System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "CODIGO", "NOMBRE", "PRECIO", "CANTIDAD", "IMPORTE");
        for (int i = 0; i < contador; i++) {
            productos[i].mostrar();
        }
    }

    // Calcular total de ventas
    public void calcularTotalVentas() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getImporte();
        }
        System.out.printf("El total de ventas es: S/ %.2f\n", total);
    }

    // Método auxiliar para buscar un producto por código
    private int buscarProducto(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].codigo == codigo) {
                return i;
            }
        }
        return -1;
    }
}
