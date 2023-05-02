
package DAO;

import MODELO.factura_new;

public interface facturaDAO {
    
    public factura_new obtener(int codigo , String nit, String nombre);
    
}
