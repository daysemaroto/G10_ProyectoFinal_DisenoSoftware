/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import Modelos.Patron_Singleton.ConexionADB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class IniciarSesionController implements Initializable {
    @FXML
    private TextField txtUser,txtPass;
    @FXML
    private Label lbldbstatus;
    
    static Connection conn = ConexionADB.getConexion_DB();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (conn!=null) {lbldbstatus.setText(lbldbstatus.getText()+" Conectada");lbldbstatus.setStyle("-fx-text-fill: green;");
        }else{lbldbstatus.setText(lbldbstatus.getText()+" Offline");lbldbstatus.setStyle("-fx-text-fill: red;");}
    }  
    
    @FXML
    private void iniciarSesion(){
        if(!txtPass.getText().isEmpty() && !txtUser.getText().isEmpty()){
            try {

                String query = "select * from login where idUsuario =? and clave =?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(txtUser.getText()));
                ps.setString(2, txtPass.getText());

                ResultSet  rs = ps.executeQuery();

                //probar 909090909 xxx123

                //cambiar de ventana aqui
                if(rs.next())
                {
                        switch(rs.getString(3)){
                            case "Gerente":
                                System.out.println("Gerente");
                                break;
                            case "Administrador":
                                System.out.println("Administrador");
                                break;
                            case "Vendedor":
                                System.out.println("Vendedor");
                                break;
                            case "Jefe de Bodega":
                                System.out.println("Jefe de Bodega");
                                break;
                        }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Usuario y/ocontraseña no validos !");
                    alert.setContentText("Ooops, no se encontro el usuario!");

                    alert.showAndWait();  
                    }

            } catch (SQLException ex) {
                Logger.getLogger(IniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("Verifique usuario y/o contraseña");
            alert.setContentText("Ooops, usuario y contraseña necesarios!");

            alert.showAndWait(); 
        }
    }
    
    @FXML
    private void cancelar(){
        System.exit(0);
    }
    
}