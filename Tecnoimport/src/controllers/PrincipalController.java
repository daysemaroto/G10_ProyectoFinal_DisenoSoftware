/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
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
    public Menu mjb;
    @FXML
    public Menu mvd;
    @FXML
    public Menu mgr;
    @FXML
    public Menu mad;
    @FXML
    public Menu crd;
    @FXML 
    private MenuItem mi1;
    @FXML
    private MenuItem mi2;
    @FXML
    private MenuItem mi3;
    @FXML
    private MenuItem mi4;
    @FXML
    private MenuItem mi5;
    @FXML
    private MenuItem mi6;
    @FXML
    private MenuItem mi7;
    @FXML
    private MenuItem mi8;
    @FXML
    private MenuItem mi9;
    @FXML
    private MenuItem mi10;
    @FXML
    private MenuItem mi11;
    @FXML
    private MenuItem mi13;
    @FXML
    private MenuItem mi14;
    @FXML
    private MenuItem mi15;
    @FXML
    private MenuItem mi16;
    @FXML
    private MenuItem mi17;
    @FXML
    private MenuItem mi18;
    @FXML
    private MenuItem mi19;
    @FXML
    private MenuItem mi20;
    @FXML
    private MenuItem mi21;
    @FXML
    private MenuItem mi22;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    private void clicmi13(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDCliente.fxml"));
            bpane.setCenter(load); 
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi14(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDUsuario.fxml"));
            bpane.setCenter(load);
            
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi15(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDLocal.fxml"));
            bpane.setCenter(load);
            
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi16(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDEmpleado.fxml"));
            bpane.setCenter(load);
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi17(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDArticulos.fxml"));
            bpane.setCenter(load);

            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi18(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDComprobante.fxml"));
            bpane.setCenter(load);
            
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi19(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDFormaPago.fxml"));
            bpane.setCenter(load);
            
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clicmi20(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDVenta.fxml"));
            bpane.setCenter(load);
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void clicmi21(){
        try {
            AnchorPane load =(AnchorPane) FXMLLoader.load(getClass().getResource("/Vistas/CRUDInventario.fxml"));
            bpane.setCenter(load);

        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
