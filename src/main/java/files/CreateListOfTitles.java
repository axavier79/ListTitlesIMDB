package files;

import support.Files;

/**
 *
 * @author Anderson Xavier
 * 
 * Classe contendo o método:
 * createTitlesList - Responsável por chamar o método que criará o arquivo
 * contendo a lista de títulos de filmes do site IMDb.
 */
public class CreateListOfTitles {
    
    /**
     * Método responsável por chamar o método que criará o arquivo com a lista 
     * de títulos.
     * @param listPath - Recebe um String contendo o endereço da pasta onde
     * o arquivo gerado será gravado.
     * @param fileToBeRead - Recebe um String contendo o nome do arquivo que 
     * será lido.
     * @param listName - Recebe um String contendo o nome com o qual o 
     * arquivo com a lista de títulos será gravado.
     * @param region - Recebe um String com a região (ex.: "US") que será 
     * filtrada para capturar os nomes dos títulos.
     * 
     */
    public void createTitlesList(
            String listPath, 
            String fileToBeRead,
            String listName,
            String region){
        
        Files files = new Files();
        
        System.out.println("Filtrando a lista...");
        files.readFile(
                listPath, 
                fileToBeRead, 
                listName, 
                region);
    }
}
