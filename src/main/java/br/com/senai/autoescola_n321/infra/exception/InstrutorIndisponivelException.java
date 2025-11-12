package br.com.senai.autoescola_n321.infra.exception;

public class InstrutorIndisponivelException extends RuntimeException {
    public InstrutorIndisponivelException(String message) {
        super(message);
    }
}
