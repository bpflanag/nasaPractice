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
public class NasaPracticeService {

    public NasaPracticeResponse getNearEarthObjectsGivenDay(String day) {

        if (day == null || day.equals("")){
            throw new EmptyDateException();
        }

        String numberOfElements = callNasa(day);

        return new NasaPracticeResponse("There number of near earth objects for that day is: " + numberOfElements + "!");
    }

    public String callNasa(String day) {

        ObjectMapper objectMapper = new ObjectMapper();
        String apiKey = "DEMO_KEY";
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
            throw new NasaServiceException();
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
