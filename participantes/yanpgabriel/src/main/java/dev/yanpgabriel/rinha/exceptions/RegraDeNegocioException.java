package dev.yanpgabriel.rinha.exceptions;

public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException() {
    }

    public RegraDeNegocioException(String message) {
        super(message);
    }
}
