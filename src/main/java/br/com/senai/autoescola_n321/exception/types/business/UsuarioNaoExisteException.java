package br.com.senai.autoescola_n321.exception.types.business;

public class UsuarioNaoExisteException extends RuntimeException {
    public UsuarioNaoExisteException(String message) {
        super(message);
    }
}
