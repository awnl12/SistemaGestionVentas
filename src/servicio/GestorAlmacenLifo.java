package servicio;

import java.util.Scanner;
import java.util.Stack;
import modelo.Lote;


public class GestorAlmacenLifo {

    private Stack<Lote> estante;
    private String productoAlmacenado; 
    public GestorAlmacenLifo(String skuProducto) {
        this.estante = new Stack<>();
        this.productoAlmacenado = skuProducto;
        
        this.estante.push(new Lote(skuProducto, "Gaseosa 3L (Lote Antiguo)", 100, "10-Nov-2025"));
        System.out.println(" Creada Zona B (LIFO) para: " + skuProducto + ". (Precargado con 1 lote)");
    }

    /* -----------------------------------------------------------------
    // --- EL SUB-MENU DE PILAS ---
     -----------------------------------------------------------------*/
    public void menuPilas(Scanner sc) {
        boolean regresar = false;
        while (!regresar) {
            System.out.println("\n--- MENU DE GESTION DE ALMACEN (LIFO) ---");
            System.out.println("Gestionando: Estante de " + this.productoAlmacenado);
            System.out.println("1. Recibir Mercaderia (Push)");
            System.out.println("2. Despachar Mercaderia a Tienda (Pop)");
            System.out.println("3. Ver Tope del Estante (Peek)");
            System.out.println("4. Ver Estante Completo");
            System.out.println("5. Regresar al Menu Principal");
            System.out.print("Seleccione una opción: ");
            
     
            while (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un numero.");
                sc.next(); 
            }
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> recibirMercaderia(sc);
                case 2 -> despacharATienda(sc);
                case 3 -> verTope();
                case 4 -> verEstadoEstante();
                case 5 -> regresar = true;
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
    }
    
    // --- 1. ACCIÓN PUSH ---
    public void recibirMercaderia(Scanner sc) {
        System.out.println("\n RECIBIENDO NUEVO LOTE...");
        System.out.print("Ingrese nombre del producto (ej: Gaseosa 3L Lote Tarde): ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese cantidad recibida: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese fecha de recepcion (ej: 11-Nov-2025): ");
        String fecha = sc.nextLine();

        Lote loteNuevo = new Lote(this.productoAlmacenado, nombre, cantidad, fecha);
        
        /* La acción LIFO de "meter" */
        this.estante.push(loteNuevo); 
        
        System.out.println("===> LOTE APILADO. El estante ahora tiene " + this.estante.size() + " lotes.");
        verEstadoEstante();
    }

    // --- 2. ACCION POP/PEEK ---
    public void despacharATienda(Scanner sc) {
        if (this.estante.isEmpty()) {
            System.out.println(" El estante esta vacio. No se puede despachar.");
            return;
        }

        System.out.print("\n SOLICITUD: Ingrese cantidad a despachar: ");
        int cantidadSolicitada = sc.nextInt();
        sc.nextLine();

        System.out.println("Procesando solicitud de " + cantidadSolicitada + " unidades...");
        int cantidadFaltante = cantidadSolicitada;

        while (cantidadFaltante > 0 && !this.estante.isEmpty()) {
            
            // 1. Mira el lote de ENCIMA (Last-In)
            Lote loteActual = this.estante.peek();

            System.out.println("-> Tomando del ÚLTIMO lote (LIFO): " + loteActual);

            if (loteActual.getCantidad() > cantidadFaltante) {
                // El lote de encima tiene MAS de lo que necesitamos.
                System.out.println("   ...se sacan " + cantidadFaltante + " unidades de este lote.");
                loteActual.reducirCantidad(cantidadFaltante); // Reducimos su cantidad
                cantidadFaltante = 0; // Pedido completo

            } else {
                // El lote de encima tiene MENOS o EXACTAMENTE lo que necesitamos.
             
                System.out.println("   ...se sacan " + loteActual.getCantidad() + " unidades (lote completo).");
                cantidadFaltante -= loteActual.getCantidad();
                
                // 2. Sacamos el lote de la pila (porque se agoto)
                Lote loteAgotado = this.estante.pop(); // pop() saca el elemento
                System.out.println("   ...LOTE AGOTADO (del " + loteAgotado.getFechaRecepcion() + ").");
            }
        }

        if (cantidadFaltante > 0) {
            System.out.println(" ADVERTENCIA: No hay stock suficiente. Faltaron " + cantidadFaltante + " unidades.");
        } else {
            System.out.println(" PEDIDO COMPLETO. Listo para enviar a tienda.");
        }
        
        verEstadoEstante();
    }

    // --- 3. ACCIÓN PEEK ---
    public void verTope() {
        if (this.estante.isEmpty()) {
            System.out.println(" El estante esta vacio.");
        } else {
            System.out.println("\n El lote en el TOPE (el proximo a salir) es:");
            System.out.println(this.estante.peek());
        }
    }
    
    // --- 4. VER PILA COMPLETA ---
    public void verEstadoEstante() {
        System.out.println("\n--- ESTADO ACTUAL DEL ESTANTE (Tope -> Fondo) ---");
        if(this.estante.isEmpty()) {
            System.out.println("[Vacío]");
        } else {
       
            for(int i = this.estante.size() - 1; i >= 0; i--) {
                System.out.println("  " + this.estante.get(i));
            }
        }
        System.out.println("----------------------------------------------");
    }
}