package com.kids.nasaPractice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class NasaPracticeDriverImpl implements NasaPracticeDriver {

    @Override
    public String callNasa(String day) {

        ObjectMapper objectMapper = new ObjectMapper();
        String apiKey = "Q4MgDER6sxynvJHw2S7RY7CqK233DoAkqNZCmHGR";
        String response;

        try {
            HttpURLConnection connection = null;
            URL url = new URL("https://api.nasa.gov/neo/rest/v1/feed?start_date=" + day + "&end_date=" + day + "&api_key=" + apiKey);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            response = content.toString();

            connection.disconnect();
        } catch (IOException e) {
            throw new NasaServiceDeadException();
        }

        JsonNode parent= null;
        try {
            parent = new ObjectMapper().readTree(response);
        } catch (IOException e) {
            // Handle this later
        }
        String numberOfElements = parent.get("element_count").asText();

        return numberOfElements;
    }
}
