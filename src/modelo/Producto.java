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

    // (atributos del producto)
    public int codigo;
    public String nombre;
    public double precioUnitario;
    public int cantidadComprada;

    // Constructor 
    public Producto(int codigo, String nombre, double precioUnitario, int cantidadComprada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadComprada = cantidadComprada;
    }

    // calcular el importe del prodducto
    public double getImporte() {
        return precioUnitario * cantidadComprada;
    }

    // info del prodcuto
    public void mostrar() {
        System.out.printf("%-10d %-15s %-10.2f %-10d %-10.2f\n",
                codigo, nombre, precioUnitario, cantidadComprada, getImporte());
    }
}
