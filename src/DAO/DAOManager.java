package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOManager {
    private Connection conn;
    private final String URL;
    private final String USER;
    private final String PASS;
    private static DAOManager singlenton;



    private DAOManager() {
        this.conn = null;
        this.URL = "jdbc:mysql://127.0.0.1:3306/fernan";
        this.USER = "root";
        this.PASS = "";
    }


    public static DAOManager getSinglentonInstance(){
        if (singlenton == null) {
            singlenton = new DAOManager();
            return singlenton;
        }else return null;
    }


    public void open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConn() {
        return conn;
    }

    public void close() {
        try {
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean ejecutarSentencia(String sql){
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
