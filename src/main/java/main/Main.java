package main;

import connection.HTTP;
import files.CreateListOfTitles;
import files.IMDbTitlesFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import support.Files;

/**
 *
 * @author Anderson Xavier - 22/05/2020
 *
 * Classe principal contendo o método:
 * main - responsável pelo fluxo de execução.
 *
 */
public class Main {

    /**
     * Método responsável pelo fluxo de execução.
     * 
     * @param args Args
     * 
     */
    public static void main(String[] args) {
        HTTP http = new HTTP();
        HttpURLConnection connection = null;
        String address = "https://datasets.imdbws.com/title.akas.tsv.gz";
        CreateListOfTitles createList = new CreateListOfTitles();
        String imdbListName = "IMDBList.txt";
        String titlesListName = "TitlesList.txt";
        String folderName = "files\\";
        String regionName = "US";
        Files fileToDelete = new Files();

        System.out.println("Status: Conectando ao site...");
        try {
            connection = http.connect(new URL(address));
            System.out.println("Status: Conectado.");
        } catch (MalformedURLException ex) {
            System.out.println("ERRO AO CONECTAR!");
            ex.printStackTrace();
        }

        System.out.println("Status: Iniciando o download do arquivo...");
        IMDbTitlesFile downloadFile = new IMDbTitlesFile();
        downloadFile.downloadIMDbTitlesFile(
                connection, 
                folderName,
                imdbListName);

        createList.createTitlesList(
                folderName,
                imdbListName,
                titlesListName,
                regionName);

        fileToDelete.deleteFile(folderName, imdbListName);
        
        JOptionPane.showMessageDialog(
                null,
                "Lista de títulos gerada na pasta do projeto, no arquivo: "
                + folderName + titlesListName,
                "CONCLUÍDO", 
                JOptionPane.INFORMATION_MESSAGE
        );
        
        if (http.disconnect(connection)) {
            System.out.println("Status: Desconectado!");
        } else {
            System.out.println("OCORRIDO ERRO AO DESCONECTAR");
        }

    }
}
