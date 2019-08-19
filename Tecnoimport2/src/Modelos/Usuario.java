/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.updateUsersController;
import Modelos.Patron_Singleton.ConexionADB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Usuario {

    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String Email;
    protected String direccion;
    protected String cedula;
    protected String matricula;
    protected String user;
    protected String password;
    protected boolean hasWhatsapp;
    protected boolean disponibilidad;
    protected float saldo;

    protected int rol;

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", Email=" + Email + ", direccion=" + direccion + ", cedula=" + cedula + ", matricula=" + matricula + ", user=" + user + ", password=" + password + ", hasWhatsapp=" + hasWhatsapp + ", disponibilidad=" + disponibilidad + ", saldo=" + saldo + ", rol=" + rol + '}';
    }

    public static ArrayList<Usuario> BusquedaUser(String busqueda, Connection conexion) {
        ArrayList<Usuario> usuarios = new ArrayList();
        String sql = "select * from usuario where Cedula like ? ";
        PreparedStatement prepStat = null;
        ResultSet set = null;
        try {
            prepStat = conexion.prepareStatement(sql);
            prepStat.setString(1, "%" + busqueda + "%");
            set = prepStat.executeQuery();
            while (set.next()) {
                usuarios.add(setearUserSQL(new Usuario(), set));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConexionADB.closePS(prepStat);
            ConexionADB.closeRS(set);
        }

        return usuarios;
    }

    public static ArrayList<String> rolUsuarios(Connection conexion) {
        ArrayList<String> users = new ArrayList();
        String sql = "select Nombre_rol from rol ";
        PreparedStatement prepStat = null;
        ResultSet set = null;
        try {
            prepStat = conexion.prepareStatement(sql);

            set = prepStat.executeQuery();
            while (set.next()) {

                users.add(set.getString("Nombre_categoria"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConexionADB.closePS(prepStat);
            ConexionADB.closeRS(set);
        }

        return users;
    }

    private static Usuario setearUserSQL(Usuario user, ResultSet set) throws SQLException {
        user.setNombre(set.getString("Nombres"));
        user.setApellido(set.getString("Apellidos"));
        user.setEmail(set.getString("Email"));
        user.setTelefono(set.getString("Telefono"));
        user.setHasWhatsapp(set.getBoolean("whatsapp"));
        user.setDisponibilidad(set.getBoolean("Disponibilidad"));
        user.setDireccion(set.getString("Direccion"));
        user.setCedula(set.getString("Cedula"));
        return user;
    }

    public Usuario(String user, int rol) {
        this.user = user;
        this.rol = rol;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String telefono, String Email, String direccion, String cedula, String matricula, String user, String password, boolean hasWhatsapp, boolean disponibilidad, int rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.Email = Email;
        this.direccion = direccion;
        this.cedula = cedula;
        this.matricula = matricula;
        this.user = user;
        this.password = password;
        this.hasWhatsapp = hasWhatsapp;
        this.disponibilidad = disponibilidad;
        this.saldo = 0;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getUser() {
        return user;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
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

    public boolean isHasWhatsapp() {
        return hasWhatsapp;
    }

    public void setHasWhatsapp(boolean hasWhatsapp) {
        this.hasWhatsapp = hasWhatsapp;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public static Usuario generarUserLogin(String ID, Connection conexion) {
        String sql = "select * from Usuario where username = ?";
        PreparedStatement prepStat = null;
        Usuario u = null;
        ResultSet set = null;
        try {
            prepStat = conexion.prepareStatement(sql);
            prepStat.setString(1, ID);
            set = prepStat.executeQuery();
            if (set.next()) {
                int rol = set.getInt("Rol_idRol");
                u = setearUserSQL(u, set, rol);
            }
        } catch (SQLException e) {
            Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
           ConexionADB.closePS(prepStat);
            ConexionADB.closeRS(set);
        }

        return u;
    }

    public static String miRol(Connection conn, int id) {
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "{CALL miRol(?)}";
            stmt = conn.prepareCall(query);
            stmt.setInt("id", id);
            rs = stmt.executeQuery();
            String rol = "";
            if (rs.next()) rol = rs.getString("Nombre_rol");
            return rol;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionADB.closeCS(stmt);
            ConexionADB.closeRS(rs);
        }
        return null;
    }

    public static Usuario generarUserSQL(String ID, Connection conexion) {
        String sql = "select * from Usuario where Cedula = ?";
        PreparedStatement prepStat = null;
        Usuario u = null;
        ResultSet set = null;
        try {
            prepStat = conexion.prepareStatement(sql);
            prepStat.setString(1, ID);
            set = prepStat.executeQuery();
            if (set.next()) {
                int rol = set.getInt("Rol_idRol");
                u = setearUserSQL(u, set, rol);
            }
        } catch (SQLException e) {
            Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            ConexionADB.closePS(prepStat);
            ConexionADB.closeRS(set);    
        }
        return u;
    }

    private static Usuario setearUserSQL(Usuario user, ResultSet set, int rol) throws SQLException {
       Usuario userTmp=user;
        
        if (rol == 2) {
            //userTmp = new Vendedor();
        } else {
            userTmp = new Usuario();
        }
        userTmp.setApellido(set.getString("Apellidos"));
        userTmp.setCedula(set.getString("Cedula"));
        userTmp.setDireccion(set.getString("Direccion"));
        userTmp.setDisponibilidad(set.getBoolean("Disponibilidad"));
        userTmp.setEmail(set.getString("Email"));
        userTmp.setHasWhatsapp(set.getBoolean("whatsapp"));
        userTmp.setMatricula(set.getString("matricula"));
        userTmp.setNombre(set.getString("Nombres"));
        userTmp.setPassword(set.getString("password"));
        userTmp.setRol(rol);
        userTmp.setTelefono(set.getString("Telefono"));
        userTmp.setUser(set.getString("username"));
        userTmp.setSaldo(set.getFloat("saldo"));
        return userTmp;

    }
    
    public static void updateUsuario(Connection conn, Usuario usr) {
       CallableStatement stmt =null;
        try {
            String query = "{CALL updateUsuario(?,?,?,?,?,?,?,?,?,?,?)}";
             stmt = conn.prepareCall(query);
            stmt.setString("Cedula", usr.getCedula());
            stmt.setString("Nombres", usr.getNombre());
            stmt.setString("Apellidos", usr.getApellido());
            stmt.setString("Telefono", usr.getTelefono());
            stmt.setBoolean("whatsapp", usr.isHasWhatsapp());
            stmt.setString("Email", usr.getEmail());
            stmt.setString("Direccion", usr.getDireccion());
            stmt.setString("matricula", usr.getMatricula());
            stmt.setBoolean("Disponibilidad", usr.isDisponibilidad());
            stmt.setInt("Rol_idRol", usr.getRol());
            stmt.setString("username", usr.getUser());
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }    finally {
               ConexionADB.closeCS(stmt);
            }
    }
    
    public static boolean insertarUsuario(Connection conn, Usuario u) {
        CallableStatement stmt = null;

        String sql = "{CALL insertarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, u.getCedula());
            stmt.setString(2, u.getUser());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getNombre());
            stmt.setString(5, u.getApellido());
            stmt.setString(6, u.getTelefono());
            stmt.setBoolean(7, u.isHasWhatsapp());
            stmt.setString(8, u.getEmail());
            stmt.setString(9, u.getDireccion());
            stmt.setString(10, u.getMatricula());
            stmt.setBoolean(11, u.isDisponibilidad());
            stmt.setFloat(12, 0);
            stmt.setInt(13, u.getRol());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionADB.closeCS(stmt);
        }
        return true;
    }
    
    public static boolean elimUsuario(Connection conn, String ci) {
        PreparedStatement stmt = null;
        String sql = "UPDATE usuario SET Disponibilidad ='0' WHERE Cedula = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ci);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionADB.closePS(stmt);
        }
        return true;
    }
    
    public static boolean newRol(Connection conn, String name, int id) {

        String sql = "{CALL newRol(?,?)}";
        CallableStatement stmt = null;

        try {
            stmt = conn.prepareCall(sql);
            stmt.setInt("id", id);
            stmt.setString("nameRol", name);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(updateUsersController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConexionADB.closeCS(stmt);
        }

    }
    
    public static int userRol(Connection conn, String user) {
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "{CALL userRol(?)}";
            stmt = conn.prepareCall(query);
            stmt.setString("user1", user);
            rs = stmt.executeQuery();
            int rol = 0;
            if (rs.next()) {
                rol = rs.getInt("Rol_idRol");
            }
            return rol;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionADB.closeRS(rs); 
            ConexionADB.closeCS(stmt);
            }   
        return 0;

    }
    
    public static boolean loginSession(Connection conn, String user, String pass) {
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "{CALL loginSession(?,?)}";
            stmt = conn.prepareCall(query);
            stmt.setString("user1", user);
            stmt.setString("pass", pass);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionADB.closeRS(rs); 
            ConexionADB.closeCS(stmt);
        }
        return false;
    }
}
