package com.tienda.tienda.Service;

import com.tienda.tienda.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    //se obtiene un listado de usuarios en un List
    public List<Usuario> getUsuarios();

    //se recupera un registro de la tabla usuario en un objeto de tipo usuario
    //si el id de usuario pasadao por parametro existew, sino se retorna un null
    public Usuario getUsuario(Usuario usuario);

    public Usuario getUsuarioPorUsername(String username);

    public Usuario getUsuarioPorUsernameYPassword(String username, String password);

    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo);

    public boolean existsUsuarioPorUsernameOCorreo(String username, String correo);

    //Se inserta un nuevo registro en la tabla usuario... si el objeto pasado NO tiene idUsuario
    //Se actualiza un registro de la tabla usuario... si el onjeto pasado tiene un idUsuario y esteexiste en la tabla.
    public void save(Usuario usuario, boolean creaRol);

    //Elimina un registro de la tabla usuario... si el onjeto pasado tiene un idUsuario y esteexiste en la tabla.
    public void delete(Usuario usuario);
    //Se define el metodo para llamar a la consulta ampliada

}
