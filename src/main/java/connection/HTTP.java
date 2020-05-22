package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author axavi
 */
public class HTTP implements HTTPInterface {

    @Override
    public HttpURLConnection connect(URL url) {
        HttpURLConnection connection = null;

        try {
            // Set up the initial connection
            connection = (HttpURLConnection) url.openConnection();
            // Default is GET
            connection.setRequestMethod("GET");
            // Default is false, change it...
            connection.setDoOutput(true);
            // Default is infinity (0), this is in ms
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

    @Override
    public boolean disconnect(HttpURLConnection connection) {
        //close the connection, set all objects to null
        try {
            connection.disconnect();
            connection = null;
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

}
