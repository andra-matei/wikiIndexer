package service.tools;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by andmatei on 8/11/2016.
 */
public class WriteFileFromXML {
    public static void writeFileFromXML() {
        URL url = null; //Reading
        try {
            url = new URL("https://en.wikipedia.org/wiki/Special:Export?pages=Java");
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new FileWriter("fisierXML.txt"));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.write(inputLine);
                out.newLine();
            }
            in.close();
            out.close();

        } catch (MalformedURLException e) {
            System.err.println("malformedException");
        } catch (IOException e) {
            System.err.println("ioexception");
        }
    }
}
