package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOManager {
    private Connection conn;
    private final String URL;
    private final String USER;
    private final String PASS;
    private static DAOManager singlenton;
    /*comentario*/


    private DAOManager() {
        this.conn = null;
        this.URL = "jdbc:mysql://127.0.0.1:3308/fernan";
        this.USER = "root";
        this.PASS = "";
    }


    public static DAOManager getSinglentonInstance(){
        if (singlenton == null) {
            singlenton = new DAOManager();
            return singlenton;
        }else return null;
    }


    public void open() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASS);
    }


    public Connection getConn() {
        return conn;
    }

    public void close() throws Exception {
        if(conn!=null) conn.close();
    }
}
