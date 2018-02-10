package com.infoshareacademy.api;

public class ErrorResponse {

    private Error error;

    public ErrorResponse() {
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
