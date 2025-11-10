package br.com.senai.autoescola_n321.adapter.in.dto.usuario;

import br.com.senai.autoescola_n321.adapter.in.dto.usuario.enums.Perfil;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoUsuario(

        @NotNull
        Long id,

        String login,

        @Pattern(regexp = ".{8}")
        String senha,

        Perfil perfil
) {}
