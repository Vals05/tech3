package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Productodao extends JpaRepository <Producto, Long>{
    
}
