package org.alevel.lesson6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubEmojisTest {

    public static void main(String[] args) {

        String url = "https://api.github.com/emojis";


        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Перевірка, чи містить JSON в собі ключ 'articulated_lorry'
            String responseBody = response.body();
            boolean containsArticulatedLorry = responseBody.contains("articulated_lorry");


            if (containsArticulatedLorry) {
                System.out.println("Тест пройдено. Респонс містить ключ 'articulated_lorry'.");
            } else {
                System.out.println("Тест не пройдено. Респонс не містить ключ 'articulated_lorry'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
