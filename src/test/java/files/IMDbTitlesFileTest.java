/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import connection.HTTP;
import connection.HTTPTest;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class IMDbTitlesFileTest {
    
    public IMDbTitlesFileTest() {
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
     * Test of downloadIMDbTitlesFile method, of class IMDbTitlesFile.
     */
    @Test
    public void testDownloadIMDbTitlesFile() {
        System.out.println("downloadIMDbTitlesFile");
        
        URL url = null;
        try {
            url = new URL("https://datasets.imdbws.com/title.akas.tsv.gz");
        } catch (MalformedURLException ex) {
            Logger.getLogger(HTTPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpURLConnection connection = new HTTP().connect(url);
        String folderName = "files\\";
        String imdbListName = "IMDBList.txt";
        IMDbTitlesFile instance = new IMDbTitlesFile();
        instance.downloadIMDbTitlesFile(connection, folderName, imdbListName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The downloadIMDbTitlesFile has failed.");
    }
    
}
