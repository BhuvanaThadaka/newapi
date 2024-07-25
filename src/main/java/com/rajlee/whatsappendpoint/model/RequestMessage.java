package com.rajlee.whatsappendpoint.model;

public record RequestMessage(
        String messaging_product,
        String to,
        RequestMessageText text
) {
}