/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 * 
 * Clase que se encarga del control de la interaccion entre pantallas durante la ejecución del sistema
 * 
 */
public class windowManagement {
    
    public void changeWindow(String route, Event event){
        try{
            Parent homepParent = FXMLLoader.load(getClass().getResource("/Vistas/" + route));
            Scene scene = new Scene(homepParent);
            Stage mainstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainstage.hide();
            mainstage.setScene(scene);
            mainstage.show();
        }catch(IOException e){
           
            notifyManagement.showAlert("Tenemos Problemas Tecnicos! "+e.getMessage(), Alert.AlertType.NONE, "Window Management");
        }
        
    }
    
    public void closeFloatingWindow(Event event){
        Stage mainstage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainstage.close();
    }
    
    public void mostrarVentanaFlotante(String ventana){
        Stage stage = new Stage();
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("/Vistas/"+ventana));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  
        }catch(IOException e){
            
            notifyManagement.showAlert("Tenemos Problemas Tecnicos!", Alert.AlertType.NONE, "Window Management");
        }
        
    }
}