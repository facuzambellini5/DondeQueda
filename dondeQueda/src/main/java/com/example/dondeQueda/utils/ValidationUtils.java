package com.example.dondeQueda.utils;

import com.example.dondeQueda.exceptions.EntityNotFoundException;

import java.util.Optional;

public class ValidationUtils {

    public static <T> T validateEntity(Optional<T> entity, String entityName, Long entityId ){
         return entity.orElseThrow(() -> new EntityNotFoundException(entityName,entityId));
    }
}
