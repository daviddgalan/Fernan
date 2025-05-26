package DAO;

import Modelos.Administrador;
import Modelos.Gestor;
import Modelos.Inversor;
import Modelos.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DaoUsuarioSQL implements UsuarioDao {

    @Override
    public void insertar(Usuario usuario, DAOManager dao){
        String sql = "INSERT INTO usuario VALUES ('" + usuario.getNombre() + "','" + usuario.getContraseña() + "','" + usuario.getCorreo() + "'," + usuario.isBloqueado() + "," + usuario.getTipoUsuario() + ");";
        dao.ejecutarSentencia(sql);
    }

    @Override
    public HashMap<String, Usuario> obtenerTodos(DAOManager dao) {
        HashMap<String, Usuario> entrada = new HashMap<>();
        String sql = "SELECT * FROM usuario";
        try{
            Statement stmt = dao.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                switch (rs.getInt("TipoDeUsuario")){
                    case 1: {
                        Administrador admin = new Administrador(rs.getString("Nombre"),rs.getString("Correo"),rs.getString("Contrasena"));
                        entrada.put(admin.getNombre(),admin);
                    }
                    break;
                    case 2: {
                        Gestor gestor = new Gestor(rs.getString("Nombre"),rs.getString("Correo"),rs.getString("Contrasena"), rs.getBoolean("Bloqueado"));
                        entrada.put(gestor.getNombre(),gestor);
                    }
                    break;
                    case 3: {
                        Inversor inversor = new Inversor(rs.getString("Nombre"),rs.getString("Correo"),rs.getString("Contrasena"), rs.getBoolean("Bloqueado"));
                        entrada.put(inversor.getNombre(), inversor);
                    }
                    break;
                }
            }
            return entrada;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarUsuario(String usuarioAntiguo, Usuario usuario, DAOManager dao) {
        String sql = "UPDATE usuario SET Nombre = '" + usuario.getNombre() + "', Contrasena = '" + usuario.getContraseña() + "' WHERE Nombre = '"+ usuarioAntiguo +"';";
        dao.ejecutarSentencia(sql);
    }

}
