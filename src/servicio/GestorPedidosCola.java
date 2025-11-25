package servicio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import modelo.Combo;
import modelo.Pedido;
import modelo.Producto;

public class GestorPedidosCola {
    private Queue<Pedido> colaPedidos = new LinkedList<>();
    private ArrayList<Producto> productosDisponibles = new ArrayList<>();
    private ArrayList<Combo> combosDisponibles = new ArrayList<>();
    
    public GestorPedidosCola(){
        productosDisponibles.add(new Producto(1, "Coca-Cola 1L", 4.00 , 1));
        productosDisponibles.add(new Producto(2, "Leche Gloria 400g", 4.20 , 1));
        productosDisponibles.add(new Producto(3, "Wafer KitKat 41.5g", 5.50 , 1));
        productosDisponibles.add(new Producto(4, "Empanada de pollo", 3.40 , 1));
        productosDisponibles.add(new Producto(5, "Inka-Kola 500ml", 3.00 , 1));
        productosDisponibles.add(new Producto(6, "Inka Chips Jalapeño 135gr", 6.50 , 1));
        productosDisponibles.add(new Producto(7, "Donofrio Sublime 80ml", 3.50 , 1));
    
        combosDisponibles.add(
            new Combo("Combo 1",
                    new Producto(10, "Coca-cola 500ml", 2.50, 1), 
                    new Producto(6, "Inka Chips Jalapeño 135gr ", 6.50 , 1),
                    8.00)
        );
        combosDisponibles.add(
            new Combo("Combo 2",
                    new Producto(4, "Empanada de pollo", 3.40 , 1), 
                    new Producto(5, "Inka-Kola 500ml", 3.00 , 1),
                    5.00)
        );
    }  

    public void menuPedidos(Scanner sc){
        String opcion;
        do{
            System.out.println("\n-------------------------------------");
            System.out.println("             MENU PEDIDOS");
            System.out.println("-------------------------------------");
            System.out.println("1. Mostrar Pedidos");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Agregar un Pedido");
            System.out.println("4. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextLine();
            
            switch (opcion) {
                case "1":   
                    mostrarPedido(sc);
                    break;
                case "2":   
                    Pedido atendido = colaPedidos.poll();
                    if(atendido == null){
                        System.out.println("No hay pedidos pendientes.");
                    } else {
                        System.out.println("Se atendio el pedido "+ atendido.getNumeroPedido());
                    }
                    System.out.println("Se atendio al Cliente correctamente.");
                    break;
                case "3": 
                    agregarPedido(sc);
                    break;
            }
        }while(!opcion.equals("4"));
    }
 
    public void mostrarPedido(Scanner sc){
        if(colaPedidos.isEmpty()){
            System.out.println("No hay pedidos pendientes.");
            return;
        }
        
        System.out.println("\n-------------------------------------");
        System.out.println("             LISTA DE PEDIDOS");
        System.out.println("-------------------------------------");
        for(Pedido p: colaPedidos){
            System.out.println(p);
        }
        
        String opcionMostrar;
        do{
            System.out.println("\n-------------------------------------");
            System.out.println("             OPCIONES");
            System.out.println("-------------------------------------");
            System.out.println("1. Ver informacion de un pedido");
            System.out.println("2. Volver al menu de pedidos");
            System.out.println("Seleccione una opcion: ");
            opcionMostrar = sc.nextLine();
            
            switch (opcionMostrar) {
                case "1":
                    System.out.println("Ingrese numero de pedido: ");
                    int num = Integer.parseInt(sc.nextLine());
                    mostrarInformacionPedido(num);
                    break;
            }
        }while(!opcionMostrar.equals("2"));
    }
    
    private void mostrarInformacionPedido(int numero){
        for(Pedido p: colaPedidos){
            if(p.getNumeroPedido() == numero){
                System.out.println("\n-------------------------------------");
                System.out.println("             DETALLE DEL PEDIDO");
                System.out.println("-------------------------------------");
                System.out.println("Cliente: "+ p.getNombre());
                
                System.out.println("Productos: ");
                for(Producto producto: p.getProductos()){
                    System.out.println(" - "+ producto.getNombre() + " Cantidad: "+ producto.getCantidadComprada()+
                            " -> S/"+producto.getImporte());
                }
                
                System.out.println("Combos");
                for(Combo c: p.getCombos()){
                    System.out.println(""+c);
                }
                
                System.out.println("\nTOTAL = S/"+p.calcularTotal());
                return;
            }
        }
        System.out.println("No existe un pedido con ese numero");
    }
    
   
    private void agregarPedido(Scanner sc){
        System.out.println("Ingrese nombre del cliente:");
        String nombre = sc.nextLine();
        Pedido pedido = new Pedido(nombre);
        String opcionAgregar;
        do{
            System.out.println("\n-------------------------------------");
            System.out.println("             SELECCIONE SU PEDIDO");
            System.out.println("-------------------------------------");
            System.out.println("1. Producto");
            System.out.println("2. Combos");
            System.out.println("3. Cambiar nombre del cliente");
            System.out.println("4. Agregar el Pedido");
            System.out.println("Seleccione una opcion: ");
            opcionAgregar = sc.nextLine();
            
            switch (opcionAgregar) {
                case "1":
                    seleccionarProducto(sc, pedido);
                    break;
                case "2":   
                    seleccionarCombo(sc, pedido);
                    break;
                case "3":
                    System.out.println("Ingrese nuevo nombre:");
                    nombre = sc.nextLine();
                    pedido.setNombre(nombre);
                    break;
                case "4":
                    colaPedidos.add(pedido);
                    System.out.println("Pedido agregado con exito.");
            }
        }while(!opcionAgregar.equals("4"));
    }
    
    public void seleccionarProducto(Scanner sc, Pedido pedido){
        System.out.println("\n-------------------------------------");
        System.out.println("             PRODUCTOS DISPONIBLES");
        System.out.println("-------------------------------------");
        
        for(Producto p: productosDisponibles){
            System.out.println(p.getCodigo() +". "+ p.getNombre() +" S/"+p.getPrecioUnitario());
        }
        
        System.out.println("Ingrese codigo del producto: ");
        int codigo = Integer.parseInt(sc.nextLine());
        
        for(Producto p: productosDisponibles){
            if(p.getCodigo() == codigo){
                System.out.println("Cantidad: ");
                int cantidad = Integer.parseInt(sc.nextLine());
                Producto copia = new Producto(p.getCodigo(), p.getNombre(), p.getPrecioUnitario(), cantidad);
                pedido.agregarProducto(copia);
                
                System.out.println("Producto agregado correctamente.");
                return;
            }
        }
        System.out.println("Codigo invalido.");
    }
    
    public void seleccionarCombo(Scanner sc, Pedido pedido){
        System.out.println("\n-------------------------------------");
        System.out.println("             COMBOS DISPONIBLES");
        System.out.println("-------------------------------------");
        int i = 1;
        for(Combo c: combosDisponibles){
            System.out.println(i++ +"."+ c.getNombre() +" - S/"+ c.getPrecioFinal() +
                    " | Contiene: ["+ c.getP1().getNombre() +", "+ c.getP2().getNombre() +"]");
        }
        System.out.println("seleccione un combo: ");
        int seleccion = Integer.parseInt(sc.nextLine());
        
        if(seleccion < 1 || seleccion > combosDisponibles.size()){
            System.out.println("Seleccion invalida.");
            return;
        }
        
        Combo original = combosDisponibles.get(seleccion - 1);
        
        System.out.println("Cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());
        
        Combo copia = new Combo(original.getNombre(), original.getP1(), original.getP2(), original.getPrecioFinal());
        copia.setCantidadComprada(cantidad);
        pedido.agregarCombo(copia);
        System.out.println("Combo agregado correctamente.");
    }
}
