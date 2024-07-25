package com.rajlee.whatsappendpoint.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rajlee.whatsappendpoint.dto.MessageBodyDTO;
import com.rajlee.whatsappendpoint.service.ApiWhatsappService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class WhatsappController {

    @Autowired
    private ApiWhatsappService apiWhatsappService;


    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageBodyDTO payload) {
        try{
            apiWhatsappService.sendMessage(payload);
        }catch (Exception ex){
            ex.printStackTrace();;
        }
    }



//    @PostMapping("/send-messages")
//    public List<ResponseWhatsapp> sendMessagesToMultipleUsers(@RequestBody List<MessageBodyDTO> payloads) {
//        return sendMessagesToMultipleUsers(payloads);
//    }
//
//    private List<ResponseWhatsapp> sendMessagesToMultipleUsers(List<MessageBodyDTO> payloads) {
//        List<ResponseWhatsapp> responses = new ArrayList<>();
//
//        WebClient webClient = WebClient.builder()
//                .baseUrl("https://graph.facebook.com/v19.0/")
//                .build();
//
//        for (MessageBodyDTO payload : payloads) {
//            RequestMessage request = new RequestMessage("whatsapp", payload.getNumber(), new RequestMessageText(payload.getMessage()));
//
//            WebClient.ResponseSpec responseSpec = webClient.post()
//                    .uri("332775019927128/messages")
//                    .header("Authorization", "Bearer EAAMEsvJdsScBO0byVS7Dgn5P3OSL0R98ojZA00uTGnlfc8CixKQAZA4LoL3nlUaE2u67T1pifuKs184XCXflTZAuzFnHDGgBXVCDrAOy9dRNo9kUyZAXg4dhlgLjdDZAZADupVZACZBXw9nRwH8zsawUqSyZApgBolSDMUsk6o5iC36kbo05xbB2XaU1liF9fpltywPwFBjlzdUtl2No6mlatKEVACl3xAJNxMNwZD")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .bodyValue(request);
//
//            String response = responseSpec.bodyToMono(String.class).block();
//
//            ObjectMapper obj = new ObjectMapper();
//            ResponseWhatsapp responseWhatsapp = null;
//            try {
//                responseWhatsapp = obj.readValue(response, ResponseWhatsapp.class);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//            responses.add(responseWhatsapp);
//        }
//
//        return responses;
//    }

//    @PostMapping("/send-messages")
//    public List<ResponseWhatsapp> sendMessagesToMultipleUsers(@RequestBody WhatsAppRequest request) {
//        List<String> phoneNumber = request.getPhoneNumber();
//        String message = request.getMessage();
//        return apiWhatsappService.sendMessagesToMultipleUsers(phoneNumber, message);
//    }


//    @PostMapping("/send-messages")
//    public ResponseEntity<List<ResponseWhatsapp>> sendMessagesToMultipleUsers(@RequestBody MessageBodyDTO payload) {
//        List<ResponseWhatsapp> responses = apiWhatsappService.sendMessagesToMultipleUsers(payload);
//        return ResponseEntity.ok(responses);
//    }
}
