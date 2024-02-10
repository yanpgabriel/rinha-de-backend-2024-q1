package dev.yanpgabriel.rinha.handlers;

import dev.yanpgabriel.rinha.exceptions.RegraDeNegocioException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RegraDeNegocioHandler implements ExceptionMapper<RegraDeNegocioException> {
    public Response toResponse(RegraDeNegocioException e) {
        return Response
                .status(422)
                .build();
    }
}
