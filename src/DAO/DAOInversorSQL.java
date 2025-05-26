package DAO;

import Modelos.Inversor;
import MoldelosGestores.GestorDeUsuarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DAOInversorSQL implements InversorDao {



    @Override
    public void insertarInversor(String nombreDeUsuario,int cartera, DAOManager daoManager) {
        String sql = "INSERT INTO inversor ('"+nombreDeUsuario+"',"+cartera+")";
        daoManager.ejecutarSentencia(sql);
    }

    @Override
    public void modificarCartera(Inversor inversor, DAOManager daoManager) {
        String sql = "UPDATE FROM inversor SET Cartera ="+inversor.verCatera();
        daoManager.ejecutarSentencia(sql);
    }

    @Override
    public int obtenerInversores(DAOManager daoManager,String nombreDeUsuario) {
        String sql = "SELECT * FROM inversor WHERE NombreInversor = '"+nombreDeUsuario+"'";
        int cartera = 0;
        try {
           Statement stmt = daoManager.getConn().createStatement();
           ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                 cartera = rs.getInt("Cartera");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return cartera;
    }
}
