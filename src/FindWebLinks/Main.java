package FindWebLinks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.indexOf("youtube") >= 0) {
                int startIndex = line.indexOf("<a href=") + "<a href=".length();
                int endIndex = line.indexOf(">", startIndex + "<a href=".length());
                System.out.println(line.substring(startIndex, endIndex));
            }
        }
        reader.close();
    }
}
