/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Interfaces.ConexionDB;

/**
 *
 * @author Michelle
 */
public final class Conectar implements ConexionDB {

    private static Connection conn;
   //Instancia de Singleton
    private static final Conectar instance = new Conectar();
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "root";
    /*la contraseña de mysql*/
    private static final String url = "jdbc:mysql://localhost/tecnoimport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Conectar() {
        conn = null;

    }

    //Este metodo nos retorna la conexion de la BD
    @Override
    public void getConnection() {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error al conectar: " + e);
        }
    }

    //Con este metodo con desconectamos de la BD
    public void desconectar() {
        /*
        conn=null;
        if(conn == null){
            System.out.println("Conexion terminada...");
        }*/
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en conexion BD", JOptionPane.ERROR);
        }
    }

  
}
