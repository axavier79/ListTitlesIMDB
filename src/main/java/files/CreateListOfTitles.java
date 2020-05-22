package files;

import support.Files;

/**
 *
 * @author axavi
 */
public class CreateListOfTitles {
    
    public void createTitlesList(
            String listPath, 
            String fileToBeRead,
            String listName,
            String region){
        
        Files files = new Files();
        files.readFileAndCaptureMovieTitles(
                listPath, 
                fileToBeRead, 
                listName, 
                region);
    }
}
