import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.openweathermap.org/data/3.0/onecall?lat={33.886917}&lon={9.537499}&exclude={part}&appid={756951b40b2038d0e52cafe59874e435}";
        
        
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
/*
        con.setRequestProperty("X-RapidAPI-Key", "f9f9ac641fmsh005e11e939a5d43p126542jsnefe78068dce3");
            con.setRequestProperty("X-RapidAPI-Host", "motorcycle-specs-database.p.rapidapi.com");
*/
        
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response);
    }
}
        /*
        // Extract make names from the response and add them to an ArrayList
        ArrayList<String> makeNames = new ArrayList<>();
        String responseStr = response.toString();
        Pattern pattern = Pattern.compile("\\{\"id\":\\d+,\"name\":\"(\\w+)\"");
        Matcher matcher = pattern.matcher(responseStr);
        while (matcher.find()) {
            String makeName = matcher.group(1);
            makeNames.add(makeName);
        }

        // Print the make names
        System.out.println("Make Names:");
        for (String makeName : makeNames) {
            System.out.println(makeName);
        }
    }
}
*/