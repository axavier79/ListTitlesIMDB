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
 */
public class IMDbTitlesFile {

    public void downloadIMDbTitlesFile(HttpURLConnection connection) {
        //Read the results from the server
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

            while (tamParte < data.length) {

                int read = GZInputStream.read(readBuffer, 0, tamParte);
                //Should hold the original (reconstructed) data
                byte[] result = Arrays.copyOf(readBuffer, read);
//                byte[] result = Arrays.copyOf(readBuffer, data.length);

                String message = new String(result, "UTF-8");

                files.createFile("files\\", "teste.txt", message, false);
//                System.out.println(tamParte);

                tamParte += tamParaLeitura;
            }
            GZInputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }
}