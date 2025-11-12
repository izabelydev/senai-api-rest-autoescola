package br.com.senai.autoescola_n321.adapter.in.dto.instrucao;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.enums.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoInstrucao(

        @NotNull
        Long idAluno,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/mm/yyyy HH:mm")
        LocalDateTime data,

        Long idInstrutor,
        Especialidade especialidade
) {}
