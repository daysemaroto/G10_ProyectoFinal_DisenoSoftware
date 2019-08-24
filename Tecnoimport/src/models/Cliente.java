/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dayse Maroto
 */
public class Cliente {
    private SimpleStringProperty nombre = new SimpleStringProperty();
    private SimpleStringProperty apellido = new SimpleStringProperty();
    private SimpleStringProperty idCliente = new SimpleStringProperty();
    private SimpleStringProperty edad = new SimpleStringProperty();
    private SimpleStringProperty telefono = new SimpleStringProperty();
    private SimpleStringProperty email = new SimpleStringProperty();
    private SimpleStringProperty direccion = new SimpleStringProperty();

    public String getNombre() {
        return nombre.get();
    }

    public String getApellido() {
        return apellido.get();
    }

    public String getIdCliente() {
        return idCliente.get();
    }

    public String getEdad() {
        return edad.get();
    }

    public String getTelefono() {
        return telefono.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public void setIdCliente(String idCliente) {
        this.idCliente.set(idCliente);
    }

    public void setEdad(String edad) {
        this.edad.set(edad);
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }
    
    
    
    
}
