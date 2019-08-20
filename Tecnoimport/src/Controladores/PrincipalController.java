/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.sun.javafx.scene.control.skin.Utils;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class PrincipalController implements Initializable {

    @FXML
    private BorderPane bpane;
    @FXML
    private Menu mjb,mvd,mgr,mad,crd;
    @FXML 
    private MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi13,mi14,mi15,mi16,mi17,mi18,mi19,mi20,mi21,mi22;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    private void clic(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUD.fxml"));
            bpane.setCenter(load);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
