package com.rajlee.whatsappendpoint.model;

import java.util.List;

public record MultipleUsersMessageRequest(
        List<String> phoneNumbers,
        String message

) {
}
