package connection;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author axavi
 */
public interface HTTPInterface {
    public HttpURLConnection connect(URL url);
    public boolean disconnect (HttpURLConnection connection);
}
