package DAO;

import Modelos.Amigo;

import java.util.ArrayList;

public interface AmigoDao {
    void insertarAmigo(Amigo amigo, DAOManager dao, String nombreInversor);
    ArrayList<Amigo>obtenerAmigo(DAOManager dao, String nombreInversor);
}

