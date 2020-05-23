/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author axavi
 */
public class CreateListOfTitlesTest {
    
    public CreateListOfTitlesTest() {
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
     * Test of createTitlesList method, of class CreateListOfTitles.
     */
    @Test
    public void testCreateTitlesList() {
        System.out.println("createTitlesList");
        String listPath = "files\\";
        String fileToBeRead = "IMDBList.txt";
        String listName = "TitlesList.txt";
        String region = "US";
        CreateListOfTitles instance = new CreateListOfTitles();
        instance.createTitlesList(listPath, fileToBeRead, listName, region);
        // TODO review the generated test code and remove the default call to fail.
        fail("The createTitlesList test has failed.");
    }
    
}
