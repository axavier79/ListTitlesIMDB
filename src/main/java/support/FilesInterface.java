package support;

/**
 *
 * @author Anderson Xavier
 * 
 * Interface para implementação dos métodos para criação de arquivo, leitura e
 * captura de informações em arquivo e exclusão de arquivo.
 */
public interface FilesInterface {
    public void createFile(
            String filePath,
            String fileName,
            String text,
            boolean isNewLine);
    
    public void readFile(
            String filePath, 
            String fileName,
            String fileToBeRead,
            String region);
    
    public void deleteFile(
            String filePath,
            String fileName);
}
