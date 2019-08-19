/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Singleton.Conectar;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Michelle
 */
public class Usuario {
    String user;
    String password;

    public Usuario(){
        
    }

    public Usuario(String user,String password){
        this.password=password;
        this.user=user;        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     private void getDatos(){
        String SQL_SELECT = "SELECT * FROM login where idUsuario=";
        String SQL_SELECT1 = "SELECT * FROM login where idUsuario=";
    }             
}
