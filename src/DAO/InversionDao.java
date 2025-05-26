package DAO;

import Inversión.Inversion;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;

import java.util.ArrayList;

public interface InversionDao {
    void insertarInversion(Inversion inversion,DAOManager daoManager);
    ArrayList<Inversion>optenerInversion(DAOManager daoManager, GestorDeProyecto gestorDeProyecto, GestorDeUsuarios gestorDeUsuarios);
    void modificarInversion(Inversion inversion ,DAOManager daoManager);
}
