package br.com.senai.autoescola_n321.exception.types.business;

public class AlunoNaoExisteException extends RuntimeException {
    public AlunoNaoExisteException(String message) {
        super(message);
    }
}
