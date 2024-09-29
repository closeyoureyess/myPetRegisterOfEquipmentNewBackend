package com.petregisterofequipmentnew.back.others.exeptions;

public class SortNotBeNullException extends MainException{
    public SortNotBeNullException(String message) {
        super(message);
    }

    public SortNotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortNotBeNullException(Throwable cause) {
        super(cause);
    }
}
