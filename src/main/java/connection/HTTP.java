package connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author Anderson Xavier
 *
 * Classe contendo os métodos: connect - responsável por efetuar a conexão com o
 * site IMDb. disconnect - responsável por efetuar a desconexão com o site IMDb.
 *
 */
public class HTTP implements HTTPInterface {

    /**
     * Método responsável por efetuar a conexão com o site.
     *
     * @param url - Recebe o endereço URL para efetuar a conexão.
     * @return Retorna um objeto HttpURLConnection contendo a conexão criada.
     */
    @Override
    public HttpURLConnection connect(URL url) {
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setReadTimeout(10000);

            connection.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * Método responsável por efetuar a desconexão com o site.
     *
     * @param connection - Recebe o objeto HttpURLConnection contendo a conexão
     * a ser desconectada.
     * @return true - caso a desconexão seja efetuada com sucesso. false - caso
     * a desconexão falhe.
     */
    @Override
    public boolean disconnect(HttpURLConnection connection) {

        try {
            System.out.println("Efetuando desconexão com o site...");
            connection.disconnect();
            connection = null;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
