package DAO;

import Modelos.Inversor;

import java.util.ArrayList;

public interface InversorDao {
    void insertarInversor(Inversor inversor);
    void modificarCartera(Inversor  inversor,int NuevoCredito );
    ArrayList<Inversor>obtenerInversores();

}
