
package com.tienda.tienda.Service;
import com.tienda.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
    
}
