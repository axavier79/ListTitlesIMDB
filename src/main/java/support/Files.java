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
 * @author yank.anderson
 */
public class Files implements FilesInterface{
    public static void main(String[] args) {
        String imdbListName = "IMDBList.txt";
        String titlesListName = "TitlesList.txt";
        String folderName = "files\\";
        String regionName = "US";
        
        Files files = new Files();
        files.readFileAndCaptureMovieTitles(
                folderName, 
                imdbListName, 
                titlesListName, 
                regionName);
    }

    public void createFile(
            String filePath,
            String fileName,
            String text,
            boolean isNewLine) {

        File dir = new File(filePath);
        File fileLog = new File(filePath + fileName);
        FileWriter out = null;

        if(!dir.exists()){
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

    public void readFileAndCaptureMovieTitles(
            String filePath,
            String fileToBeRead,
            String titleFileName,
            String regionToCapture) {
        
        String region = "";
        String title = "";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        File titleFile = new File(filePath + titleFileName);
//        int contLido = 1;
        int contGravado = 1;

        if (titleFile.exists()) {
            titleFile.delete();
        }

        try {
            //Indicamos o arquivo que será lido
            fileReader = new FileReader(filePath + fileToBeRead);

            //Criamos o objeto bufferReader que nos
            // oferece o método de leitura readLine()
            bufferedReader = new BufferedReader(fileReader);

            //String que irá receber cada linha do arquivo
            String linha = "";

            //Fazemos um loop linha a linha no arquivo,
            // enquanto ele seja diferente de null.
            //O método readLine() devolve a linha na
            // posicao do loop para a variavel linha.
            while ((linha = bufferedReader.readLine()) != null) {
                try {
                    //Capturar o título do filme
                    region = linha.split("\t")[3];
                    if (region.equalsIgnoreCase(regionToCapture)) {
                        title = linha.split("\t")[2];
                        createFile(filePath, titleFileName, title + "\n", true);
                        System.out.println("Gravado: " + contGravado);
                        contGravado++;
                    }
//                    System.out.println("Lido: " + contLido);
//                    contLido++;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //liberamos o fluxo dos objetos ou fechamos o arquivo
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

    @Override
    public void deleteFile(String filePath, String fileName) {
        File fileToDelete = new File(filePath, fileName);
        
        if(!fileToDelete.exists()){
            fileToDelete.delete();
        }
    }

}
