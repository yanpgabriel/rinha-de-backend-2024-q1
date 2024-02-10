package dev.yanpgabriel.rinha.exceptions;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException() {
    }

    public NaoEncontradoException(String message) {
        super(message);
    }
}
