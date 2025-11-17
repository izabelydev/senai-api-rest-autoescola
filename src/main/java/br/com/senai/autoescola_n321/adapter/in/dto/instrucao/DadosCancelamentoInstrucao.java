package br.com.senai.autoescola_n321.adapter.in.dto.instrucao;

import br.com.senai.autoescola_n321.adapter.in.dto.instrucao.enums.MotivoCancelamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(
        @NotNull
        Long id,

        @NotBlank
        MotivoCancelamento motivo
) {}
