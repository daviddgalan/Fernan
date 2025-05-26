package DAO;

import Modelos.Amigo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOAmigoSQL implements AmigoDao{
    @Override
    public void insertarAmigo(Amigo amigo, DAOManager dao, String nombreInversor) {
        String sql="INSERT INTO amigo VALUES('" + nombreInversor + "','" + amigo.getNombre() + "','" + amigo.getCorreo() + "');";
        dao.ejecutarSentencia(sql);
    }

    @Override
    public ArrayList<Amigo> obtenerAmigo(DAOManager dao, String nombreInversor) {
        ArrayList<Amigo> amigos = new ArrayList<>();
        String sql = "SELECT * FROM amigo WHERE NombreInversor = ?";

        try {
            PreparedStatement ps = dao.getConn().prepareStatement(sql);
            ps.setString(1, nombreInversor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Amigo amigo = new Amigo(rs.getString("Nombre"),rs.getString("Correo"));
                amigos.add(amigo);
            }
            return amigos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
