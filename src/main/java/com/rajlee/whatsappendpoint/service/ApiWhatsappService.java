package com.rajlee.whatsappendpoint.service;


import com.rajlee.whatsappendpoint.dto.MessageBodyDTO;
import com.rajlee.whatsappendpoint.model.RequestMessage;
import com.rajlee.whatsappendpoint.model.RequestMessageText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;


@Service
public class ApiWhatsappService {

    private final RestClient restClient;

    @Autowired
    public ApiWhatsappService() {
        restClient = RestClient.builder()
                .baseUrl("https://graph.facebook.com/v19.0/332775019927128/messages")
                .defaultHeader("Authorization", "Bearer EAAMEsvJdsScBO4VUVOPoWa2ZBw9nmKinip0pN4zzJZAEMUY31cZC567Aew3ZCoYswggDJ4ZBQLx6SrbhBJQw6HqsxGvi0qOusVQPoq4rc5Q7ZAHX2hlIB2MkMTOsZA6aEdF2vxvyoJmtbCV5eYTXFWpNc6z3IoeFsD4OT826p0bmDsoZCKE0eE9JaBTetZA8nJsJ98awQDEOVuy7YZAfalSw5dGF6Yfdz8M3kcGgEZD")
                .build();
    }

    public void sendMessage(MessageBodyDTO payload) {
        List<String> numbers = payload.numbers();
        numbers.forEach(number -> {
            RequestMessage request = new RequestMessage("whatsapp", number, new RequestMessageText(payload.message()));
            try {
                String response = restClient.post()
                        .uri("")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(request)
                        .retrieve()
                        .body(String.class);

            } catch (Exception ex) {
                throw new RestClientResponseException("Error in sending message", 400, "Error in sending message", null, null, null);
            }
        });
    }
}