package com.data.exc;

public class NetOverloadException extends Exception {
    @Override
    public String getMessage() {
        return "Don't use too much Appliances";
    }
}
