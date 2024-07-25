package com.rajlee.whatsappendpoint.dto;


import java.util.List;

public record MessageBodyDTO(
        List<String> numbers,
        String message
) {

}
