package DAO;

import Inversión.Inversion;

import java.util.ArrayList;

public interface InversionDao {
    void insertarInversion(Inversion inversion);
    ArrayList<Inversion>optenerInversion();
    void modificarInversion(Inversion inversion);

}
