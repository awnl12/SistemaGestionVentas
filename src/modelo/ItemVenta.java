package modelo;

public class ItemVenta {
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private double importe;

    public ItemVenta(String nombre, double precioUnitario, int cantidad) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importe = precioUnitario*cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getImporte() {
        return importe;
    }
    
    @Override
    public String toString(){
        return nombre + " x" + cantidad + " | S/ " + importe;
    }
    
}
