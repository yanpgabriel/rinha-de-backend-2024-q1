package dev.yanpgabriel.rinha.handlers;

import dev.yanpgabriel.rinha.exceptions.NaoEncontradoException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NaoEncontradoHandler implements ExceptionMapper<NaoEncontradoException> {
    public Response toResponse(NaoEncontradoException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }
}
