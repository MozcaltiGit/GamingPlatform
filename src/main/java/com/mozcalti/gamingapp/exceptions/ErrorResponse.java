package com.mozcalti.gamingapp.exceptions;


import lombok.Getter;

@Getter
public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private String timestamp;

    public ErrorResponse(int status, String error, String message, String timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }
}