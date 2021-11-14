package ru.kyper.TestSwagger.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccessGroupNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccessGroupNotFoundException(Long id) {
        super("Could not find access group #" + id);
    }

}
