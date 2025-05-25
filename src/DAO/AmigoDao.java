package DAO;

import Modelos.Amigo;

import java.util.ArrayList;

public interface AmigoDao {
    void insertarAmigo(Amigo amigo);
    ArrayList<Amigo>obtenerAmigo();
}

