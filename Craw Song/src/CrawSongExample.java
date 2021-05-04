import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawSongExample {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            try {
                Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
                sc.useDelimiter("\\Z");
                String content = sc.next();

                sc.close();

                content = content.replaceAll("\n+", "");

                Pattern pattern = Pattern.compile("name_song\">(.*?)</a>");
                Matcher matcher = pattern.matcher(content);
                while (matcher.find()){
                    System.out.println(matcher.group(1));
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }



        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }


    }


}
