package br.com.senai.autoescola_n321.adapter.in.dto.instrucao;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(
        @NotNull
        Long id
) {}
