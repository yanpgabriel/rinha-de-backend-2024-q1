package dev.yanpgabriel.rinha.handlers;

import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationtHandler implements ExceptionMapper<ValidationException> {
    public Response toResponse(ValidationException e) {
        return Response
                .status(422)
                .build();
    }
}
