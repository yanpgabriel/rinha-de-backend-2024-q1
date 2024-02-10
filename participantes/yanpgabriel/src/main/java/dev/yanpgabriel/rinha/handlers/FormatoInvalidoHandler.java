package dev.yanpgabriel.rinha.handlers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FormatoInvalidoHandler implements ExceptionMapper<InvalidFormatException> {
    public Response toResponse(InvalidFormatException e) {
        return Response
                .status(422)
                .build();
    }
}
