package modelo;

public class Combo {
    private String nombre;
    private Producto p1;
    private Producto p2;
    private double precioFinal;   
    private int cantidadComprada;
    
    public Combo(String nombre, Producto p1, Producto p2, double precioFinal) {
        this.nombre = nombre;
        this.p1 = p1;
        this.p2 = p2;
        this.precioFinal = precioFinal;
        this.cantidadComprada = 1;
    }
    
    public String getNombre() { return nombre; }
    public Producto getP1() { return p1; }
    public Producto getP2() { return p2; }
    public double getPrecioFinal() { return precioFinal; }
    public int getCantidadComprada() { return cantidadComprada; }
    
    public void setCantidadComprada(int cantidad) {
        this.cantidadComprada = cantidad;
    }
    
    public double getTotal() {
        return precioFinal * cantidadComprada;
    }
    
    @Override
    public String toString() {
        return nombre + " | Productos: [" + 
               p1.getNombre() + ", " + p2.getNombre() + 
               "] | Precio: S/ " + precioFinal + 
               " | Cantidad: " + cantidadComprada;
    }
}