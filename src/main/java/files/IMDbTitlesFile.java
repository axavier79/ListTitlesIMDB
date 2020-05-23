package files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import support.Files;

/**
 *
 * @author Anderson Xavier
 * 
 * Classe contendo o método:
 * downloadIMDbTitlesFile - responsável por efetuar o download do 
 * arquivo title.akas.tsv.gz dosite IMDb.
 * 
 */
public class IMDbTitlesFile {

    /**
     * Método responsável por efetuar o download do arquivo 
     * title.akas.tsv.gz dosite IMDb.
     * @param connection - Recebe um objeto HttpURLConnection contendo a conexão
     * com o site IMDb.
     * @param folderName - Recebe um String contendo o endereço da pasta onde
     * o arquivo baixado será gravado.
     * @param imdbListName - Recebe um String contendo o nome com o qual o 
     * arquivo será gravado.
     * 
     */
    public void downloadIMDbTitlesFile(
            HttpURLConnection connection,
            String folderName,
            String imdbListName) {

        int tamanhoTotal = 400000000; //cerca de 400MB
        int tamParaLeitura = 1500; //cerca de 1,5MB
        int tamParte = tamParaLeitura;
        Files files = new Files();

        try {
            InputStream in = connection.getInputStream();

            byte[] buff = new byte[tamanhoTotal];

            int bytesRead = 0;

            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            while ((bytesRead = in.read(buff)) != -1) {
                bao.write(buff, 0, bytesRead);
            }

            byte[] data = bao.toByteArray();

            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(data);
            byte[] readBuffer = new byte[tamanhoTotal];
            GZIPInputStream GZInputStream;

            GZInputStream = new GZIPInputStream(arrayInputStream);

            System.out.println("Status: Iniciando descompactação do arquivo...");
            int contador = 1;
            while (tamParte < data.length) {
                
                int read = GZInputStream.read(readBuffer, 0, tamParte);

                byte[] result = Arrays.copyOf(readBuffer, read);
//                byte[] result = Arrays.copyOf(readBuffer, data.length);

                String message = new String(result, "UTF-8");

                files.createFile(folderName, imdbListName, message, false);

                tamParte += tamParaLeitura;
                
                contador++;
                if (contador % 50000 == 0){
                    System.out.println("Status: Descompactando...");
                }
            }
            GZInputStream.close();
            System.out.println("Status: Descompactação concluída.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
