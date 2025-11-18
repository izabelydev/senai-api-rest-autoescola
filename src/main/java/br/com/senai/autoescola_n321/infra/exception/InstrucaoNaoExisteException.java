package br.com.senai.autoescola_n321.infra.exception;

public class InstrucaoNaoExisteException extends RuntimeException {
    public InstrucaoNaoExisteException(String message) {
        super(message);
    }
}
