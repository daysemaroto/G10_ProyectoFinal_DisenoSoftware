/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import models.Inventario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class CRUDInventarioController implements Initializable {

    @FXML
    public TableView<Inventario> table;
    @FXML
    public TableColumn tc1;
    @FXML
    public TableColumn tc2;
    @FXML
    public TableColumn tc3;
    @FXML
    public TableColumn tc4;
    @FXML
    public TableColumn tc5;
    @FXML
    public TableColumn tc6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      
    
}
