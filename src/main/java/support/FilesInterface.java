package support;

/**
 *
 * @author axavi
 */
public interface FilesInterface {
    public void createFile(
            String filePath,
            String fileName,
            String text,
            boolean isNewLine);
    
    public void readFileAndCaptureMovieTitles(
            String filePath, 
            String fileName,
            String fileToBeRead,
            String region);
    
    public void deleteFile(
            String filePath,
            String fileName);
}
