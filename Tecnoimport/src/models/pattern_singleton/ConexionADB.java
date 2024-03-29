/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.pattern_singleton;

import Controladores.notifyManagement;
import Controladores.updateUsersController;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ConexionADB {
    private static Connection conexion;
    private static final Logger LOGGER = Logger.getLogger("Modelos.Patron_Observer");

    
    
    private ConexionADB() {
        throw new IllegalStateException("Utility class");
    }
    
    public static Connection getConexion_DB(){
        if( conexion==null){ 
            return ConexionADB.getConexion();
        }
        return conexion;
    }

    private static Connection getConexion() {
        String uname = "luis";
        String password = "luis2020";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  

            conexion = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/tecnoimport?"+
                "user=" + uname + "&password=" + password);
            LOGGER.log(Level.INFO, "Conexion exitosa");
        } catch (ClassNotFoundException | SQLException ex) {

            notifyManagement.notifDefaul("No se pudo conectar a la base de datos!"+ex.getMessage(),"Error");
            conexion = null;
        } 
        return conexion;
    }
    
    public static void closePS(PreparedStatement stmt){
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException eClosing2) {
             Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, eClosing2);
        }
    }
    
    public static void closeCS(CallableStatement stmt){
         try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException eClosing2) {
                Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, eClosing2);
        }
    }
    
    public static void closeRS(ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException eClosing1) {
            LOGGER.log(Level.INFO, "Conexion cerrada");
        }
    }
  
    
    
    
    
    
}
