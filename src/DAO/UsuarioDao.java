package DAO;

import Modelos.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public interface UsuarioDao {
    void insertar(Usuario usuario, DAOManager dao);
    HashMap<String, Usuario> obtenerTodos(DAOManager dao);
    void actualizarUsuario(String usuarioAntiguo,Usuario usuario, DAOManager dao);
}
