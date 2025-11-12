package br.com.senai.autoescola_n321.infra.exception;

public class EspecialidadeNaoInformadaException extends RuntimeException {
    public EspecialidadeNaoInformadaException(String message) {
        super(message);
    }
}
