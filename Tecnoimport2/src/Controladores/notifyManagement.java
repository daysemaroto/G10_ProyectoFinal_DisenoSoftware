/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 * 
 * Clase encargada de mostrar notificaciones de eventos importantes durante la ejecucion del sistema
 * 
 */
public class notifyManagement {
    
    public static void notifDefaul(String mensaje, String titulo){
        JOptionPane.showConfirmDialog(null,mensaje, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION);     
    }
    
    public static int notifYesNo(String mensaje, String titulo){
        return JOptionPane.showConfirmDialog(null,mensaje , titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void showAlert(String msj, Alert.AlertType tipo, String title) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(title);
        alerta.setContentText(msj);
        alerta.showAndWait();

    }
    
}
