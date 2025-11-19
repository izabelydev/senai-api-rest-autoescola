package br.com.senai.autoescola_n321.infra.exception.business;

public class InstrutorIndisponivelException extends RuntimeException {
    public InstrutorIndisponivelException(String message) {
        super(message);
    }
}
