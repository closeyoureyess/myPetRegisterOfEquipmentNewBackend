package com.petregisterofequipmentnew.back.others.exeptions;

public class MainException extends Exception {

    public MainException(String message){
        super(message);
    }

    public MainException(String message, Throwable cause) {
        super(message, cause);
    }

    public MainException(Throwable cause) {
        super(cause);
    }
}
