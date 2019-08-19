/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Patron_Singleton.ConexionADB;
import Modelos.Usuario;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Maykel
 */
public class updateUsersController extends Main implements Initializable {

    @FXML
    private ImageView regresar;
    @FXML
    private TextField txtCedula;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField txtNomUsuario;
    @FXML
    private TextField txtApellUser;
    @FXML
    private CheckBox checkWhatsapp;
    @FXML
    private CheckBox checkDisponibilidad;
    @FXML
    private TextField txtTelfUser;
    @FXML
    private TextField txtEmailUser;
    @FXML
    private TextField txtDireccUser;
    @FXML
    private TextField txtCedulaUser;
    @FXML
    private TextField txtMatricUser;
    @FXML
    private Button btnUpdateUsers;

    private Usuario userToUpdate;
    @FXML
    private TextField txtPerfil;

    static private String cedulaSeleccionada;
    private final windowManagement wm = new windowManagement();

    public static String getCedulaSeleccionada() {
        return cedulaSeleccionada;
    }

    public static void setCedulaSeleccionada(String cedulaSeleccionada) {
        updateUsersController.cedulaSeleccionada = cedulaSeleccionada;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (cedulaSeleccionada != null) {
            userToUpdate = realizarConsulta(cedulaSeleccionada);
            try {
                mostrarAlertaUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public Usuario realizarConsulta(String ced) {

        return Usuario.generarUserSQL(ced, ConexionADB.getConexion_DB());

    }

    @FXML
    private void ManejadorBuscar(ActionEvent event) throws SQLException {

        userToUpdate = realizarConsulta(txtCedula.getText().trim());
        mostrarAlertaUsuario();

    }

    public void mostrarAlertaUsuario() throws SQLException {

        userToUpdate = Usuario.generarUserSQL(txtCedula.getText().trim(), ConexionADB.getConexion_DB());
        if (userToUpdate != null) {
            notifyManagement.showAlert("usuario encontrado exitosamente!!", Alert.AlertType.INFORMATION, "Buscar User");
            llenarDatos(userToUpdate);

        } else {
            notifyManagement.showAlert("usuario no encontrado, intenta de nuevo!!", Alert.AlertType.ERROR, "Buscar User");

        }
    }

    @FXML
    private void ManejadorUpdateUsers(ActionEvent event) throws SQLException {
        if (userToUpdate != null) {

            userToUpdate.setNombre(txtNomUsuario.getText());
            userToUpdate.setApellido(txtApellUser.getText());
            userToUpdate.setTelefono(txtTelfUser.getText());
            int rol;
            switch (txtPerfil.getText().toLowerCase().trim()) {
                case "administrador":
                    rol = 0;
                    break;
                case "vendedor":
                    rol = 1;
                    break;
                default:
                    rol = 2;
                    break;
            }

            userToUpdate.setRol(rol);
            userToUpdate.setHasWhatsapp(checkWhatsapp.isSelected());
            userToUpdate.setEmail(txtEmailUser.getText());
            userToUpdate.setDisponibilidad(checkDisponibilidad.isSelected());

            userToUpdate.setDireccion(txtDireccUser.getText());
            if (txtCedula.getText().isEmpty()) {
                notifyManagement.showAlert("Cedula no puede estar vacia", Alert.AlertType.ERROR, "Update user");
            }
            userToUpdate.setCedula(txtCedula.getText());
            userToUpdate.setMatricula(txtMatricUser.getText());

            Usuario.updateUsuario(ConexionADB.getConexion_DB(), userToUpdate);
            notifyManagement.showAlert("Usuario actualizado", Alert.AlertType.CONFIRMATION, "Update user");

        }
    }

    private void llenarDatos(Usuario userToUpdate) throws SQLException {
        txtNomUsuario.setText(userToUpdate.getNombre());
        txtApellUser.setText(userToUpdate.getApellido());
        txtTelfUser.setText(userToUpdate.getTelefono());
        String obtenerNameRol = Usuario.miRol(ConexionADB.getConexion_DB(), userToUpdate.getRol());
        txtPerfil.setText(obtenerNameRol);
        checkWhatsapp.setSelected(userToUpdate.isHasWhatsapp());
        checkDisponibilidad.setSelected(userToUpdate.isDisponibilidad());
        txtEmailUser.setText(userToUpdate.getEmail());
        txtDireccUser.setText(userToUpdate.getDireccion());
        txtCedulaUser.setText(userToUpdate.getCedula());
        txtMatricUser.setText(userToUpdate.getMatricula());

    }

    @FXML
    private void manejadorRegresar(MouseEvent event) {
        wm.changeWindow("adminUsers.fxml", event);

    }

}
