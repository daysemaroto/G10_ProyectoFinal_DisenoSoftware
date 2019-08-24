/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.pattern_singleton;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhon_
 */
public class ConexionADBTest {
    
    public ConexionADBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexion_DB method, of class ConexionADB.
     */
    @Test
    public void testGetConexion_DB() {
        System.out.println("getConexion_DB");
        Connection expResult = ConexionADB.getConexion_DB();
        Connection result = ConexionADB.getConexion_DB();
        assertEquals(expResult, result);
        System.out.println("getConexion_DB Pass");
    }

    /**
     * Test of closePS method, of class ConexionADB.
     * @throws java.sql.SQLException
     */
    @Test
    public void testClosePS() throws SQLException {
        System.out.println("closePS");
        PreparedStatement stmt = ConexionADB.getConexion_DB().prepareStatement("select * from articulo order by idArticulo;");
        ConexionADB.closePS(stmt);
        System.out.println("closePS Pass");
    }

    /**
     * Test of closeCS method, of class ConexionADB.
     * @throws java.sql.SQLException
     */
    @Test
    public void testCloseCS() throws SQLException {
        System.out.println("closeCS");
        CallableStatement stmt = ConexionADB.getConexion_DB().prepareCall("select * from articulo order by idArticulo;");
        ConexionADB.closeCS(stmt);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("closeCS Pass");
    }

    /**
     * Test of closeRS method, of class ConexionADB.
     * @throws java.sql.SQLException
     */
    @Test
    public void testCloseRS() throws SQLException {
        System.out.println("closeRS");
        PreparedStatement stmt = ConexionADB.getConexion_DB().prepareStatement("select * from articulo order by idArticulo;");
        ResultSet rs = stmt.executeQuery();
        ConexionADB.closeRS(rs);
        System.out.println("closeRS Pass");
    }
    
}
