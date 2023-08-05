package org.bolshakovk.registrationServer.responses;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageResponse {
    String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
