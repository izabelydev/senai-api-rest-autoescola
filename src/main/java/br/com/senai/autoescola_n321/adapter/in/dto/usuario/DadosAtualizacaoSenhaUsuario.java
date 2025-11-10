package br.com.senai.autoescola_n321.adapter.in.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoSenhaUsuario(

        @NotNull
        Long id,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String senhaAtual,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String novaSenha
) {}
