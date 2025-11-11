package modelo;

/*
    Clase: Producto
    Ubicación: package modelo/
    pa que sirve :
        que puedes compar en el tambo 
        estas clases sirven para los nombres , los cod etc
        tambien como precio unitario y cantidad comprada
*/

public class Producto {
    private int codigo;
    private String nombre;
    private double precioUnitario;
    private int cantidadComprada;

    public Producto(int codigo, String nombre, double precioUnitario, int cantidadComprada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadComprada = cantidadComprada;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getCantidadComprada() { return cantidadComprada; }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    // Calcula el importe total del producto
    public double getImporte() {
        return precioUnitario * cantidadComprada;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: S/." + precioUnitario +
               ", Cantidad: " + cantidadComprada + ", Importe: S/." + getImporte();
    }
}
