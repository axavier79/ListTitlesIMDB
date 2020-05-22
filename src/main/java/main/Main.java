package main;

import connection.HTTP;
import files.IMDbTitlesFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axavier
 */
public class Main {
    public static void main(String[] args) {
        HTTP http = new HTTP();
        HttpURLConnection connection = null;
        String address = "https://datasets.imdbws.com/title.akas.tsv.gz";
        
        try {
            connection = http.connect(new URL(address));
            System.out.println("Conectou!");
        } catch (MalformedURLException ex) {
            System.out.println("ERRO AO CONECTAR!");
            ex.printStackTrace();
        }
        
        IMDbTitlesFile downloadFile = new IMDbTitlesFile();
        downloadFile.downloadIMDbTitlesFile(connection);
        
        
        
        if(http.disconnect(connection)){
            System.out.println("Desconectou!");
        } else {
            System.out.println("OCORRIDO ERRO AO DESCONECTAR");
        }
        
    }
}
