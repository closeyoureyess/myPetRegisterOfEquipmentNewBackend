package com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.handler;

import com.registerofequipment.petRegisterOfEquipment.others.exeptions.MainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class HandlerException {

    private static final Logger logger = Logger.getLogger(HandlerException.class.getName());

    @ExceptionHandler(MainException.class)
    public ResponseEntity<String> handlerCustomExceptions(MainException mainException){
        logger.log(Level.SEVERE, mainException.getMessage(), mainException);
        return ResponseEntity.internalServerError().body(mainException.getCause().toString());
    }

}
