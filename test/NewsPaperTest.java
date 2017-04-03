/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rutul
 */
public class NewsPaperTest {
    
    public NewsPaperTest() {
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
     * Test of getName method, of class NewsPaper.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        NewsPaper instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class NewsPaper.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        NewsPaper instance = null;
        int expResult = 0;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeadline method, of class NewsPaper.
     */
    @Test
    public void testGetHeadline() {
        System.out.println("getHeadline");
        NewsPaper instance = null;
        String expResult = "";
        String result = instance.getHeadline();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParser method, of class NewsPaper.
     */
    @Test
    public void testGetParser() {
        System.out.println("getParser");
        NewsPaper instance = null;
        Parser expResult = null;
        Parser result = instance.getParser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
