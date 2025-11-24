package br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario;

import br.com.senai.autoescola_n321.application.core.domain.enums.Perfil;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPerfilUsuario(

        @NotNull
        Long id,
        Perfil perfil
) {}
