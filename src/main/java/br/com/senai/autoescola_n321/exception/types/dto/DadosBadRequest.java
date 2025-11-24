package br.com.senai.autoescola_n321.exception.types.dto;

import org.springframework.validation.FieldError;

public record DadosBadRequest(String campo, String mensagem) {
    public DadosBadRequest(FieldError erro) {
        this(
                erro.getField(),
                erro.getDefaultMessage()
        );
    }
}
