package modelo;


public class Lote {

    String sku, nombreProducto, fechaRecepcion;

    int cantidad;

    public Lote(String sku, String nombreProducto, int cantidad, String fechaRecepcion) {
        this.sku = sku;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaRecepcion = fechaRecepcion;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public String getFechaRecepcion() {
        return this.fechaRecepcion;
    }


    public void reducirCantidad(int cantidadSacada) {
        this.cantidad -= cantidadSacada;
    }

    @Override
    public String toString() {
        return "Lote [SKU: " + sku + ", Producto: " + nombreProducto
                + ", Cantidad: " + cantidad + ", Recibido: " + fechaRecepcion + "]";
    }
}
