/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
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
public class IniciarSesionControllerTest {
    
    public IniciarSesionControllerTest() {
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
     * Test of isNumeric method, of class IniciarSesionController.
     */
    @Test
    public void testTrueIsNumeric() {
        System.out.println("isNumeric");
        String strNum = "1458";
        assertTrue(IniciarSesionController.isNumeric(strNum));
    }
    
    @Test
    public void testFalseIsNumeric() {
        System.out.println("isNumeric");
        String strNum = "sadsd";
        assertFalse(IniciarSesionController.isNumeric(strNum));
    }
    
    
}
