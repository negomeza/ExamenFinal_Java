
package MODELO;

import java.util.LinkedList;

public class ventas_new {
    
    public static LinkedList<ventas_new> datosVentas = new LinkedList<>();
     
    int codigo_producto;
    String nombre;
    int codigo_cliente;
    int cantidad;
    int precio;
    int subtotal;

    public ventas_new(int codigo_producto, String nombre, int codigo_cliente, int cantidad, int precio, int subtotal) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.codigo_cliente = codigo_cliente;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }


    public ventas_new(int codigo_producto, String nombre, int codigo_cliente, int cantidad, int precio) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.codigo_cliente = codigo_cliente;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public static LinkedList<ventas_new> getDatosVentas() {
        return datosVentas;
    }

    public static void setDatosVentas(LinkedList<ventas_new> datosVentas) {
        ventas_new.datosVentas = datosVentas;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
