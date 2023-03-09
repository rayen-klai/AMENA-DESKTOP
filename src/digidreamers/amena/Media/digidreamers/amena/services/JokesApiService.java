/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digidreamers.amena.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;

/**
 *
 * @author Ahlem
 */
public class JokesApiService {

    // private String urlString = "https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random";
    public JokesApiService() {
    }

    public String getRandomJokes() throws Exception {
        /* List<Joke> list = new ArrayList<Joke>();
        
      

        return response.toString();*/

        URL url = new URL("https://v2.jokeapi.dev/joke/Any?type=single");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("accept", "application/json");
          InputStream responseStream = con.getInputStream();
        String jsonResponse = new BufferedReader(new InputStreamReader(responseStream))
            .lines().collect(Collectors.joining("\n"));
        JSONObject jsonObject = new JSONObject(jsonResponse);

        // Extract the image URL from the API response
        String imageUrl = jsonObject.getString("joke");
     

        return imageUrl;
    }

}
