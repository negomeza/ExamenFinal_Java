
package MODELO;

import java.util.LinkedList;

public class vendedores_new {
    
    public static LinkedList<clientes_new> datosClientes = new LinkedList<>();
    
    int codigo;
    String nombre;
    int caja;
    int ventas; 
    String genero;
    String contrasenia;

    public vendedores_new(int codigo, String nombre, int caja, int ventas, String genero, String contrasenia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.contrasenia = contrasenia;
    }

    public vendedores_new(String nombre, int caja, int ventas, String genero, String contrasenia) {
        this.nombre = nombre;
        this.caja = caja;
        this.ventas = ventas;
        this.genero = genero;
        this.contrasenia = contrasenia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
    
}
