package br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario;

import br.com.senai.autoescola_n321.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastramentoUsuario (
        @NotBlank
        String login,

        @NotBlank
        @Pattern(regexp = ".{8}")
        String senha,

        Perfil perfil
) { }
