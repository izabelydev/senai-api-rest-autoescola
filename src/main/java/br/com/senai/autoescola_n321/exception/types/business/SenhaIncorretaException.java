package br.com.senai.autoescola_n321.exception.types.business;

public class SenhaIncorretaException extends RuntimeException {
    public SenhaIncorretaException(String message) {
        super(message);
    }
}
