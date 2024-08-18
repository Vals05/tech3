package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuariodao extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

}
