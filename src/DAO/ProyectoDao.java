package DAO;

import Modelos.Proyecto;

import java.util.ArrayList;

public interface ProyectoDao {
    void insertarProyecto(Proyecto proyecto,String nombreDeCreador);
    ArrayList<Proyecto>obtenerProyectos();
    void modificarProyecto(Proyecto proyecto);
    void EliminarProyecto(String id);

}
