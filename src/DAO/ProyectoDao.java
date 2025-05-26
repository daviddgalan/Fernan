package DAO;

import Modelos.Proyecto;

import java.util.ArrayList;

public interface ProyectoDao {
    void insertarProyecto(Proyecto proyecto, DAOManager dao);
    ArrayList<Proyecto>obtenerProyectos(DAOManager dao);
    void modificarProyecto(Proyecto proyecto, DAOManager dao);
    void EliminarProyecto(String id, DAOManager dao);
}
