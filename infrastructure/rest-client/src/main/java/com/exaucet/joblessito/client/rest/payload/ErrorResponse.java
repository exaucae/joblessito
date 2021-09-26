package com.exaucet.joblessito.client.rest.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String errorCode;
    private String details;
    private String nextActions;

    public ErrorResponse(String message, String reasonPhrase) {
        this.message = message;
        this.errorCode = reasonPhrase;
    }
}
