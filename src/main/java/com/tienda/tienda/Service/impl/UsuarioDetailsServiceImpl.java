package com.tienda.tienda.Service.impl;

import com.tienda.tienda.Service.UsuarioDetailsService;
import com.tienda.tienda.dao.Usuariodao;
import com.tienda.tienda.domain.Rol;
import com.tienda.tienda.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{

    
    @Autowired 
    private Usuariodao usuariodao;
    @Autowired 
    private HttpSession session;
    
    
    @Override
    @Transactional (readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        Usuario usuario = usuariodao.findByUsername(username);
        
        if (usuario == null){
            throw new UsernameNotFoundException(username);
        }
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());
        var roles= new ArrayList<GrantedAuthority>();
        for (Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
            
        }
    
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

  
}
