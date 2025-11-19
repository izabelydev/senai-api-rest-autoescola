package br.com.senai.autoescola_n321.adapter.in.controller.dto.request.instrucao;

import br.com.senai.autoescola_n321.application.core.domain.enums.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(
        @NotNull
        Long id,

        @NotNull
        MotivoCancelamento motivo
) {}
