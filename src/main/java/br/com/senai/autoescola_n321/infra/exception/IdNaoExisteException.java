package br.com.senai.autoescola_n321.infra.exception;

public class IdNaoExisteException extends RuntimeException {
    public IdNaoExisteException(String message) {
        super(message);
    }
}
