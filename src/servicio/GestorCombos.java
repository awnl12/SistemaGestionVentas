package servicio;

import java.util.LinkedList;
import java.util.Scanner;
import modelo.Combo;
import modelo.Producto;

public class GestorCombos {
    
    private LinkedList<Combo> combos = new LinkedList<>();
    private LinkedList<Combo> seleccionados = new LinkedList<>();
    
    public GestorCombos() {
        cargarCombos();
    }
    
    private void cargarCombos() {
        Producto coca = new Producto(1, "Coca Cola 500ml", 3.50, 1);
        Producto inka = new Producto(2, "Inka Cola 500ml", 3.50, 1);
        Producto oreo = new Producto(3, "Galletas Oreo", 1.20, 1);
        Producto lays = new Producto(4, "Papas Lays", 2.00, 1);
        Producto sublime = new Producto(5, "Chocolate Sublime", 1.50, 1);
        Producto agua = new Producto(6, "Agua San Luis 600ml", 2.20, 1);
        Producto redbull = new Producto(7, "Red Bull", 6.00, 1);
        Producto platanitos = new Producto(8, "Platanitos Snack", 2.10, 1);
        Producto princesa = new Producto(9, "Galleta Princesa", 1.30, 1);
        Producto mentos = new Producto(10, "Mentos Menta", 1.00, 1);
        
        combos.add(new Combo("Combo 1 Energetico", redbull, sublime, 6.90));
        combos.add(new Combo("Combo 2 Refrescante", coca, oreo, 4.30));
        combos.add(new Combo("Combo 3 Familiar", inka, lays, 5.00));
        combos.add(new Combo("Combo 4 Dulzura", princesa, sublime, 2.60));
        combos.add(new Combo("Combo 5 Hidratacion", agua, mentos, 2.90));
        combos.add(new Combo("Combo 6 Power", redbull, oreo, 6.80));
        combos.add(new Combo("Combo 7 Salado", lays, platanitos, 3.90));
        combos.add(new Combo("Combo 8 Clasico", coca, sublime, 4.80));
        combos.add(new Combo("Combo 9 Gomisnack", mentos, platanitos, 2.10));
        combos.add(new Combo("Combo 10 Full Snack", platanitos, princesa, 3.20));
    }
    
    public void menuCombos(Scanner sc) {
        int opcion;
        do {
            System.out.println("\n-------------------------------------");
            System.out.println("             MENU COMBOS");
            System.out.println("-------------------------------------");
            System.out.println("1. Seleccionar combos");
            System.out.println("2. Actualizar cantidad de combos");
            System.out.println("3. Eliminar combos");
            System.out.println("4. Mostrar combos seleccionados");
            System.out.println("5. Comprar combos");
            System.out.println("6. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1: seleccionarCombo(sc);
                    break;
                case 2: actualizarCantidad(sc);
                    break;
                case 3: eliminarCombo(sc);
                    break;
                case 4: mostrarSeleccionados();
                    break;
                case 5: comprar();
                    break;
            }

        } while (opcion != 6);
    }

    private void seleccionarCombo(Scanner sc) {
        System.out.println("\n-------------------------------------");
        System.out.println("           LISTA DE COMBOS");
        System.out.println("-------------------------------------");
        for (int i = 0; i < combos.size(); i++) {
            System.out.println((i + 1) + ". " + combos.get(i));
        }
        
        System.out.print("Seleccione numero de combo: ");
        int op = sc.nextInt();
        
        if (op < 1 || op > combos.size()) {
            System.out.println("Combo no valido.");
            return;
        }

        seleccionados.add(combos.get(op - 1));
        System.out.println("Combo agregado correctamente.");
    }

    private void actualizarCantidad(Scanner sc) {
        if (seleccionados.isEmpty()) {
            System.out.println("No hay combos seleccionados.");
            return;
        }

        mostrarSeleccionados();

        System.out.print("Seleccione combo a actualizar: ");
        int op = sc.nextInt();

        if (op < 1 || op > seleccionados.size()) {
            System.out.println("Opcion invalida.");
            return;
        }

        System.out.print("Nueva cantidad: ");
        int cant = sc.nextInt();

        seleccionados.get(op - 1).setCantidadComprada(cant);

        System.out.println("Cantidad actualizada.");
    }

    private void eliminarCombo(Scanner sc) {
        if (seleccionados.isEmpty()) {
            System.out.println("No hay combos seleccionados.");
            return;
        }

        mostrarSeleccionados();
        System.out.print("Seleccione combo a eliminar: ");
        int op = sc.nextInt();

        if (op < 1 || op > seleccionados.size()) {
            System.out.println("Opcion invalida.");
            return;
        }

        seleccionados.remove(op - 1);
        System.out.println("Combo eliminado.");
    }

    private void mostrarSeleccionados() {
        if (seleccionados.isEmpty()) {
            System.out.println("No hay combos seleccionados.");
            return;
        }
        
        System.out.println("\n-------------------------------------");
        System.out.println("         COMBOS SELECCIONADOS");
        System.out.println("-------------------------------------");
        for (int i = 0; i < seleccionados.size(); i++) {
            System.out.println((i + 1) + ". " + seleccionados.get(i));
        }
    }
    
    private void comprar() {
        if (seleccionados.isEmpty()) {
            System.out.println("No hay combos seleccionados.");
            return;
        }
        
        double total = 0;
        System.out.println("\n-------------------------------------");
        System.out.println("          DETALLE DE COMPRA");
        System.out.println("-------------------------------------");
        
        for (Combo c : seleccionados) {
            System.out.println(c);
            total += c.getTotal();
        }
        
        System.out.println("------------------------------");
        System.out.println("---> TOTAL A PAGAR: S/ " + total);
        System.out.println("------------------------------");
    }
}