package support;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson Xavier
 *
 * Classe contendo os métodos: createFile - Método responsável por criar um
 * arquivo de texto. readFileAndCaptureMovieTitles - Método responsável por ler
 * o conteúdo de um arquivo informado e filtrar os títulos de acordo com a
 * região informada. deleteFile - Método responsável por excluir um arquivo
 * específico.
 */
public class Files implements FilesInterface {

    /**
     * Método responsável por criar um arquivo de texto.
     *
     * @param filePath - Recebe um String contendo o endereço da pasta onde o
     * arquivo será gravado.
     * @param fileName - Recebe um String contendo o nome com o qual o arquivo
     * será gravado.
     * @param text - Recebe um String com o texto que será gravado no arquivo.
     * @param isNewLine - true: Será criada uma nova linha no arquivo. false:
     * Não será criada uma nova linha no arquivo.
     *
     */
    public void createFile(
            String filePath,
            String fileName,
            String text,
            boolean isNewLine) {

        File dir = new File(filePath);
        File fileLog = new File(filePath + fileName);
        FileWriter out = null;

        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (!fileLog.exists()) {
            try {
                fileLog.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            out = new FileWriter(fileLog, true); //true É PARA SEMPRE INCLUIR UMA NOVA LINHA QUANDO O ARQUIVO FOR UTILIZADO
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter writer = new BufferedWriter(out);

        try {
            writer.write(text);
            if (isNewLine) {
                writer.newLine();
            }
            writer.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método responsável por ler o conteúdo de um arquivo.
     *
     * @param filePath - Recebe um String contendo o endereço da pasta onde o
     * arquivo gerado será gravado.
     * @param fileToBeRead - Recebe um String contendo o nome do arquivo que
     * será lido.
     * @param titleFileName - Recebe um String contendo o nome com o qual o
     * arquivo om a lista de títulos será gravado.
     * @param regionToCapture - Recebe um String com a região (ex.: "US") que
     * será filtrada para capturar os nomes dos títulos.
     *
     */
    public void readFile(
            String filePath,
            String fileToBeRead,
            String titleFileName,
            String regionToCapture) {

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        File titleFile = new File(filePath + titleFileName);
        
        if (titleFile.exists()) {
            titleFile.delete();
        }

        try {
            fileReader = new FileReader(filePath + fileToBeRead);

            bufferedReader = new BufferedReader(fileReader);

            String linha = "";

            createFile(filePath, titleFileName, "titles", true);

            int contador = 1;

            while ((linha = bufferedReader.readLine()) != null) {
                
                captureMovieTitle(
                        linha, 
                        regionToCapture, 
                        filePath, 
                        titleFileName);
                
                contador++;
                if (contador % 50000 == 0){
                    System.out.println("Status: Filtrando...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /**
     * Método responsável filtrar os títulos de acordo com a região informada e
     * gravar em um arquivo.
     *
     * @param linha Recebe um String contendo a linha que foi capturada em um 
     * arquivo.
     * @param regionToCapture - Recebe um String com a região (ex.: "US") que
     * será filtrada para capturar os nomes dos títulos.
     * @param filePath - Recebe um String contendo o endereço da pasta onde o
     * arquivo gerado será gravado.
     * @param titleFileName - Recebe um String contendo o nome com o qual o
     * arquivo om a lista de títulos será gravado.
     *
     */
    public void captureMovieTitle(
            String linha,
            String regionToCapture,
            String filePath,
            String titleFileName) {
        
        String title = "";
        String region = "";
        
        try {
            region = linha.split("\t")[3];
            if (region.equalsIgnoreCase(regionToCapture)) {
                title = linha.split("\t")[2];
                createFile(filePath, titleFileName, title, true);
            }
        } catch (Exception e) {
            System.out.println("Status: Fim do arquivo.");
        }
    }

    /**
     * Método responsável por excluir um arquivo específico.
     *
     * @param filePath - Recebe um String com o caminho do arquivo a ser
     * excluído.
     * @param fileName - Recebe um String com o nome do arquivo a ser excluído.
     */
    @Override
    public void deleteFile(String filePath, String fileName) {
        File fileToDelete = new File(filePath, fileName);

        System.out.println("Status: Excluindo arquivo baixado do site...");
        if (fileToDelete.exists()) {
            fileToDelete.delete();
            System.out.println("Status: Arquivo excluído com sucesso!");
        }
    }

}
