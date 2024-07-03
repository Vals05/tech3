
package com.tienda.tienda.Service.impl;
import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.Service.CategoriaService;
import com.tienda.tienda.dao.Categoriadao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl  implements CategoriaService{
    @Autowired
    private Categoriadao categoriadao;
    @Override
    @Transactional (readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista= categoriadao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo());
            
        }
        return lista;
    }
    
}
