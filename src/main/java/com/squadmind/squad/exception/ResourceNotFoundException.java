package com.squadmind.squad.exception;

import java.io.Serial;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(){

    }

    public ResourceNotFoundException(Object message) {
        super(("Resource not found. Id" + message));
    }

}
