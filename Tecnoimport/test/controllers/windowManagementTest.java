/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.event.Event;
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
public class windowManagementTest {
    
    public windowManagementTest() {
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
     * Test of changeWindow method, of class windowManagement.
     */
    @Test
    public void testChangeWindow() {
        System.out.println("changeWindow");
        String route = "";
        Event event = null;
        windowManagement instance = new windowManagement();
        instance.changeWindow(route, event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeFloatingWindow method, of class windowManagement.
     */
    @Test
    public void testCloseFloatingWindow() {
        System.out.println("closeFloatingWindow");
        Event event = null;
        windowManagement instance = new windowManagement();
        instance.closeFloatingWindow(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarVentanaFlotante method, of class windowManagement.
     */
    @Test
    public void testMostrarVentanaFlotante() {
        System.out.println("mostrarVentanaFlotante");
        String ventana = "";
        windowManagement instance = new windowManagement();
        instance.mostrarVentanaFlotante(ventana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
