package com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions;

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
