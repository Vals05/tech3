
package com.tienda.tienda.Service;
import com.tienda.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
    //se recupera un registro de la tabla categoria en un objeto de tipo categoria
    //si el id de categoria pasadao por parametro existew, sino se retorna un null
    public Categoria getCategoria (Categoria categoria);
    
    
    //Se inserta un nuevo registro en la tabla categoria... si el objeto pasado NO tiene idCategoria
    //Se actualiza un registro de la tabla categoria... si el onjeto pasado tiene un idCategoria y esteexiste en la tabla.
    public void save(Categoria categoria);
    
    //Elimina un registro de la tabla categoria... si el onjeto pasado tiene un idCategoria y esteexiste en la tabla.
   public void delete(Categoria categoria);
  
}