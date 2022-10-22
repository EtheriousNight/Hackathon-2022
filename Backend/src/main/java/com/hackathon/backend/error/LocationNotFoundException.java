package com.hackathon.backend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String message) {
        super(message);
    }

}
