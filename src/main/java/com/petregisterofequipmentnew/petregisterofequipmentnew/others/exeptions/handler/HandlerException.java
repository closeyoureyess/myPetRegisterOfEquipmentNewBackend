package com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.handler;

import com.petregisterofequipmentnew.petregisterofequipmentnew.others.exeptions.MainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class HandlerException {

    @ExceptionHandler(MainException.class)
    public ResponseEntity<String> handlerCustomExceptions(MainException mainException){
        log.error(mainException.getMessage(), mainException);
        return ResponseEntity.internalServerError().body(mainException.getCause().toString());
    }

}
