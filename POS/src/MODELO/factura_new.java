
package MODELO;

import java.util.Date;

public class factura_new { 
 int codigo; 
 Date fecha;
 String nombre;        
 String nit;
 int total;

    public factura_new(int codigo, Date fecha, String nombre, String nit, int total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.nombre = nombre;
        this.nit = nit;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
 
 
         
         
}
