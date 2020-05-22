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
    public void readFileAndCaptureUSMovieTitles(
            String filePath, 
            String fileName);
}
