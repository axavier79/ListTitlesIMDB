package connection;

import java.io.IOException;
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
public class HTTPTest {
    
    public HTTPTest() {
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
     * Test of connect method, of class HTTP.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        URL url = null;
        try {
            url = new URL("https://datasets.imdbws.com/title.akas.tsv.gz");
        } catch (MalformedURLException ex) {
            Logger.getLogger(HTTPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpURLConnection expResult = new HTTP().connect(url);
        HTTP instance = new HTTP();
        HttpURLConnection result = instance.connect(url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The connect test has failed.");
    }

    /**
     * Test of disconnect method, of class HTTP.
     */
    @Test
    public void testDisconnect() {
        System.out.println("disconnect");
        URL url = null;
        try {
            url = new URL("https://datasets.imdbws.com/title.akas.tsv.gz");
        } catch (MalformedURLException ex) {
            Logger.getLogger(HTTPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpURLConnection connection = new HTTP().connect(url);
        HTTP instance = new HTTP();
        boolean expResult = true;
        boolean result = instance.disconnect(connection);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The disconnect test has failed.");
    }
    
}
