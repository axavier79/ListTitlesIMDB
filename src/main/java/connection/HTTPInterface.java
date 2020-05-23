package connection;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Anderson Xavier
 * 
 * Interface para implementação dos métodos de conexão e desconexão com o site IMDb.
 */
public interface HTTPInterface {
    public HttpURLConnection connect(URL url);
    public boolean disconnect (HttpURLConnection connection);
}
