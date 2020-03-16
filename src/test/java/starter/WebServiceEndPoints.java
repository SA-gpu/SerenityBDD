package starter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebServiceEndPoints {

    public static String URI, post, get, update, delete;

    public static void getConfig() {
        try (InputStream input = starter.WebServiceEndPoints.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
            URI= prop.getProperty("BaseURI");
            post= prop.getProperty("Post");
            get= prop.getProperty("Get");
            update= prop.getProperty("Update");
            delete= prop.getProperty("Delete");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
