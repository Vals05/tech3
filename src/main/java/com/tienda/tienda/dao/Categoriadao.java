package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Categoriadao extends JpaRepository<Categoria, Long> {

}
