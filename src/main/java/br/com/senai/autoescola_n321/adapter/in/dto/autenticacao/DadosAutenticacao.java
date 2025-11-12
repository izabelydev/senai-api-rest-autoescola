package br.com.senai.autoescola_n321.adapter.in.dto.autenticacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAutenticacao(

        @NotBlank
        String login,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String senha
) {
}
