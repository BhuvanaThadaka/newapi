package com.rajlee.whatsappendpoint.service;

import com.rajlee.whatsappendpoint.dto.MessageBodyDTO;
import com.rajlee.whatsappendpoint.model.RequestMessage;
import com.rajlee.whatsappendpoint.model.RequestMessageText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiWhatsappService {

    private final RestClient restClient;

    @Autowired
    public ApiWhatsappService() {
        // Initialize RestClient
        restClient = RestClient.builder()
                .baseUrl("https://graph.facebook.com/v19.0/332775019927128/messages")
                .defaultHeader("Authorization", "Bearer EAAMEsvJdsScBO4VUVOPoWa2ZBw9nmKinip0pN4zzJZAEMUY31cZC567Aew3ZCoYswggDJ4ZBQLx6SrbhBJQw6HqsxGvi0qOusVQPoq4rc5Q7ZAHX2hlIB2MkMTOsZA6aEdF2vxvyoJmtbCV5eYTXFWpNc6z3IoeFsD4OT826p0bmDsoZCKE0eE9JaBTetZA8nJsJ98awQDEOVuy7YZAfalSw5dGF6Yfdz8M3kcGgEZD")
                .build();
    }

    public Map<String, Boolean> sendMessage(MessageBodyDTO payload) {
        Map<String, Boolean> messageStatusMap = new HashMap<>();

        List<String> numbers = payload.numbers();  // Assuming payload.numbers() returns a List<String>
        numbers.forEach(number -> {
            RequestMessage request = new RequestMessage("whatsapp", number, new RequestMessageText(payload.message()));

            try {
                String response = restClient.post()
                        .uri("")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(request)
                        .retrieve()
                        .body(String.class);  // Wait for the response

                // Assuming success based on response
                messageStatusMap.put(number, true); // Message sent successfully

            } catch (RestClientException ex) {
                // Log the error or handle it as needed
                System.err.println("Error sending message to " + number + ": " + ex.getMessage());
                messageStatusMap.put(number, false); // Message sending failed
            }
        });

        return messageStatusMap;
    }
}
