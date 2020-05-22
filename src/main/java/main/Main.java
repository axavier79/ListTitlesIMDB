package main;

import connection.HTTP;
import files.CreateListOfTitles;
import files.IMDbTitlesFile;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import support.Files;

/**
 *
 * @author Anderson Xavier - 22/05/2020
 *
 */
public class Main {

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

        try {
            connection = http.connect(new URL(address));
            System.out.println("Conectou!");
        } catch (MalformedURLException ex) {
            System.out.println("ERRO AO CONECTAR!");
            ex.printStackTrace();
        }

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
        
        if (http.disconnect(connection)) {
            System.out.println("Desconectou!");
        } else {
            System.out.println("OCORRIDO ERRO AO DESCONECTAR");
        }

    }
}
