package com.example.dondeQueda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String entityName, Long entityId){
        super(entityName + " con ID: '" + entityId + "' no se ha encontrado.");
    }
}
