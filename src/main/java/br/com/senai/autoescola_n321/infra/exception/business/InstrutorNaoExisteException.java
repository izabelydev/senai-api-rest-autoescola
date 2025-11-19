package br.com.senai.autoescola_n321.infra.exception.business;

public class InstrutorNaoExisteException extends RuntimeException {
    public InstrutorNaoExisteException(String message) {
        super(message);
    }
}
