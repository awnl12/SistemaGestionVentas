package modelo;

import java.util.ArrayList;

public class Pedido {
    private String nombre;
    private static int numero = 1000;
    private int numeroPedido;
    private ArrayList<Producto> productos;
    private ArrayList<Combo> combos;
    
    public Pedido(String nombre) {
        this.nombre = nombre;
        numero++;
        this.numeroPedido = numero;
        this.productos = new ArrayList<>();
        this.combos = new ArrayList<>();
    }
    
    public int getNumeroPedido() {
        return numeroPedido;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Combo> getCombos() {
        return combos;
    }   
    
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    
    public void agregarCombo(Combo c){
        combos.add(c);
    }
    
    public double calcularTotal(){
        double total = 0;
        for(Producto p: productos){
            total+= p.getImporte();
        }
        for(Combo c: combos){
            total+= c.getTotal();
        }
        return total;
    }
    
    @Override
    public String toString(){
        return "Pedido "+ numeroPedido +" - Cliente: "+ nombre;
    }

    


}
