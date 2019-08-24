/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.pattern_singleton.ConexionADB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class CRUDCliente implements Initializable {
    @FXML
    public TableView<Cliente> table;
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
    @FXML
    public TableColumn tc7;
    @FXML
    private TextField tfsearch;
    
    private ObservableList<Cliente> data = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        table.setItems(null);
        
        tc1.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nombre"));
        tc2.setCellValueFactory(new PropertyValueFactory<Cliente,String>("apellido"));
        tc3.setCellValueFactory(new PropertyValueFactory<Cliente,String>("idCliente"));
        tc4.setCellValueFactory(new PropertyValueFactory<Cliente,String>("edad"));
        tc5.setCellValueFactory(new PropertyValueFactory<Cliente,String>("telefono"));
        tc6.setCellValueFactory(new PropertyValueFactory<Cliente,String>("email"));
        tc7.setCellValueFactory(new PropertyValueFactory<Cliente,String>("direccion"));
        
        
        Connection conn = ConexionADB.getConexion_DB();
        String query = "select * from cliente order by nombre;";
        
        try (ResultSet rs = conn.createStatement().executeQuery(query)){ 
            
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setIdCliente(rs.getString("idCliente"));
                c.setEdad(rs.getString("edad"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                data.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FilteredList<Cliente> filteredData = new FilteredList<>(data, p -> true);
        tfsearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cliente -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (cliente.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
        
        SortedList<Cliente> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
        
    }    
    
}
