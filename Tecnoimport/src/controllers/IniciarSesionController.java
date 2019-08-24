/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.pattern_singleton.ConexionADB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class IniciarSesionController implements Initializable {
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    @FXML
    private Label lbldbstatus;
    @FXML
    private Button btnLogin;
    
    static Connection conn = ConexionADB.getConexion_DB();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (conn!=null) {lbldbstatus.setText(lbldbstatus.getText()+" Conectada");lbldbstatus.setStyle("-fx-text-fill: green;-fx-font-size: 12px;");
        }else{lbldbstatus.setText(lbldbstatus.getText()+" Offline");lbldbstatus.setStyle("-fx-text-fill: red;-fx-font-size: 15px;");}
    }  
    
    @FXML
    private void iniciarSesion() throws SQLException{
        if(!txtPass.getText().isEmpty() && !txtUser.getText().isEmpty() && isNumeric(txtUser.getText())){
            PreparedStatement ps=null;
            ResultSet  rs =null;
            try {

                String query = "select * from login where idUsuario =? and clave =?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(txtUser.getText()));
                ps.setString(2, txtPass.getText());

                rs = ps.executeQuery();

                //probar 0909090909   xxx123

                //cambiar de ventana aqui
                if(rs.next())
                {
                    
                    txtPass.setText("");
                    txtUser.setText("");
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/Vistas/Principal.fxml"));
                    PrincipalController controller = new PrincipalController();
                    loader.setController(controller);
                    Parent root = (Parent)loader.load();

                    
                    stage.setScene(new Scene(root));
                    stage.show();
                        
                    stage.setOnHidden((WindowEvent event) -> {
                        ((Stage)btnLogin.getScene().getWindow()).show();
                    });
                        
                    ((Stage)btnLogin.getScene().getWindow()).close();
                    
                    switch(rs.getString(3)){
                        case "Gerente":
                            controller.mvd.setVisible(false);
                            controller.mad.setVisible(false);
                            controller.mjb.setVisible(false);
                            break;
                        case "Administrador":
                            break;
                        case "Vendedor":
                            controller.mgr.setVisible(false);
                            controller.mad.setVisible(false);
                            controller.mjb.setVisible(false);
                            break;
                        case "Jefe de Bodega":
                            controller.mvd.setVisible(false);
                            controller.mad.setVisible(false);
                            controller.mgr.setVisible(false);
                            break;
                        default:
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

            } catch (SQLException | IOException ex) {
                Logger.getLogger(IniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{ps.close();rs.close();}
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
    
    public static boolean isNumeric(String strNum) {
    try {
        Integer.parseInt(strNum);
    } catch (java.lang.NumberFormatException | NullPointerException nfe) {
        return false;
    }
    return true;
}
    
}
