package DAO;

import Inversión.Inversion;
import Modelos.Inversor;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOInversion implements InversionDao {

    @Override
    public void insertarInversion(Inversion inversion, DAOManager daoManager) {
        String sql = "INSERT INTO inversion VALUES('"+inversion.getInversor().getNombre()+"','"+inversion.getProyecto1().getId()+"','"+ Date.valueOf(inversion.getFechaDeInversion()) +"',"+inversion.getCantidadInvertida()+")";
        daoManager.ejecutarSentencia(sql);
    }

    @Override
    public ArrayList<Inversion> optenerInversion(DAOManager daoManager, GestorDeProyecto gestorDeProyecto, GestorDeUsuarios gestorDeUsuarios) {
        ArrayList<Inversion>inversiones = new ArrayList<>();
        String sql  = "SELECT * FROM inversion";
        try {
            Statement stmt = daoManager.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                java.sql.Date sqlDate = rs.getDate("FechaInversion");
                Inversion inversion = new Inversion(gestorDeProyecto.buscarProyecto(rs.getNString("idProyecto")),rs.getFloat("CantidadInvertida"), sqlDate.toLocalDate() , (Inversor) gestorDeUsuarios.buscarUsuario(rs.getNString("NombreInversor")));
                inversiones.add(inversion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return inversiones;
    }


    @Override
    public void modificarInversion(Inversion inversion, DAOManager daoManager) {
        String sql = "UPDATE inversion SET CantidadInvertida = "+inversion.getCantidadInvertida();
        daoManager.ejecutarSentencia(sql);
    }

}
