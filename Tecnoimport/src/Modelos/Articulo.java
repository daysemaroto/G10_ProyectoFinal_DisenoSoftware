/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dayse Maroto
 */
public class Articulo {
    private SimpleStringProperty idArticulo = new SimpleStringProperty();
    private SimpleStringProperty nombre = new SimpleStringProperty();
    private SimpleStringProperty categoria = new SimpleStringProperty();
    private SimpleStringProperty descripcion = new SimpleStringProperty();
    private SimpleStringProperty precio = new SimpleStringProperty();
    private SimpleStringProperty tiempoMaximoEntrega = new SimpleStringProperty();

    public String getIdArticulo() {
        return idArticulo.get();
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = new SimpleStringProperty(idArticulo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria = new SimpleStringProperty(categoria);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public String getPrecio() {
        return precio.get();
    }

    public void setPrecio(String precio) {
        this.precio = new SimpleStringProperty(precio);
    }

    public String getTiempoMaximoEntrega() {
        return tiempoMaximoEntrega.get();
    }

    public void setTiempoMaximoEntrega(String tiempoMaximoEntrega) {
        this.tiempoMaximoEntrega = new SimpleStringProperty(tiempoMaximoEntrega);
    }
    
    
}
