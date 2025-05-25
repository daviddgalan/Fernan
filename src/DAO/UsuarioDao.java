package DAO;

import Modelos.Usuario;

import java.util.ArrayList;

public interface UsuarioDao {
    void insertar(Usuario usuario);
    ArrayList<Usuario> obtenerTodos();
    void actualizarUsuario(Usuario usuario);
}
