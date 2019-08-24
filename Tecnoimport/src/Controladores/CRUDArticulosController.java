/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Articulo;
import Modelos.Cliente;
import Modelos.Patron_Singleton.ConexionADB;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jhon_
 */
public class CRUDArticulosController implements Initializable {

    @FXML
    public TableView<Articulo> table;
    @FXML
    public TableColumn tc1,tc2,tc3,tc4,tc5,tc6;
    @FXML
    private TextField tfsearch;

    private ObservableList<Articulo> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setItems(null);
        
        tc1.setCellValueFactory(new PropertyValueFactory<Cliente,String>("idArticulo"));
        tc2.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nombre"));
        tc3.setCellValueFactory(new PropertyValueFactory<Cliente,String>("categoria"));
        tc4.setCellValueFactory(new PropertyValueFactory<Cliente,String>("descripcion"));
        tc5.setCellValueFactory(new PropertyValueFactory<Cliente,String>("precio"));
        tc6.setCellValueFactory(new PropertyValueFactory<Cliente,String>("tiempoMaximoEntrega"));
        
        try { 
            String query = "select * from articulo order by idArticulo;";
            Connection conn = ConexionADB.getConexion_DB();
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                Articulo a = new Articulo();
                a.setIdArticulo(rs.getString("idArticulo"));
                a.setNombre(rs.getString("nombre"));
                a.setPrecio(rs.getString("precio"));
                a.setCategoria(rs.getString("categoria"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setTiempoMaximoEntrega(rs.getString("tiempoMaximoEntrega"));
                data.add(a);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FilteredList<Articulo> filteredData = new FilteredList<>(data, p -> true);
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
                } else if (cliente.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });
        
        SortedList<Articulo> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
        
    }  
        
          
    
}
