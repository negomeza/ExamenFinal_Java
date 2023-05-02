
package MODELO;

import java.util.LinkedList;

public class clientes_new {
    
    public static LinkedList<clientes_new> datosClientes = new LinkedList<>();
    
    int codigo;
    String nombre;
    String nit;
    String correo;
    String genero;

    public clientes_new(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public clientes_new(int codigo, String nombre, String nit, String correo, String genero) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
    }

    public clientes_new(String nombre, String nit, String correo, String genero) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.genero = genero;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
