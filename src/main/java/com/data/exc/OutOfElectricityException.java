package com.data.exc;

public class OutOfElectricityException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Check The electricity switch please";
    }
}
