package br.com.senai.autoescola_n321.adapter.in.dto.usuario;

import br.com.senai.autoescola_n321.adapter.in.dto.usuario.enums.Perfil;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPerfilUsuario(

        @NotNull
        Long id,
        Perfil perfil
) {}
