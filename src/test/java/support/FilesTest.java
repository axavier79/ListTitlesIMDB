package support;

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
public class FilesTest {
    
    public FilesTest() {
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
     * Test of createFile method, of class Files.
     */
    @Test
    public void testCreateFile() {
        System.out.println("createFile");
        String filePath = "";
        String fileName = "";
        String text = "";
        boolean isNewLine = false;
        Files instance = new Files();
        instance.createFile(filePath, fileName, text, isNewLine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFileAndCaptureMovieTitles method, of class Files.
     */
    @Test
    public void testReadFileAndCaptureMovieTitles() {
        System.out.println("readFileAndCaptureMovieTitles");
        String filePath = "";
        String fileToBeRead = "";
        String titleFileName = "";
        String regionToCapture = "";
        Files instance = new Files();
        instance.readFile(filePath, fileToBeRead, titleFileName, regionToCapture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFile method, of class Files.
     */
    @Test
    public void testDeleteFile() {
        System.out.println("deleteFile");
        String filePath = "";
        String fileName = "";
        Files instance = new Files();
        instance.deleteFile(filePath, fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
