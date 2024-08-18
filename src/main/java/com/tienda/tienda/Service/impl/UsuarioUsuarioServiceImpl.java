package com.tienda.tienda.Service.impl;

import com.tienda.tienda.domain.Usuario;
import com.tienda.tienda.Service.UsuarioService;
import com.tienda.tienda.dao.Roldao;
import com.tienda.tienda.dao.Usuariodao;
import com.tienda.tienda.domain.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioUsuarioServiceImpl implements UsuarioService {

    @Autowired
    private Usuariodao usuariodao;

    @Autowired
    private Roldao roldao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        var lista = usuariodao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)

    public Usuario getUsuario(Usuario usuario) {
        return usuariodao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)

    public Usuario getUsuarioPorUsername(String username) {
        return usuariodao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)

    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuariodao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)

    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuariodao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuariodao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean creaRol) {
        usuario=usuariodao.save(usuario);
        if(creaRol){
            Rol rol = new Rol();
            rol.setIdUsuario(usuario.getIdUsuario());
            rol.setNombre("ROLE_USER");
            roldao.save(rol);
        }
    }

    @Override
    @Transactional

    public void delete(Usuario usuario) {
        usuariodao.delete(usuario);
    }

}
