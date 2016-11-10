package com.wimso.androidloginandregistration.model;

/**
 * Created by Wim on 11/4/16.
 */
public class BaseResponse {

    private boolean error;
    private String message;

    public BaseResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
