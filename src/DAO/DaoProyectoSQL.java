package DAO;

import Modelos.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProyectoSQL implements ProyectoDao{

    @Override
    public void insertarProyecto(Proyecto proyecto, DAOManager dao) {
        String sql = "INSERT INTO proyecto VALUES ('" + proyecto.getId() + "','" + proyecto.getNombre() + "','" + proyecto.getDescripcion() + "','" + proyecto.getCategoria() + "'," + proyecto.getCantidadNecesaria() + "," + proyecto.getCantidadFinanciada() + ",'" + Date.valueOf(proyecto.getFechaDeInicio()) + "','" + Date.valueOf(proyecto.getFechaDeFin()) + "','" + proyecto.getNombreCreador() + "');";
        dao.ejecutarSentencia(sql);
    }

    @Override
    public ArrayList<Proyecto> obtenerProyectos(DAOManager dao) {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyecto";
        try{
            Statement stmt = dao.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                java.sql.Date sqlDate = rs.getDate("FechaApertura");
                java.sql.Date sqlDate2 = rs.getDate("FechaDeFin");

                Proyecto proyecto = new Proyecto(
                        rs.getString("Nombre"),
                        rs.getString("Descripcion"),
                        Categoria.valueOf(rs.getString("Categoria")),
                        rs.getInt("CantidadNecesaria"),
                        rs.getInt("CantidadFinanciada"),
                        sqlDate.toLocalDate(),
                        sqlDate2.toLocalDate(),
                        rs.getString("id"),
                        rs.getString("NombreCreador")
                );
                proyectos.add(proyecto);
            }
            return proyectos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modificarProyecto(Proyecto proyecto, DAOManager dao) {
        String sql = "UPDATE Proyecto SET " +
                "Nombre = '" + proyecto.getNombre() + "', " +
                "Descripcion = '" + proyecto.getDescripcion() + "', " +
                "Categoria = '" + proyecto.getCategoria() + "', " +
                "CantidadNecesaria = " + proyecto.getCantidadNecesaria() + ", " +
                "CantidadFinanciada = " + proyecto.getCantidadFinanciada() + ", " +
                "FechaApertura = '" + proyecto.getFechaDeInicio() + "', " +
                "FechaDeFin = '" + proyecto.getFechaDeFin() + "' " +
                "WHERE id = '" + proyecto.getId() + "';";
        dao.ejecutarSentencia(sql);
    }

    @Override
    public void EliminarProyecto(String id, DAOManager dao) {
        String sql = "DELETE FROM proyecto WHERE id = '" + id + "';";
        dao.ejecutarSentencia(sql);
    }
}
