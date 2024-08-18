
package com.tienda.tienda.Service;
import com.tienda.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    //se obtiene un listado de productos en un List
    public List<Producto> getProductos(boolean activos);
    //se recupera un registro de la tabla producto en un objeto de tipo producto
    //si el id de producto pasadao por parametro existew, sino se retorna un null
    public Producto getProducto (Producto producto);
    
    
    //Se inserta un nuevo registro en la tabla producto... si el objeto pasado NO tiene idProducto
    //Se actualiza un registro de la tabla producto... si el onjeto pasado tiene un idProducto y esteexiste en la tabla.
    public void save(Producto producto);
    
    //Elimina un registro de la tabla producto... si el onjeto pasado tiene un idProducto y esteexiste en la tabla.
   public void delete(Producto producto);
   //Se define el metodo para llamar a la consulta ampliada
       public List<Producto> findByPrecioDetweenOrderByDescripcion(double precioInf, double precioSup);
    //Se define el metodo para llamar a la consulta ampliada JPQL
       public List<Producto> metodoJPQL(double precioInf, double precioSup);
       
       //Se define el metodo para llamar a la consulta ampliada SQL
       public List<Producto> metodoSQL(double precioInf, double precioSup);
}
