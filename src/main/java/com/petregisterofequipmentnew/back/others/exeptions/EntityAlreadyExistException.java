package com.petregisterofequipmentnew.back.others.exeptions;

public class EntityAlreadyExistException extends MainException{
    public EntityAlreadyExistException(String message) {
        super(message);
    }

    public EntityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
