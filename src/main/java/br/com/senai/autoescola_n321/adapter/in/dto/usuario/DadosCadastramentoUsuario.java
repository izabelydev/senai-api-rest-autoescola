package br.com.senai.autoescola_n321.adapter.in.dto.usuario;

import br.com.senai.autoescola_n321.adapter.in.dto.usuario.enums.Perfil;
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
