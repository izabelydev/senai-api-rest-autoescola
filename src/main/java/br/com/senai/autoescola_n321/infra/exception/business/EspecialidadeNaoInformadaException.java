package br.com.senai.autoescola_n321.infra.exception.business;

public class EspecialidadeNaoInformadaException extends RuntimeException {
    public EspecialidadeNaoInformadaException(String message) {
        super(message);
    }
}
