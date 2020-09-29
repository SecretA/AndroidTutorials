package com.example.retrofittutorial.Models;

public class BaseResponse<T> {
    private String response;
    private String status_message;
    private T data;

    public String getResponse() {
        return response;
    }

    public String getStatusMessage() {
        return status_message;
    }

    public T getData() {
        return data;
    }
}
