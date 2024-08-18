package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Productodao extends JpaRepository<Producto, Long> {

    // Ejemplo de una consulta ampliada 
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    // Ejemplo de una consulta ampliada usando JPQL
    @Query(value = "SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    // Ejemplo de una consulta ampliada usando SQL  NATIVO  
    @Query(nativeQuery=true, value = "SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoSQL(double precioInf, double precioSup);
}
