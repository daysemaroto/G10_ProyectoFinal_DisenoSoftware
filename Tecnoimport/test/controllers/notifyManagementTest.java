/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.control.Alert;
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
public class notifyManagementTest {
    
    public notifyManagementTest() {
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
     * Test of notifDefaul method, of class notifyManagement.
     */
    @Test
    public void testNotifDefaul() {
        System.out.println("notifDefaul");
        String mensaje = "";
        String titulo = "";
        notifyManagement.notifDefaul(mensaje, titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifYesNo method, of class notifyManagement.
     */
    @Test
    public void testNotifYesNo() {
        System.out.println("notifYesNo");
        String mensaje = "";
        String titulo = "";
        int expResult = 0;
        int result = notifyManagement.notifYesNo(mensaje, titulo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAlert method, of class notifyManagement.
     */
    @Test
    public void testShowAlert() {
        System.out.println("showAlert");
        String msj = "";
        Alert.AlertType tipo = null;
        String title = "";
        notifyManagement.showAlert(msj, tipo, title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
