package DAO;

import Modelos.Inversor;

import java.util.ArrayList;
import java.util.HashMap;

public interface InversorDao {
    void insertarInversor(String nombreDeUsuario,int dineroDeCartera,DAOManager daoManager);
    void modificarCartera(Inversor  inversor,DAOManager daoManager);
    int  obtenerInversores(DAOManager daoManager ,String nombreDeUsuario );
}
