package br.com.senai.autoescola_n321.infra.exception.validation;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}
