package br.com.senai.autoescola_n321.exception.types.business;

public class InstrutorNaoExisteException extends RuntimeException {
    public InstrutorNaoExisteException(String message) {
        super(message);
    }
}
