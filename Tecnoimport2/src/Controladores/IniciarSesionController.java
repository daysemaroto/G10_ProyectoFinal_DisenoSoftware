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

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class IniciarSesionController implements Initializable {
    @FXML
    private Button btnLogin;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    @FXML
    private void iniciarSesion(){
        ConexionADB.getConexion_DB();
    }
    
}
