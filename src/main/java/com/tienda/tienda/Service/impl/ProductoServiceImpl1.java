package com.tienda.tienda.Service.impl;

import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.Service.ProductoService;
import com.tienda.tienda.dao.Productodao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl1 implements ProductoService {

    @Autowired
    private Productodao productodao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productodao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());

        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Producto getProducto(Producto producto) {
        return productodao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productodao.save(producto);
    }

    @Override
    @Transactional

    public void delete(Producto producto) {
        productodao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioDetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productodao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productodao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoSQL(double precioInf, double precioSup) {
        return productodao.metodoSQL(precioInf, precioSup);
    }
}
