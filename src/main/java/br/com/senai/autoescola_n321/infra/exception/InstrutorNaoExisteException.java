package br.com.senai.autoescola_n321.infra.exception;

public class InstrutorNaoExisteException extends RuntimeException {
    public InstrutorNaoExisteException(String message) {
        super(message);
    }
}
