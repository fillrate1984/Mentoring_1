package com.data.exc;

public class TurnedOffException extends RuntimeException {

    public TurnedOffException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Please turn on Appliances before use them.";
    }
}
