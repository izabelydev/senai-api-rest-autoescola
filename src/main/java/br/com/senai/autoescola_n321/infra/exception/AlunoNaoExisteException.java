package br.com.senai.autoescola_n321.infra.exception;

public class AlunoNaoExisteException extends RuntimeException {
    public AlunoNaoExisteException(String message) {
        super(message);
    }
}
