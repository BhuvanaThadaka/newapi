package com.rajlee.whatsappendpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppRequest {
    private List<String> phoneNumbers;
    private String message;
}
