package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuariodao extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
    public Usuario findByUsernameAndPassword(String username, String password);
    public Usuario findByUsernameOrCorreo(String username, String correo);
    public boolean existsByUsernameOrCorreo(String username, String correo);

}
